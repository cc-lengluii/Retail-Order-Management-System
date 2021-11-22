/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Orders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import assignment.Customers.Customer;
import assignment.Customers.CustomerManager;
import assignment.Products.Product;
import assignment.Products.ProductManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class OrderManager {

    ArrayList<Order> orderList = new ArrayList<>();

    public String generateID() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("order.txt"));
            String last = "", line;
            String[] lineArr;
            while ((line = br.readLine()) != null) {
                last = line;
            }
            lineArr = last.split("\t");
            String newID = "O" + (String.format("%03d", Integer.parseInt(lineArr[0].substring(1, lineArr[0].length())) + 1));
            br.close();
            return newID;

        } catch (IOException e) {
        }
        return null;
    }

    public ArrayList<Order> read() throws IOException {

        try {
            BufferedReader br = new BufferedReader(new FileReader("order.txt"));
            String row;
            while ((row = br.readLine()) != null) {
                String data[] = row.split("\t");
                Customer customer = new CustomerManager().search(data[1]);
                String products[] = data[4].split("&");
                ArrayList<OrderItem> orderItemList = new ArrayList<>(); //new orderitem array list
                //how many order items per customer
                for (int i = 0; i < products.length; i++) {
                    String orderData[] = products[i].split(",");
                    Product product = new ProductManager().search(orderData[0]);
                    Order o = new Order();
                    o.orderItem.setOrderItem(product, Integer.parseInt(orderData[1]));
                    orderItemList.add(o.orderItem);
                }
                Order order = new Order(data[0], customer, data[2], data[3], Double.parseDouble(data[5]), orderItemList);
                orderList.add(order);
                orderItemList.trimToSize();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return orderList;
    }

    public void printOrder2File(ArrayList<Order> orderList) throws IOException {

        try {
            FileWriter fw = new FileWriter("order.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pr = new PrintWriter(bw);

            for (int i = 0; i < orderList.size(); i++) {
                pr.print(orderList.get(i).getOrderID() + "\t");
                pr.print(orderList.get(i).getCustomer().getCusID() + "\t");
                pr.print(orderList.get(i).getDate() + "\t");
                pr.print(orderList.get(i).getTime() + "\t");
                for (int items = 0; items < orderList.get(i).orderItems.size(); items++) {
                    pr.print(orderList.get(i).orderItems.get(items).getProduct().getProductID() + ",");
                    if (items == orderList.get(i).orderItems.size() - 1) {
                        pr.print(orderList.get(i).orderItems.get(items).getQuantity() + "\t");
                    } else {
                        pr.print(orderList.get(i).orderItems.get(items).getQuantity() + "&");
                    }
                }
                pr.println(orderList.get(i).getTotalPrice());
            }
            pr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

    }

    public Order search(String ID) throws IOException {
        OrderManager manager = new OrderManager();
        try {
            ArrayList<Order> orderList = manager.read();

            for (Order order : orderList) {
                if (order.getOrderID().equals(ID)) {
                    return order;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Orders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import assignment.Products.Product;
import assignment.Products.ProductManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CartManager {

    FileWriter fw;
    BufferedReader br;
    BufferedWriter bw;

    ArrayList<Cart> cartlist = new ArrayList<>();

    public ArrayList<Cart> readcart() throws IOException {

        try {
            br = new BufferedReader(new FileReader("cart.txt"));
            String row;
            while ((row = br.readLine()) != null) {
                String data[] = row.split("\t");
                String cusID = data[0];
                String data1[] = data[1].split(",");
                ArrayList<OrderItem> orderItemList = new ArrayList<>();

                for (int i = 0; i < data1.length; i++) {
                    String items[] = data1[i].split("&");
                    String productID = items[0];
                    String quantity = items[1];
                    Product product = new ProductManager().search(productID);
                    Cart o = new Cart();
                    o.orderItem.setOrderItem(product, Integer.parseInt(quantity));
                    orderItemList.add(o.orderItem);
                }
                Cart cart = new Cart(cusID, orderItemList);
                cartlist.add(cart);
            }
            br.close();
            return cartlist;

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return cartlist;
    }

    public void printCart2File(ArrayList<Cart> cartlist) throws IOException {
        try {
            fw = new FileWriter("cart.txt", false);
            bw = new BufferedWriter(fw);
            PrintWriter pr = new PrintWriter(bw);

            for (int i = 0; i < cartlist.size(); i++) {
                pr.print(cartlist.get(i).getCusID() + "\t");

                for (int j = 0; j < cartlist.get(i).orderItems.size(); j++) {
                    pr.print((cartlist.get(i).orderItems.get(j).getProduct().getProductID()
                            + "&" + cartlist.get(i).orderItems.get(j).getQuantity()));
                    if (j != cartlist.get(i).orderItems.size() - 1) {
                        pr.print(",");
                    } else {
                        pr.print("\n");
                    }
                }
            }
            pr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public Cart searchcart(String ID) throws IOException {
        CartManager manager = new CartManager();
        try {
            ArrayList<Cart> cartlist = manager.readcart();
            int i;
            for (i = 0; i < cartlist.size(); i++) {
                if (cartlist.get(i).getCusID().equals(ID)) {
                    return cartlist.get(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public int add(String ID, Product product, int quantity) throws IOException {
        CartManager manager = new CartManager();
        try {
            ArrayList<Cart> cartlist = manager.readcart();
            boolean f = true;
            boolean b = true;
            int i;
            for (i = 0; i < cartlist.size(); i++) {
                if (cartlist.get(i).getCusID().equals(ID)) {
                    b = false;
                    for (int j = 0; j < cartlist.get(i).orderItems.size(); j++) {
                        if (cartlist.get(i).orderItems.get(j).getProduct().getProductID().equals(product.getProductID())) {
                            f = false;
                        }
                    }
                    if (f == true) {
                        Cart o = new Cart();
                        o.orderItem.setOrderItem(product, quantity);
                        cartlist.get(i).orderItems.add(o.orderItem);
                        manager.printCart2File(cartlist);
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
            if (b == true) {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cart.txt", true)));
                out.println(ID + "\t" + product.getProductID() + "&" + quantity);
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void modify(String ID, Product product, int quantity) throws IOException {
        CartManager manager = new CartManager();

        ArrayList<Cart> cartlist = manager.readcart();
        int i;
        for (i = 0; i < cartlist.size(); i++) {
            if (cartlist.get(i).getCusID().equals(ID)) {
                for (int j = 0; j < cartlist.get(i).orderItems.size(); j++) {
                    if (cartlist.get(i).orderItems.get(j).getProduct().getProductID().equals(product.getProductID())) {
                        cartlist.get(i).orderItems.get(j).setQuantity(quantity);
                    }
                }
                manager.printCart2File(cartlist);
            }
        }
    }

    public void remove(String ID, Product product) throws IOException {
        CartManager manager = new CartManager();
        ArrayList<Cart> cartlist = manager.readcart();
        int i;
        for (i = 0; i < cartlist.size(); i++) {
            if (cartlist.get(i).getCusID().equals(ID)) {
                if (cartlist.get(i).orderItems.size() == 1) {
                    manager.delete(ID);
                } else {
                    for (int j = 0; j < cartlist.get(i).orderItems.size(); j++) {
                        if (cartlist.get(i).orderItems.get(j).getProduct().getProductID().equals(product.getProductID())) {
                            cartlist.get(i).orderItems.remove(j);
                            manager.printCart2File(cartlist);
                        }
                    }
                }
            }
        }
    }

    public void delete(String ID) {
        CartManager manager = new CartManager();
        try {
            ArrayList<Cart> cartlist = manager.readcart();
            int i;
            for (i = 0; i < cartlist.size(); i++) {
                if (cartlist.get(i).getCusID().equals(ID)) {
                    cartlist.remove(i);
                }
            }
            manager.printCart2File(cartlist);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

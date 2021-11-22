/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Orders;

import assignment.Customers.Customer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private String orderID;
    private Customer customer;
    private String date, time;
    public ArrayList<OrderItem> orderItems;
    private double totalPrice;
    public OrderItem orderItem;

    public Order() {
        this.orderItem = new OrderItem();
    }

    public Order(String orderID, Customer customer, String date, String time, double totalPrice, ArrayList<OrderItem> items) {
        this.orderID = orderID;
        this.customer = customer;
        this.date = date;
        this.time = time;
        this.totalPrice = totalPrice;
        this.orderItems = items;
    }

    public Order(Customer customer, ArrayList<OrderItem> items) {
        this.customer = customer;
        this.orderItems = items;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return orderID + "\t" + customer + "\t" + date + "\t" + time + "\t" + orderItems.toString() + "\t" + totalPrice;
    }

    public String DateGenerator() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();

        return (formatter.format(date));
    }

    public String TimeGenerator() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
        Date date = new Date();

        return (formatter.format(date));

    }

}

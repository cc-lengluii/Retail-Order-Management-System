/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Orders;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Cart {

    private String cusID;
    public ArrayList<OrderItem> orderItems;
    public OrderItem orderItem;

    public Cart() {
        this.orderItem = new OrderItem();
    }

    @Override
    public String toString() {
        return "Cart{" + "cusID=" + cusID + ", orderItems=" + orderItems;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Cart(String cusID, ArrayList<OrderItem> orderItems) {
        this.cusID = cusID;
        this.orderItems = orderItems;
    }
}

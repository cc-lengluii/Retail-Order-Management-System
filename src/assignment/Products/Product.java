/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Products;

public abstract class Product {

    protected String productID;
    protected String productName;
    protected String category;
    protected int stock;
    protected char type;
    protected double price, charge;

    public Product(String ID, String name, String category, int stock) {
        this.productID = ID;
        this.productName = name;
        this.category = category;
        this.stock = stock;
    }

    public Product(String name, String category, int stock) {
        this.productName = name;
        this.category = category;
        this.stock = stock;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public char getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double calculator(int quantity) {
        double total = quantity * price;
        return total;
    }

    abstract Double getCharge();

    abstract Double getTotalPrice();

    @Override
    public String toString() {
        return productID + "\t" + productName + "\t" + category + "\t" + type + "\t" + price + "\t" + stock;
    }

}

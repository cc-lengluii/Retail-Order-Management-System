package assignment.Orders;

import assignment.Products.Product;

public class OrderItem {

    private Product product;
    private int quantity;

    public void setOrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    } //getter for product

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return product + "\t" + quantity;
    }

}

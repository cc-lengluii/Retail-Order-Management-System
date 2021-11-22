/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Products;

public class FragileProduct extends Product {

    private final double rate = 1.1;

    public FragileProduct(String name, String category, int stock, double price) {
        super(name, category, stock);
        this.price = price;
        this.charge = rate;
        this.type = 'F';
    }

    public FragileProduct(String ID, String name, String category, int stock, double price) {
        super(ID, name, category, stock);
        this.price = price;
        this.charge = rate;
        this.type = 'F';
    }

    @Override
    public Double getCharge() {
        return charge;
    }

    @Override
    public Double getTotalPrice() {
        double total = (double) Math.round(price * charge * 100) / 100;
        return total;
    }

}

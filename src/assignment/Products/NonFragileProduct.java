/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Products;

/**
 *
 * @author User
 */
public class NonFragileProduct extends Product {

    private final double rate = 1;

    public NonFragileProduct(String ID, String name, String category, int stock, double price) {
        super(ID, name, category, stock);
        this.price = price;
        this.charge = rate;
        this.type = 'N';

    }

    public NonFragileProduct(String name, String category, int stock, double price) {
        super(name, category, stock);
        this.price = price;
        this.charge = rate;
        this.type = 'N';

    }

    @Override
    public Double getCharge() {
        return charge;
    }

    @Override
    public Double getTotalPrice() {
        return price * charge;
    }

}

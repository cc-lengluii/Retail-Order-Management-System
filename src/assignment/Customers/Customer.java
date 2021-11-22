/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Customers;

import assignment.Users.User;

public class Customer extends User {

    private String cusID;
    public Name name;
    public Address address;
    private String phoneNo;
    private char gender;
    private String email;

    public Customer() {
        name = new Name();
        address = new Address();
    }

    public Customer(String username, String password, String phoneNo, char gender, String email) {
        super(username, password);
        name = new Name();
        address = new Address();
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.email = email;
    }

    public Customer(String cusID, String phoneNo, char gender, String email) {
        name = new Name();
        address = new Address();
        this.cusID = cusID;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.email = email;
    }

    public String getCusID() {
        return cusID;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String CustDetails() {
        return cusID + "\t" + name + "\t" + gender + "\t" + phoneNo + "\t" + email + "\t" + address;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return cusID + "\t" + name + "\t" + gender + "\t" + phoneNo + "\t" + email + "\t" + address;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Customers;

/**
 *
 * @author User
 */
public class Address {

    private String streetNo;
    private String streetName;
    private String city;
    private String state;
    private String postcode;
    private String country;

    public String getStreetNo() {
        return streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return streetNo + "  " + streetName + "  " + city + "  " + state + "  " + postcode + "  " + country;
    }

    public String getFullAddress() {
        return streetNo + "," + streetName + "," + city + "," + state + "," + postcode + "," + country;
    }

    public void setAddress(String A, String B, String C, String D, String E, String F) {
        streetNo = A;
        streetName = B;
        city = C;
        state = D;
        postcode = E;
        country = F;
    }
}

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
public class Name {

    private String fName;
    private String lName;

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setName(String A, String B) {
        fName = A;
        lName = B;
    }

    public String getName() {
        return fName + "  " + lName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String toString() {
        return fName + "  " + lName;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Customers;

import assignment.Users.DuplicateUsernameException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
 *
 * @author User
 */
public class CustomerManager {

    FileReader fr;
    FileWriter fw;
    FileWriter fw2;
    BufferedReader br;
    BufferedReader br2;
    BufferedWriter bw;
    BufferedWriter bw2;

    private String username;

    private void checkDuplicate(Customer c) throws DuplicateUsernameException {
        try {
            fr = new FileReader("password.txt");
            br = new BufferedReader(fr);
            String row;
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\t");
                username = data[1];
                if (username.equals(c.getUsername())) {
                    throw new DuplicateUsernameException();
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void addCustomer(Customer c) throws DuplicateUsernameException {
        checkDuplicate(c);
        try {
            fw = new FileWriter("password.txt", true);
            bw = new BufferedWriter(fw);

            bw.write(c.getCusID() + "\t" + c.getUsername() + "\t" + c.getPassword());
            bw.write(System.getProperty("line.separator"));

            fw2 = new FileWriter("customer.txt", true);
            bw2 = new BufferedWriter(fw2);

            fw2.write(c.CustDetails());
            bw2.write(System.getProperty("line.separator"));

            bw.close();
            bw2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String generateID() {
        try {
            br = new BufferedReader(new FileReader("customer.txt"));
            String last = "", line;
            String[] lineArr;
            while ((line = br.readLine()) != null) {
                last = line;
            }
            lineArr = last.split("\t");
            String newID = "C" + (String.format("%03d", Integer.parseInt(lineArr[0].substring(1, lineArr[0].length())) + 1));
            br.close();
            return newID;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Customer> read() throws IOException {
        ArrayList<Customer> customerList = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("customer.txt"));
            String row;
            while ((row = br.readLine()) != null) {
                String data[] = row.split("\t");
                String name[] = data[1].split("  ");
                String address[] = data[5].split("  ");
                Customer customer = new Customer(data[0], data[3], data[2].charAt(0), data[4]);
                customer.name.setName(name[0], name[1]);
                customer.address.setAddress(address[0], address[1], address[2], address[3], address[4], address[5]);
                //Add object to list
                customerList.add(customer);

            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return (customerList);
    }

    public Customer search(String ID) {
        CustomerManager manager = new CustomerManager();
        try {
            ArrayList<Customer> customerList = manager.read();
            for (Customer customer : customerList) {
                if (customer.getCusID().equals(ID)) {
                    return customer;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void printCustList2File(ArrayList<Customer> customerList) throws IOException {

        try {
            fw = new FileWriter("customer.txt", false);
            bw = new BufferedWriter(fw);
            PrintWriter pr = new PrintWriter(bw);

            for (int i = 0; i < customerList.size(); i++) {
                pr.println(customerList.get(i));
            }
            pr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

    }

    public boolean isStringNumeric(String number) {
        boolean isNumeric;
        if (number == null) {
            isNumeric = false;
        } else {
            try {
                Double num = Double.parseDouble(number);
                isNumeric = false;
            } catch (NumberFormatException e) {
                isNumeric = true;
            }
        }
        return isNumeric;
    }

}

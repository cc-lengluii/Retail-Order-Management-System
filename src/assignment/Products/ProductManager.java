/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Products;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ProductManager {

    ArrayList<Product> productList = new ArrayList<>();

    public String generateProID() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("product.txt"));
            String last = "", line;
            String[] lineArr;
            while ((line = br.readLine()) != null) {
                last = line;
            }
            lineArr = last.split("\t");
            String newID = "P" + (String.format("%03d", Integer.parseInt(lineArr[0].substring(1, lineArr[0].length())) + 1));
            br.close();
            return newID;

        } catch (IOException e) {
            System.out.println("Error");
        }

        return null;
    }

    public void printProList2File(ArrayList<Product> productList) throws IOException {

        try {
            FileWriter fw = new FileWriter("product.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pr = new PrintWriter(bw);

            for (int i = 0; i < productList.size(); i++) {
                pr.println(productList.get(i));
            }
            pr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

    }

    public ArrayList<Product> read() throws IOException {

        File file = new File("product.txt");
        try {
            Scanner Sc = new Scanner(file);

            while (Sc.hasNextLine()) {
                String data[] = Sc.nextLine().split("\t");

                if (data[3].charAt(0) == 'F') {
                    FragileProduct product = new FragileProduct(data[0], data[1], data[2], Integer.parseInt(data[5]), Double.parseDouble(data[4]));
                    productList.add(product);
                }
                if (data[3].charAt(0) == 'N') {
                    NonFragileProduct product = new NonFragileProduct(data[0], data[1], data[2], Integer.parseInt(data[5]), Double.parseDouble(data[4]));
                    productList.add(product);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        return (productList);
    }

    public Product search(String ID) throws IOException {
        ProductManager manager = new ProductManager();
        try {
            ArrayList<Product> productList = manager.read();

            for (Product product : productList) {
                if (product.getProductID().equals(ID)) {
                    return product;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}

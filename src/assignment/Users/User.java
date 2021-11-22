/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.Users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class User {

    FileReader fr;
    FileWriter fw;
    BufferedReader br;
    BufferedWriter bw;

    private String username;
    private String password;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public User() {
    }

    ;
   public User(String ID, String username, String password) {
        this.username = username;
        this.password = password;
        this.ID = ID;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return ID + "\t" + username + "\t" + password;
    }

    private void checkDuplicate(User u) throws DuplicateUsernameException {
        try {
            fr = new FileReader("password.txt");
            br = new BufferedReader(fr);
            String row;
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\t");
                username = data[1];
                if (username.equals(u.getUsername())) {
                    throw new DuplicateUsernameException();
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public int login(String username, String password) throws IOException {
        int found = 0;
        String tempUsername;
        String tempPassword;
        User user = new User();
        ArrayList<User> userList = user.read();
        for (int i = 0; i < userList.size(); i++) {
            tempUsername = userList.get(i).getUsername();
            tempPassword = userList.get(i).getPassword();
            if (username.equals("admin") && userList.get(0).getPassword().equals(password)) {
                return found = 1;
            }
            if (tempUsername.equals(username) && tempPassword.equals(password)) {
                new User().printtemp(userList.get(i).getID());
                return found = 2;
            }
        }
        return found;
    }

    public static boolean validatePass(String password) {
        if (password.length() > 7) {
            boolean hasNum = false, hasCap = false, hasLow = false, hasSym = false;
            char c;
            for (int i = 0; i < password.length(); i++) {
                c = password.charAt(i);
                if (Character.isDigit(c)) {
                    hasNum = true;
                } else if (Character.isUpperCase(c)) {
                    hasCap = true;
                } else if (Character.isLowerCase(c)) {
                    hasLow = true;
                } else if (!Character.isLetter(c) && !Character.isDigit(c)) {
                    hasSym = true;
                }
            }
            if (!hasNum || !hasCap || !hasLow || !hasSym) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> read() throws IOException {
        ArrayList<User> userList = new ArrayList<>();
        try {
            String row;
            br = new BufferedReader(new FileReader("password.txt"));
            while ((row = br.readLine()) != null) {

                String data[] = row.split("\t");
                User user = new User(data[0], data[1], data[2]);
                userList.add(user);
            }
            br.close();
        } catch (FileNotFoundException e) {
        }
        return (userList);

    }

    public void delete(String ID) {
        try {

            User user = new User();
            ArrayList<User> userList = user.read();

            Iterator<User> c = userList.iterator();
            while (c.hasNext()) {
                String id = c.next().getID();
                if (id.equals(ID)) {
                    c.remove();
                }
            }
            user.printUser2File(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modfiy(String ID, String username, String password) {
        try {

            User user = new User();
            ArrayList<User> userList = user.read();

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getID().equals(ID)) {
                    userList.get(i).setID(username);
                    userList.get(i).setID(password);
                }
            }

            user.printUser2File(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printUser2File(ArrayList<User> userList) throws DuplicateUsernameException {
        try {
            fw = new FileWriter("password.txt", false);
            bw = new BufferedWriter(fw);
            PrintWriter pr = new PrintWriter(bw);

            for (int i = 0; i < userList.size(); i++) {
                pr.println(userList.get(i));
            }
            pr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public void printUser2File(ArrayList<User> userList, int selectedRow) throws DuplicateUsernameException {
        checkDuplicate(userList.get(selectedRow));
        try {
            fw = new FileWriter("password.txt", false);
            bw = new BufferedWriter(fw);
            PrintWriter pr = new PrintWriter(bw);

            for (int i = 0; i < userList.size(); i++) {
                pr.println(userList.get(i));
            }
            pr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public User search(String ID) throws IOException {
        try {
            User user = new User();
            ArrayList<User> userList = user.read();
            int i;
            for (i = 0; i < userList.size(); i++) {
                if (userList.get(i).getID().equals(ID)) {
                    return userList.get(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public String readtemp() throws IOException {
        br = new BufferedReader(new FileReader("temp.txt"));
        String cusID = br.readLine();
        br.close();
        return cusID;

    }

    public void printtemp(String cusID) throws IOException {
        try {
            fw = new FileWriter("temp.txt", false);
            bw = new BufferedWriter(fw);
            bw.write(cusID);
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}

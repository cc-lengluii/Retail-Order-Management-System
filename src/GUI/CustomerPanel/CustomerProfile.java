/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.CustomerPanel;

import GUI.LoginPage;
import assignment.Customers.Customer;
import assignment.Customers.CustomerManager;
import assignment.Users.DuplicateUsernameException;
import assignment.Users.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author user
 */
public class CustomerProfile extends javax.swing.JFrame {

    /**
     * Creates new form CustomerProfile
     */
    public CustomerProfile() {
        initComponents();
        this.setLocationRelativeTo(null);
        AutoCompleteDecorator.decorate(jcbCity);
        AutoCompleteDecorator.decorate(jcbState);
        AutoCompleteDecorator.decorate(jcbZip);
        AutoCompleteDecorator.decorate(jcbCountry);
        try {
            String cusID = new User().readtemp();
            Customer o = new CustomerManager().search(cusID);
            lblusername.setText(o.name.getfName().toUpperCase());
            displayCustomerDetails();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    public void displayCustomerDetails() {

        String cusID;
        try {
            cusID = new User().readtemp();

            Customer o = new CustomerManager().search(cusID);
            User u = new User().search(cusID);
            usernameTxt.setText(u.getUsername());
            passwordTxt.setText(u.getPassword());
            comfirmPassTxt.setText(u.getPassword());
            firstNameTxt.setText(o.name.getfName());
            lastNameTxt.setText(o.name.getlName());
            if (String.valueOf(o.getGender()).equals("M")) {
                maleRbtn.setSelected(true);
            } else {
                femaleRbtn.setSelected(true);
            }
            mobileNoTxt.setText(o.getPhoneNo());
            emailTxt.setText(o.getEmail());
            streetNoTxt.setText(o.address.getStreetNo());
            streetNameTxt.setText(o.address.getStreetName());
            jcbCity.setSelectedItem(o.address.getCity());
            jcbState.setSelectedItem(o.address.getState());
            jcbZip.setSelectedItem(o.address.getPostcode());
            jcbCountry.setSelectedItem(o.address.getCountry());
        } catch (IOException ex) {
            System.out.println("Error");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Background = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCart = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnOrder = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnProfile = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLogout1 = new javax.swing.JLabel();
        Rightpanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Panel = new javax.swing.JPanel();
        lastNameTxt = new javax.swing.JTextField();
        firstNameTxt = new javax.swing.JTextField();
        mobileNoTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        signUpBtn = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblComfirmPass = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        streetNoTxt = new javax.swing.JTextField();
        streetNameTxt = new javax.swing.JTextField();
        lblStreetNo = new javax.swing.JLabel();
        lblStreetName = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblPostCode = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblMobileNo = new javax.swing.JLabel();
        comfirmPassTxt = new javax.swing.JPasswordField();
        lblEmail = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        lblGender = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        maleRbtn = new javax.swing.JRadioButton();
        femaleRbtn = new javax.swing.JRadioButton();
        jcbZip = new javax.swing.JComboBox<>();
        jcbState = new javax.swing.JComboBox<>();
        jcbCity = new javax.swing.JComboBox<>();
        jcbCountry = new javax.swing.JComboBox<>();
        lblusername = new javax.swing.JLabel();
        lblAdmin3 = new javax.swing.JLabel();
        Roundcorner = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(255, 110, 109));
        Background.setPreferredSize(new java.awt.Dimension(1160, 660));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LeftPanel.setBackground(new java.awt.Color(255, 110, 109));
        LeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 110, 109));

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnHome.setForeground(new java.awt.Color(245, 196, 196));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home grey.png"))); // NOI18N
        btnHome.setText(" HOME");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addGap(76, 76, 76))
        );

        LeftPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 210, 60));

        jPanel2.setBackground(new java.awt.Color(255, 110, 109));

        btnCart.setBackground(new java.awt.Color(255, 255, 255));
        btnCart.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnCart.setForeground(new java.awt.Color(245, 196, 196));
        btnCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cart grey.png"))); // NOI18N
        btnCart.setText("  CART");
        btnCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCartMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(btnCart)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCart)
                .addGap(76, 76, 76))
        );

        LeftPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 60));

        jPanel3.setBackground(new java.awt.Color(255, 110, 109));

        btnOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnOrder.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(245, 196, 196));
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/order grey.png"))); // NOI18N
        btnOrder.setText(" ORDER");
        btnOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOrder)
                .addContainerGap())
        );

        LeftPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, 60));

        jPanel4.setBackground(new java.awt.Color(255, 110, 109));

        btnProfile.setBackground(new java.awt.Color(255, 255, 255));
        btnProfile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/profile.png"))); // NOI18N
        btnProfile.setText(" EDIT PROFILE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        LeftPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/shopvus.png"))); // NOI18N
        LeftPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 80));

        btnLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sign out.png"))); // NOI18N
        btnLogout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogout1btnLogoutMouseClicked(evt);
            }
        });
        LeftPanel.add(btnLogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 40, 50));

        Background.add(LeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 660));

        Rightpanel.setBackground(new java.awt.Color(254, 242, 242));
        Rightpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(89, 89, 89));
        jLabel11.setText("EDIT PROFILE");
        Rightpanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/myprofile.png"))); // NOI18N
        Rightpanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 60, 60));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/admin avatar.png"))); // NOI18N
        Rightpanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, 50));

        Panel.setBackground(new java.awt.Color(254, 242, 242));
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lastNameTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Panel.add(lastNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 180, 30));

        firstNameTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Panel.add(firstNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 190, 30));

        mobileNoTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Panel.add(mobileNoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 180, 30));

        emailTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Panel.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 180, 30));

        signUpBtn.setBackground(new java.awt.Color(0, 153, 51));
        signUpBtn.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 14)); // NOI18N
        signUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        signUpBtn.setText("SAVE");
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });
        Panel.add(signUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, 120, 40));

        lblUsername.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsername.setText("Username");
        Panel.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 20));

        lblPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPassword.setText("Password");
        Panel.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 20));

        lblComfirmPass.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblComfirmPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblComfirmPass.setText("Comfirm Password");
        Panel.add(lblComfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 180, 30));

        lblAddress.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddress.setText("Address");
        Panel.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 100, 20));

        streetNoTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Panel.add(streetNoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 110, 30));

        streetNameTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Panel.add(streetNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 490, 30));

        lblStreetNo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblStreetNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStreetNo.setText("Street No.");
        Panel.add(lblStreetNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 90, 20));

        lblStreetName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblStreetName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStreetName.setText("Street Name");
        Panel.add(lblStreetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 110, 20));

        lblCity.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCity.setText("City");
        Panel.add(lblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 60, 20));

        lblState.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblState.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblState.setText("State");
        Panel.add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 70, 20));

        lblName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName.setText("Full Name");
        Panel.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 110, 20));

        lblFirstName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFirstName.setText("First Name");
        Panel.add(lblFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 90, 20));

        lblPostCode.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPostCode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPostCode.setText("Postal /Zip Code");
        Panel.add(lblPostCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 110, 20));

        lblLastName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLastName.setText("Last Name");
        Panel.add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 90, 20));

        lblCountry.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCountry.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCountry.setText("Country");
        Panel.add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 90, 30));

        lblMobileNo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblMobileNo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMobileNo.setText("Mobile Number");
        Panel.add(lblMobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, 20));

        comfirmPassTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Panel.add(comfirmPassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 190, 30));

        lblEmail.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmail.setText("E-mail");
        Panel.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 80, 20));

        passwordTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Panel.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 190, 30));

        lblGender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblGender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGender.setText("Gender");
        Panel.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 70, 30));

        usernameTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Panel.add(usernameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 190, 30));

        maleRbtn.setBackground(new java.awt.Color(254, 242, 242));
        buttonGroup1.add(maleRbtn);
        maleRbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        maleRbtn.setText("Male");
        Panel.add(maleRbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 130, 30));

        femaleRbtn.setBackground(new java.awt.Color(254, 242, 242));
        buttonGroup1.add(femaleRbtn);
        femaleRbtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        femaleRbtn.setText("Female");
        Panel.add(femaleRbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 130, 30));

        jcbZip.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jcbZip.setForeground(new java.awt.Color(255, 110, 109));
        jcbZip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1000", "1007", "1009", "1500", "1502", "1503", "1504", "1505", "1506", "1508", "1512", "1514", "1516", "1517", "1518", "1524", "1529", "1532", "1538", "1540", "1546", "1550", "1551", "1556", "1560", "1564", "1570", "1572", "1576", "1578", "1582", "1586", "1590", "1592", "1594", "1596", "1598", "1600", "1604", "1606", "1608", "1609", "1610", "1612", "1614", "1620", "1622", "1626", "1628", "1630", "1632", "1634", "1644", "1646", "1648", "1660", "1664", "1670", "1672", "1673", "1674", "1676", "1680", "1694", "2000", "2100", "2200", "2400", "2450", "2500", "2600", "2607", "2609", "2700", "2707", "2709", "2800", "5000", "5050", "5100", "5150", "5200", "5250", "5300", "5350", "5400", "5460", "5500", "5502", "5503", "5504", "5505", "5506", "5508", "5512", "5514", "5516", "5517", "5518", "5520", "5532", "5534", "5536", "5538", "5550", "5551", "5552", "5556", "5558", "5560", "5564", "5576", "5578", "5580", "5582", "5586", "5590", "5592", "5594", "5600", "5604", "5610", "5612", "5614", "5620", "5621", "5622", "5626", "5628", "5630", "5632", "5644", "5660", "5661", "5664", "5670", "5672", "5673", "5674", "5675", "5676", "5680", "5690", "5696", "5700", "5710", "5720", "5990", "6000", "6007", "6009", "6010", "6050", "6100", "6150", "6200", "6207", "6209", "6250", "6300", "6350", "6400", "6500", "6507", "6509", "6550", "6570", "6600", "6650", "6660", "6700", "6707", "6709", "6710", "6720", "6750", "6800", "6900", "6910", "7000", "7007", "7009", "8000", "8007", "8009", "8010", "8100", "8110", "8200", "8210", "8300", "8320", "8330", "8340", "8400", "8407", "8409", "8500", "8507", "8509", "8600", "8700", "8800", "9000", "9007", "9009", "9010", "9020", "9100", "9110", "9200", "9300", "9310", "9400", "9410", "9600", "9700", "9800", "9810", "10000", "10050", "10100", "10150", "10200", "10250", "10300", "10350", "10400", "10450", "10460", "10470", "10500", "10502", "10503", "10504", "10505", "10506", "10508", "10512", "10514", "10516", "10518", "10524", "10534", "10538", "10540", "10542", "10546", "10550", "10551", "10552", "10558", "10560", "10564", "10566", "10570", "10576", "10578", "10582", "10590", "10592", "10593", "10594", "10596", "10600", "10604", "10609", "10610", "10612", "10620", "10622", "10626", "10628", "10634", "10646", "10648", "10660", "10661", "10662", "10670", "10672", "10673", "10674", "10676", "10690", "10710", "10720", "10730", "10740", "10750", "10760", "10770", "10780", "10790", "10800", "10810", "10820", "10830", "10840", "10850", "10910", "10920", "10990", "11000", "11010", "11020", "11050", "11060", "11100", "11200", "11300", "11400", "11409", "11500", "11600", "11609", "11700", "11800", "11900", "11910", "11920", "11950", "11960", "12000", "12100", "12200", "12300", "12700", "12710", "12720", "12990", "13000", "13009", "13020", "13050", "13100", "13110", "13200", "13210", "13220", "13300", "13310", "13400", "13409", "13500", "13600", "13700", "13800", "14000", "14007", "14009", "14020", "14100", "14101", "14110", "14120", "14200", "14290", "14300", "14310", "14320", "14390", "14400", "15000", "15050", "15100", "15150", "15159", "15200", "15300", "15350", "15400", "15500", "15502", "15503", "15504", "15505", "15506", "15508", "15512", "15514", "15516", "15517", "15518", "15519", "15520", "15524", "15529", "15532", "15534", "15536", "15538", "15540", "15546", "15548", "15550", "15551", "15556", "15558", "15560", "15564", "15570", "15572", "15576", "15578", "15582", "15586", "15590", "15592", "15594", "15596", "15600", "15604", "15608", "15609", "15612", "15614", "15616", "15622", "15623", "15626", "15628", "15630", "15632", "15634", "15644", "15646", "15648", "15658", "15660", "15661", "15664", "15670", "15672", "15673", "15674", "15676", "15680", "15690", "15710", "15720", "15730", "15740", "15988", "15990", "16010", "16020", "16030", "16040", "16050", "16060", "16070", "16080", "16090", "16100", "16109", "16150", "16200", "16210", "16250", "16300", "16310", "16320", "16400", "16450", "16500", "16600", "16700", "16800", "16810", "17000", "17007", "17009", "17010", "17020", "17030", "17040", "17050", "17060", "17070", "17200", "17500", "17507", "17509", "17510", "17600", "17610", "17700", "18000", "18050", "18200", "18300", "18400", "18500", "20000", "20050", "20100", "20200", "20300", "20400", "20500", "20502", "20503", "20504", "20505", "20506", "20508", "20512", "20514", "20516", "20517", "20518", "20519", "20520", "20532", "20534", "20536", "20538", "20540", "20542", "20546", "20548", "20550", "20551", "20552", "20554", "20556", "20560", "20564", "20566", "20568", "20570", "20572", "20576", "20578", "20582", "20586", "20590", "20592", "20596", "20600", "20604", "20606", "20608", "20609", "20610", "20612", "20614", "20618", "20620", "20622", "20626", "20628", "20630", "20632", "20646", "20648", "20656", "20658", "20660", "20661", "20662", "20664", "20668", "20670", "20672", "20673", "20674", "20676", "20680", "20690", "20698", "20700", "20710", "20720", "20900", "20902", "20904", "20906", "20908", "20910", "20912", "20914", "20916", "20918", "20920", "20922", "20924", "20926", "20928", "20930", "20990", "21000", "21009", "21010", "21020", "21030", "21040", "21060", "21070", "21080", "21090", "21100", "21109", "21200", "21209", "21210", "21220", "21300", "21309", "21400", "21450", "21500", "21600", "21610", "21700", "21800", "21810", "21820", "22000", "22010", "22020", "22100", "22107", "22109", "22110", "22120", "22200", "22300", "22307", "22309", "23000", "23007", "23009", "23050", "23100", "23200", "23300", "23400", "24000", "24007", "24009", "24050", "24060", "24100", "24107", "24109", "24200", "24207", "24209", "24300", "25000", "25050", "25100", "25150", "25200", "25250", "25300", "25350", "25500", "25502", "25503", "25504", "25505", "25506", "25508", "25509", "25512", "25514", "25516", "25517", "25518", "25520", "25524", "25529", "25532", "25534", "25536", "25538", "25540", "25546", "25548", "25550", "25551", "25552", "25556", "25558", "25560", "25564", "25570", "25576", "25578", "25582", "25584", "25586", "25590", "25592", "25594", "25596", "25598", "25600", "25604", "25606", "25608", "25609", "25610", "25612", "25614", "25620", "25622", "25626", "25628", "25630", "25632", "25644", "25646", "25648", "25656", "25660", "25661", "25662", "25670", "25672", "25673", "25674", "25676", "25690", "25700", "25710", "25720", "25730", "25740", "25750", "25990", "26010", "26040", "26050", "26060", "26070", "26080", "26090", "26100", "26140", "26150", "26180", "26190", "26200", "26250", "26300", "26310", "26320", "26330", "26340", "26350", "26360", "26370", "26400", "26410", "26420", "26430", "26440", "26450", "26460", "26485", "26490", "26500", "26600", "26607", "26609", "26610", "26620", "26630", "26640", "26650", "26660", "26680", "26690", "26700", "26800", "26810", "26820", "26900", "27000", "27010", "27020", "27030", "27040", "27050", "27060", "27070", "27090", "27100", "27150", "27200", "27207", "27209", "27210", "27300", "27310", "27400", "27600", "27607", "27609", "27610", "27620", "27630", "27650", "27660", "27670", "28000", "28007", "28009", "28010", "28020", "28030", "28040", "28050", "28100", "28200", "28300", "28310", "28320", "28330", "28340", "28380", "28400", "28407", "28409", "28500", "28600", "28610", "28620", "28700", "28707", "28709", "28730", "28740", "28750", "28800", "30000", "30010", "30020", "30100", "30200", "30250", "30300", "30350", "30450", "30500", "30502", "30503", "30504", "30505", "30506", "30508", "30510", "30512", "30516", "30517", "30518", "30519", "30520", "30524", "30532", "30534", "30536", "30540", "30542", "30546", "30548", "30550", "30551", "30552", "30554", "30556", "30560", "30564", "30570", "30576", "30580", "30582", "30586", "30590", "30592", "30594", "30596", "30600", "30604", "30606", "30609", "30610", "30612", "30614", "30620", "30621", "30622", "30626", "30628", "30630", "30632", "30634", "30644", "30646", "30648", "30656", "30658", "30660", "30661", "30662", "30664", "30668", "30670", "30673", "30674", "30676", "30682", "30690", "30700", "30710", "30720", "30730", "30740", "30750", "30760", "30770", "30780", "30790", "30800", "30810", "30820", "30830", "30840", "30900", "30902", "30904", "30906", "30908", "30910", "30912", "30988", "30990", "31000", "31007", "31009", "31050", "31100", "31150", "31200", "31250", "31300", "31350", "31400", "31407", "31409", "31450", "31500", "31550", "31560", "31600", "31610", "31650", "31700", "31750", "31800", "31850", "31900", "31907", "31909", "31910", "31920", "31950", "32000", "32040", "32100", "32200", "32300", "32400", "32500", "32600", "32610", "32700", "32800", "32900", "33000", "33007", "33009", "33010", "33020", "33030", "33040", "33100", "33200", "33300", "33310", "33320", "33400", "33410", "33420", "33500", "33600", "33700", "33800", "34000", "34007", "34008", "34009", "34010", "34020", "34030", "34100", "34120", "34130", "34140", "34200", "34250", "34300", "34310", "34350", "34400", "34500", "34510", "34520", "34600", "34650", "34700", "34750", "34800", "34850", "34900", "34950", "35000", "35007", "35009", "35300", "35350", "35400", "35500", "35600", "35700", "35800", "35820", "35900", "35907", "35909", "35910", "35950", "36000", "36007", "36008", "36009", "36010", "36020", "36030", "36100", "36110", "36200", "36207", "36209", "36300", "36307", "36309", "36400", "36500", "36600", "36700", "36750", "36800", "36810", "39000", "39007", "39009", "39010", "39100", "39200", "40000", "40100", "40150", "40160", "40170", "40200", "40300", "40400", "40450", "40460", "40470", "40500", "40502", "40503", "40505", "40512", "40517", "40520", "40529", "40542", "40548", "40550", "40551", "40560", "40564", "40570", "40572", "40576", "40578", "40582", "40590", "40592", "40594", "40596", "40598", "40604", "40607", "40608", "40610", "40612", "40620", "40622", "40626", "40632", "40646", "40648", "40660", "40664", "40670", "40672", "40673", "40674", "40675", "40676", "40680", "40690", "40700", "40702", "40704", "40706", "40708", "40710", "40712", "40714", "40716", "40718", "40720", "40722", "40724", "40726", "40728", "40730", "40732", "40800", "40802", "40804", "40806", "40808", "40810", "40990", "41000", "41050", "41100", "41150", "41200", "41250", "41300", "41400", "41506", "41560", "41586", "41672", "41700", "41710", "41720", "41900", "41902", "41904", "41906", "41908", "41910", "41912", "41914", "41916", "41918", "41990", "42000", "42009", "42100", "42200", "42300", "42425", "42500", "42507", "42509", "42600", "42610", "42700", "42800", "42920", "42940", "42960", "43000", "43007", "43009", "43100", "43200", "43207", "43300", "43400", "43500", "43558", "43600", "43650", "43700", "43800", "43807", "43900", "43950", "44000", "44010", "44020", "44100", "44110", "44200", "44300", "45000", "45100", "45200", "45207", "45209", "45300", "45400", "45500", "45600", "45607", "45609", "45620", "45700", "45800", "46000", "46050", "46100", "46150", "46200", "46300", "46350", "46400", "46506", "46547", "46549", "46551", "46564", "46582", "46598", "46662", "46667", "46668", "46672", "46675", "46700", "46710", "46720", "46730", "46740", "46750", "46760", "46770", "46780", "46781", "46782", "46783", "46784", "46785", "46786", "46787", "46788", "46789", "46790", "46791", "46792", "46793", "46794", "46795", "46796", "46797", "46798", "46799", "46800", "46801", "46802", "46803", "46804", "46805", "46806", "46860", "46870", "46960", "46962", "46964", "46966", "46968", "46970", "46972", "46974", "46976", "46978", "47000", "47100", "47110", "47120", "47130", "47140", "47150", "47160", "47170", "47180", "47190", "47200", "47300", "47301", "47307", "47308", "47400", "47410", "47500", "47507", "47600", "47610", "47620", "47630", "47640", "47650", "47800", "47810", "47820", "47830", "48000", "48010", "48020", "48050", "48100", "48200", "48300", "49000", "50000", "50050", "50088", "50100", "50150", "50200", "50250", "50300", "50350", "50400", "50450", "50460", "50470", "50480", "50490", "50500", "50502", "50504", "50505", "50506", "50507", "50508", "50512", "50514", "50515", "50519", "50528", "50529", "50530", "50532", "50534", "50536", "50540", "50544", "50546", "50548", "50550", "50551", "50552", "50554", "50556", "50560", "50562", "50564", "50566", "50568", "50572", "50576", "50578", "50580", "50582", "50586", "50588", "50590", "50592", "50594", "50596", "50598", "50599", "50600", "50603", "50604", "50605", "50608", "50609", "50610", "50612", "50614", "50620", "50621", "50622", "50623", "50626", "50632", "50634", "50636", "50638", "50640", "50642", "50644", "50646", "50648", "50650", "50652", "50653", "50656", "50658", "50660", "50661", "50662", "50664", "50666", "50668", "50670", "50672", "50673", "50676", "50677", "50678", "50680", "50682", "50684", "50688", "50694", "50700", "50702", "50704", "50706", "50708", "50710", "50712", "50714", "50716", "50718", "50720", "50722", "50724", "50726", "50728", "50730", "50732", "50734", "50736", "50738", "50740", "50742", "50744", "50746", "50748", "50750", "50752", "50754", "50758", "50760", "50762", "50764", "50766", "50768", "50770", "50772", "50774", "50776", "50778", "50780", "50782", "50784", "50786", "50788", "50790", "50792", "50794", "50796", "50798", "50800", "50802", "50804", "50806", "50808", "50810", "50812", "50814", "50816", "50818", "50901", "50902", "50903", "50904", "50906", "50907", "50908", "50909", "50910", "50911", "50912", "50913", "50914", "50915", "50916", "50917", "50918", "50919", "50920", "50921", "50922", "50923", "50924", "50925", "50926", "50927", "50928", "50929", "50930", "50931", "50932", "50933", "50934", "50935", "50936", "50937", "50938", "50939", "50940", "50941", "50942", "50943", "50944", "50945", "50946", "50947", "50948", "50949", "50950", "50988", "50989", "50990", "51000", "51100", "51200", "51700", "51990", "52000", "52100", "52200", "53000", "53100", "53200", "53300", "53700", "53800", "53990", "54000", "54100", "54200", "55000", "55100", "55200", "55300", "55700", "55710", "55720", "55900", "55902", "55904", "55906", "55908", "55910", "55912", "55914", "55916", "55918", "55920", "55922", "55924", "55926", "55928", "55930", "55932", "55934", "55990", "56000", "56100", "57000", "57100", "57700", "57990", "58000", "58100", "58200", "58700", "58990", "59000", "59100", "59200", "59700", "59800", "59990", "60000", "62000", "62007", "62050", "62100", "62150", "62200", "62250", "62300", "62502", "62504", "62505", "62506", "62510", "62512", "62514", "62516", "62517", "62518", "62519", "62520", "62522", "62524", "62526", "62527", "62530", "62532", "62536", "62540", "62542", "62546", "62550", "62551", "62570", "62574", "62576", "62582", "62584", "62590", "62592", "62596", "62602", "62604", "62605", "62606", "62616", "62618", "62620", "62623", "62624", "62628", "62630", "62632", "62648", "62652", "62654", "62662", "62668", "62670", "62674", "62675", "62676", "62677", "62686", "62692", "62988", "63000", "63100", "63200", "63300", "64000", "68000", "68100", "69000", "70000", "70100", "70200", "70300", "70400", "70450", "70500", "70502", "70503", "70504", "70505", "70506", "70508", "70512", "70516", "70517", "70518", "70532", "70534", "70536", "70540", "70546", "70548", "70550", "70551", "70558", "70560", "70564", "70570", "70572", "70576", "70578", "70582", "70586", "70590", "70592", "70594", "70596", "70600", "70604", "70606", "70608", "70609", "70610", "70620", "70626", "70628", "70632", "70634", "70644", "70646", "70648", "70658", "70664", "70670", "70672", "70673", "70674", "70676", "70690", "70700", "70710", "70720", "70730", "70740", "70750", "70990", "71000", "71007", "71009", "71010", "71050", "71059", "71100", "71109", "71150", "71159", "71200", "71209", "71250", "71259", "71300", "71309", "71350", "71359", "71400", "71409", "71450", "71459", "71500", "71509", "71550", "71559", "71600", "71609", "71650", "71659", "71700", "71707", "71709", "71750", "71759", "71760", "71770", "71800", "71807", "71809", "71900", "71907", "71909", "71950", "71960", "72000", "72007", "72009", "72100", "72107", "72109", "72120", "72127", "72129", "72200", "72207", "72209", "72300", "72307", "72309", "72400", "72409", "72500", "72507", "72509", "73000", "73007", "73009", "73100", "73109", "73200", "73207", "73209", "73300", "73309", "73400", "73409", "73420", "73430", "73440", "73450", "73460", "73470", "73480", "73500", "73507", "73509", "75000", "75050", "75100", "75150", "75200", "75250", "75260", "75300", "75350", "75400", "75450", "75460", "75500", "75502", "75503", "75504", "75505", "75506", "75508", "75510", "75512", "75514", "75516", "75517", "75518", "75519", "75532", "75536", "75538", "75540", "75542", "75546", "75550", "75551", "75552", "75560", "75564", "75566", "75570", "75572", "75576", "75578", "75582", "75584", "75586", "75590", "75592", "75594", "75596", "75600", "75604", "75606", "75608", "75609", "75610", "75612", "75618", "75620", "75622", "75626", "75628", "75630", "75632", "75646", "75648", "75662", "75670", "75672", "75673", "75674", "75676", "75690", "75700", "75710", "75720", "75730", "75740", "75750", "75760", "75900", "75902", "75904", "75906", "75908", "75910", "75912", "75914", "75916", "75918", "75990", "76100", "76109", "76200", "76300", "76400", "76409", "76450", "77000", "77007", "77008", "77009", "77100", "77109", "77200", "77300", "77309", "77400", "77409", "77500", "78000", "78009", "78100", "78200", "78300", "78307", "78309", "79000", "79100", "79150", "79200", "79250", "79502", "79503", "79504", "79505", "79511", "79513", "79514", "79517", "79518", "79520", "79521", "79523", "79532", "79538", "79540", "79546", "79548", "79550", "79552", "79555", "79570", "79575", "79576", "79592", "79601", "79603", "79605", "79606", "79612", "79626", "79630", "79632", "79646", "79658", "79660", "79680", "79681", "79683", "80000", "80050", "80100", "80150", "80200", "80250", "80300", "80350", "80400", "80500", "80506", "80508", "80516", "80519", "80534", "80536", "80542", "80546", "80558", "80560", "80564", "80568", "80578", "80584", "80586", "80590", "80592", "80594", "80596", "80600", "80604", "80608", "80620", "80622", "80628", "80644", "80648", "80662", "80664", "80668", "80670", "80672", "80673", "80676", "80700", "80710", "80720", "80730", "80900", "80902", "80904", "80906", "80908", "80988", "80990", "81000", "81100", "81200", "81300", "81310", "81400", "81440", "81450", "81500", "81550", "81600", "81700", "81750", "81800", "81850", "81900", "81920", "81930", "82000", "82100", "82200", "82300", "83000", "83100", "83200", "83300", "83400", "83500", "83600", "83700", "84000", "84150", "84200", "84300", "84400", "84500", "84600", "84700", "84800", "84900", "85000", "85100", "85200", "85300", "85400", "86000", "86100", "86200", "86300", "86400", "86500", "86600", "86700", "86800", "86810", "86900", "87000", "87010", "87011", "87012", "87013", "87014", "87015", "87016", "87017", "87018", "87019", "87020", "87021", "87022", "87023", "87024", "87025", "87026", "87027", "87028", "87029", "87030", "87031", "87032", "87033", "88000", "88100", "88200", "88300", "88400", "88450", "88460", "88500", "88502", "88504", "88505", "88506", "88508", "88510", "88512", "88514", "88516", "88518", "88520", "88526", "88527", "88532", "88534", "88538", "88540", "88546", "88550", "88551", "88552", "88554", "88556", "88558", "88560", "88562", "88564", "88566", "88568", "88570", "88572", "88576", "88580", "88582", "88586", "88590", "88592", "88594", "88596", "88598", "88600", "88602", "88604", "88606", "88608", "88609", "88610", "88612", "88614", "88617", "88618", "88620", "88621", "88622", "88624", "88626", "88628", "88630", "88632", "88634", "88644", "88646", "88648", "88656", "88658", "88660", "88661", "88662", "88670", "88672", "88673", "88675", "88676", "88680", "88690", "88700", "88721", "88722", "88723", "88724", "88725", "88757", "88758", "88759", "88760", "88761", "88762", "88763", "88764", "88765", "88766", "88767", "88768", "88769", "88770", "88771", "88772", "88773", "88774", "88775", "88776", "88777", "88778", "88779", "88780", "88781", "88782", "88783", "88784", "88785", "88786", "88787", "88788", "88789", "88790", "88800", "88801", "88802", "88803", "88804", "88805", "88806", "88807", "88808", "88809", "88810", "88811", "88812", "88813", "88814", "88815", "88816", "88817", "88818", "88819", "88820", "88821", "88822", "88823", "88824", "88825", "88826", "88827", "88828", "88829", "88830", "88831", "88832", "88833", "88834", "88835", "88836", "88837", "88838", "88839", "88840", "88841", "88842", "88843", "88844", "88845", "88846", "88847", "88848", "88849", "88850", "88851", "88852", "88853", "88854", "88855", "88856", "88857", "88858", "88860", "88861", "88862", "88863", "88865", "88866", "88867", "88868", "88869", "88870", "88871", "88872", "88873", "88874", "88875", "88900", "88901", "88902", "88903", "88904", "88905", "88906", "88988", "88990", "88991", "88992", "88993", "88994", "88995", "88996", "88997", "88998", "88999", "89000", "89007", "89008", "89009", "89050", "89057", "89058", "89059", "89100", "89107", "89108", "89109", "89150", "89157", "89158", "89159", "89200", "89207", "89208", "89209", "89250", "89257", "89258", "89259", "89260", "89300", "89307", "89308", "89309", "89500", "89507", "89508", "89509", "89600", "89607", "89608", "89609", "89650", "89657", "89658", "89659", "89700", "89707", "89708", "89709", "89720", "89727", "89728", "89729", "89740", "89747", "89748", "89749", "89760", "89767", "89768", "89769", "89800", "89807", "89808", "89809", "89850", "89857", "89858", "89859", "89900", "89907", "89908", "89909", "89950", "89957", "89958", "89959", "90000", "90009", "90100", "90107", "90109", "90200", "90300", "90307", "90400", "90700", "90701", "90702", "90703", "90704", "90705", "90706", "90707", "90708", "90709", "90711", "90712", "90713", "90714", "90715", "90716", "90717", "90718", "90719", "90720", "90721", "90722", "90723", "90724", "90725", "90726", "90727", "90728", "90729", "90730", "90731", "90732", "90733", "90734", "90735", "90736", "90737", "90738", "90739", "90740", "90741", "91000", "91007", "91008", "91009", "91010", "91011", "91012", "91013", "91014", "91015", "91016", "91017", "91018", "91019", "91020", "91021", "91022", "91023", "91024", "91025", "91026", "91027", "91028", "91029", "91030", "91031", "91032", "91033", "91034", "91035", "91100", "91109", "91110", "91111", "91112", "91113", "91114", "91115", "91116", "91117", "91118", "91119", "91120", "91121", "91122", "91123", "91124", "91125", "91126", "91127", "91128", "91150", "91200", "91207", "91209", "91300", "91307", "91308", "91309", "93000", "93010", "93050", "93100", "93150", "93200", "93250", "93300", "93350", "93400", "93450", "93500", "93502", "93503", "93504", "93505", "93506", "93507", "93508", "93514", "93516", "93517", "93518", "93519", "93520", "93527", "93529", "93532", "93540", "93550", "93551", "93552", "93554", "93556", "93558", "93560", "93564", "93566", "93570", "93572", "93576", "93578", "93582", "93586", "93590", "93592", "93594", "93596", "93600", "93604", "93606", "93608", "93609", "93610", "93612", "93614", "93618", "93619", "93620", "93626", "93628", "93632", "93634", "93648", "93658", "93660", "93661", "93662", "93670", "93672", "93677", "93690", "93694", "93700", "93702", "93704", "93706", "93708", "93710", "93712", "93714", "93716", "93718", "93720", "93722", "93724", "93726", "93728", "93730", "93732", "93734", "93736", "93738", "93740", "93742", "93744", "93746", "93748", "93750", "93752", "93754", "93756", "93758", "93760", "93762", "93764", "93900", "93902", "93904", "93906", "93908", "93910", "93912", "93914", "93916", "93990", "94000", "94007", "94009", "94200", "94300", "94500", "94507", "94509", "94600", "94650", "94700", "94707", "94709", "94750", "94760", "94800", "94807", "94809", "94850", "94900", "94950", "95000", "95007", "95008", "95009", "95300", "95400", "95407", "95409", "95500", "95600", "95700", "95707", "95709", "95800", "95900", "96000", "96007", "96008", "96009", "96100", "96107", "96108", "96109", "96150", "96200", "96250", "96300", "96307", "96309", "96350", "96400", "96410", "96500", "96507", "96508", "96509", "96600", "96700", "96707", "96709", "96800", "96807", "96809", "96850", "96900", "97000", "97007", "97008", "97009", "97010", "97011", "97012", "97013", "97014", "97015", "97100", "97200", "97300", "98000", "98007", "98008", "98009", "98050", "98057", "98058", "98059", "98100", "98107", "98109", "98150", "98157", "98159", "98200", "98300", "98700", "98707", "98708", "98709", "98750", "98800", "98850", "98857", "98859" }));
        Panel.add(jcbZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 110, 30));

        jcbState.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jcbState.setForeground(new java.awt.Color(255, 110, 109));
        jcbState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kuala Lumpur", "Johor", "Kedah", "Kelantan", "Labuan", "Malacca", "Negeri Sembilan", "Pahang", "Penang", "Putrajaya", "Perak", "Perlis", "Sabah", "Sarawak", "Selangor", "Terengganu" }));
        Panel.add(jcbState, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 140, 30));

        jcbCity.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jcbCity.setForeground(new java.awt.Color(255, 110, 109));
        jcbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alor Setar", "George Town", "Ipoh", "Iskandar Puteri", "Johor Bahru", "Kota Kinabalu", "Kuala Lumpur", "Kuala Terengganu", "Kuantan", "Kuching", "Malacca City", "Miri", "Pasir Gudang", "Petaling Jaya", "Seberang Perai", "Seremban", "Shah Alam", "Subang Jaya" }));
        Panel.add(jcbCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 160, 30));

        jcbCountry.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jcbCountry.setForeground(new java.awt.Color(255, 110, 109));
        jcbCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Malaysia" }));
        Panel.add(jcbCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 140, 30));

        Rightpanel.add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 580));

        lblusername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblusername.setText("customer");
        Rightpanel.add(lblusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 70, -1));

        lblAdmin3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAdmin3.setText("HELLO,");
        Rightpanel.add(lblAdmin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        Background.add(Rightpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 940, 680));

        Roundcorner.setBackground(new java.awt.Color(255, 110, 109));
        Roundcorner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/round corner.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        Roundcorner.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 40, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/round corner.png"))); // NOI18N
        jLabel7.setText("jLabel6");
        Roundcorner.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        Background.add(Roundcorner, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 40, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        this.dispose();
        new CustomerHome().setVisible(true);
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseClicked
        this.dispose();
        new CustomerOrder().setVisible(true);
    }//GEN-LAST:event_btnOrderMouseClicked

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        if (usernameTxt.getText().equals("")||firstNameTxt.getText().equals("") || lastNameTxt.getText().equals("") || mobileNoTxt.getText().equals("") || emailTxt.getText().equals("") || streetNoTxt.getText().equals("") || streetNameTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill up the form");
            return;
        }
        if (new CustomerManager().isStringNumeric(mobileNoTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Please insert correct mobile number");
            return;
        }
        char[] password = passwordTxt.getPassword();
        char[] comfirmPass = comfirmPassTxt.getPassword();


        if (!new String(password).equals(new String(comfirmPass))) {
            JOptionPane.showMessageDialog(null, "Password does not match!!");
            return;
        }

        String cusPassword = String.valueOf(password);

        boolean validatePass = User.validatePass(cusPassword);
        if (validatePass == false) {
            JOptionPane.showMessageDialog(null, "Your password must contain a minimum of 8 characters included with at least 1 upper case letter,1 number and 1 special character.");
            return;
        }

        CustomerManager manager = new CustomerManager();
        User umanager = new User();
        try {
            ArrayList<Customer> customerList = manager.read();
            ArrayList<User> userList = umanager.read();

            String cusID = new User().readtemp();
            for (int i = 0; i < customerList.size(); i++) {
                if (customerList.get(i).getCusID().equals(cusID)) {

                    if (maleRbtn.isSelected()) {
                        customerList.get(i).setGender('M');
                    } else if (femaleRbtn.isSelected()) {
                        customerList.get(i).setGender('F');
                    }
                    customerList.get(i).name.setName(firstNameTxt.getText(), lastNameTxt.getText());
                    customerList.get(i).setPhoneNo(mobileNoTxt.getText());
                    customerList.get(i).setEmail(emailTxt.getText());
                    customerList.get(i).address.setAddress(streetNoTxt.getText(), streetNameTxt.getText(), jcbCity.getItemAt(jcbCity.getSelectedIndex()), jcbState.getItemAt(jcbState.getSelectedIndex()), jcbZip.getItemAt(jcbZip.getSelectedIndex()), jcbCountry.getItemAt(jcbCountry.getSelectedIndex()));
                    manager.printCustList2File(customerList);
                }
                for (int j = 0; j < userList.size(); j++) {
                    if (userList.get(j).getID().equals(cusID)) {
                        //username didnt change
                        if (userList.get(j).getUsername().equals(usernameTxt.getText())) {
                            userList.get(j).setPassword(cusPassword);
                            umanager.printUser2File(userList);

                        } else {
                            userList.get(j).setUsername(usernameTxt.getText());
                            userList.get(j).setPassword(cusPassword);

                            try {
                                umanager.printUser2File(userList, j);
                            } catch (DuplicateUsernameException e) {
                                JOptionPane.showMessageDialog(this, "Username has been used. Please insert a new username.");
                                return;
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error");
                            }
                        }

                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CustomerProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "User profile updated");

    }//GEN-LAST:event_signUpBtnActionPerformed

    private void btnLogout1btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout1btnLogoutMouseClicked
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Choice", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            this.dispose();
            LoginPage m = new LoginPage();
            m.setVisible(true);
        }
    }//GEN-LAST:event_btnLogout1btnLogoutMouseClicked

    private void btnCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCartMouseClicked

        this.dispose();
        new CustomerCart().setVisible(true);

    }//GEN-LAST:event_btnCartMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Rightpanel;
    private javax.swing.JPanel Roundcorner;
    private javax.swing.JLabel btnCart;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout1;
    private javax.swing.JLabel btnOrder;
    private javax.swing.JLabel btnProfile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField comfirmPassTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JRadioButton femaleRbtn;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> jcbCity;
    private javax.swing.JComboBox<String> jcbCountry;
    private javax.swing.JComboBox<String> jcbState;
    private javax.swing.JComboBox<String> jcbZip;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAdmin3;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblComfirmPass;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMobileNo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPostCode;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblStreetName;
    private javax.swing.JLabel lblStreetNo;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblusername;
    private javax.swing.JRadioButton maleRbtn;
    private javax.swing.JTextField mobileNoTxt;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JTextField streetNameTxt;
    private javax.swing.JTextField streetNoTxt;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}

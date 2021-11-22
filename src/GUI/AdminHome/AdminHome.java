/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.AdminHome;

import GUI.AdminOrder.AddOrder;
import GUI.AdminProduct.AddProduct;
import GUI.AdminProduct.EditProduct;
import GUI.AdminProduct.ViewProduct;
import GUI.AdminCustomer.AddCustomer;
import GUI.AdminCustomer.EditCustomer;
import GUI.AdminCustomer.ViewCustomer;
import GUI.AdminOrder.ManageOrder;
import GUI.LoginPage;
import assignment.Customers.Customer;
import assignment.Customers.CustomerManager;
import assignment.Orders.Order;
import assignment.Orders.OrderManager;
import assignment.Products.Product;
import assignment.Products.ProductManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class AdminHome extends javax.swing.JFrame {

    ArrayList<Order> orderList;
    ArrayList<Customer> cusList;
    ArrayList<Product> productList;

    public AdminHome() {
        initComponents();
        this.setLocationRelativeTo(null);

        try {
            orderList = new OrderManager().read();
            productList = new ProductManager().read();
            cusList = new CustomerManager().read();
            //display total number or customer/orders/products 
            lblnumCus.setText(String.valueOf(cusList.size()));
            lblnumOrder.setText(String.valueOf(orderList.size()));
            lblnumProduct.setText(String.valueOf(productList.size()));
        } catch (IOException ex) {
            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        ADMIN = new javax.swing.JLabel();
        PANEL = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCustomer = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnProduct = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnOrder = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        Rightpanel = new javax.swing.JPanel();
        BtnEditCus = new javax.swing.JLabel();
        lblTOrder = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BtnOrderHis = new javax.swing.JLabel();
        btnAddCus = new javax.swing.JLabel();
        lblAddCus = new javax.swing.JLabel();
        lblEditCus = new javax.swing.JLabel();
        lblOrderHis = new javax.swing.JLabel();
        BtnSearchProduct = new javax.swing.JLabel();
        lblSearchPro = new javax.swing.JLabel();
        BtnEditProduct = new javax.swing.JLabel();
        lblEditPro = new javax.swing.JLabel();
        lblAddPro = new javax.swing.JLabel();
        BtnAddProcduct = new javax.swing.JLabel();
        lblTotalOrder = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblnumOrder = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblTotalCus = new javax.swing.JLabel();
        lblnumProduct = new javax.swing.JLabel();
        lblTotalPro = new javax.swing.JLabel();
        lblnumCus = new javax.swing.JLabel();
        lblTCus = new javax.swing.JLabel();
        lblAddOrder = new javax.swing.JLabel();
        BtnAddOrder = new javax.swing.JLabel();
        lblTotalOrderInFile = new javax.swing.JLabel();
        lblTPro = new javax.swing.JLabel();
        lblTotalCusInFile = new javax.swing.JLabel();
        lblTotalProInFile = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();
        lblCus = new javax.swing.JLabel();
        lblPro = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        BtnSearchCus1 = new javax.swing.JLabel();
        lblSearchCus = new javax.swing.JLabel();
        Roundcorner = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(255, 110, 109));
        Background.setPreferredSize(new java.awt.Dimension(1160, 660));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LeftPanel.setBackground(new java.awt.Color(255, 110, 109));
        LeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ADMIN.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ADMIN.setForeground(new java.awt.Color(255, 255, 255));
        ADMIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ADMIN.setText("ADMIN");
        LeftPanel.add(ADMIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        PANEL.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        PANEL.setForeground(new java.awt.Color(255, 255, 255));
        PANEL.setText("PANEL");
        LeftPanel.add(PANEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 110, 109));

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.png"))); // NOI18N
        btnHome.setText(" HOME");

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

        btnCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomer.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnCustomer.setForeground(new java.awt.Color(245, 196, 196));
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/customer grey.png"))); // NOI18N
        btnCustomer.setText(" CUSTOMER");
        btnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnCustomer)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCustomer)
                .addGap(76, 76, 76))
        );

        LeftPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 60));

        jPanel3.setBackground(new java.awt.Color(255, 110, 109));

        btnProduct.setBackground(new java.awt.Color(255, 255, 255));
        btnProduct.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnProduct.setForeground(new java.awt.Color(245, 196, 196));
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/product grey.png"))); // NOI18N
        btnProduct.setText(" PRODUCT");
        btnProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProduct)
                .addGap(76, 76, 76))
        );

        LeftPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, 60));

        jPanel4.setBackground(new java.awt.Color(255, 110, 109));

        btnOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnOrder.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(245, 196, 196));
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/order grey.png"))); // NOI18N
        btnOrder.setText("ORDER");
        btnOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOrder)
                .addGap(76, 76, 76))
        );

        LeftPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, 60));

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sign out.png"))); // NOI18N
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        LeftPanel.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 40, 50));

        Background.add(LeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 660));

        Rightpanel.setBackground(new java.awt.Color(254, 242, 242));
        Rightpanel.setForeground(new java.awt.Color(89, 89, 89));
        Rightpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnEditCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit grey.png"))); // NOI18N
        BtnEditCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEditCusMouseClicked(evt);
            }
        });
        Rightpanel.add(BtnEditCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        lblTOrder.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblTOrder.setForeground(new java.awt.Color(89, 89, 89));
        lblTOrder.setText("ORDER");
        Rightpanel.add(lblTOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 90, 20));

        lblAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAdmin.setText("HELLO,Admin");
        Rightpanel.add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/admin avatar.png"))); // NOI18N
        Rightpanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, 50));

        BtnOrderHis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/serach grey.png"))); // NOI18N
        BtnOrderHis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnOrderHisMouseClicked(evt);
            }
        });
        Rightpanel.add(BtnOrderHis, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 540, 80, 70));

        btnAddCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add grey.png"))); // NOI18N
        btnAddCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddCusMouseClicked(evt);
            }
        });
        Rightpanel.add(btnAddCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 80, -1));

        lblAddCus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblAddCus.setText("ADD");
        Rightpanel.add(lblAddCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        lblEditCus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblEditCus.setText("EDIT");
        Rightpanel.add(lblEditCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, -1));

        lblOrderHis.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblOrderHis.setText("ORDER HISTORY");
        Rightpanel.add(lblOrderHis, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 600, 140, 40));

        BtnSearchProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        BtnSearchProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSearchProductMouseClicked(evt);
            }
        });
        Rightpanel.add(BtnSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 80, 70));

        lblSearchPro.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblSearchPro.setText("SEARCH");
        Rightpanel.add(lblSearchPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, -1, -1));

        BtnEditProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        BtnEditProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEditProductMouseClicked(evt);
            }
        });
        Rightpanel.add(BtnEditProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, -1, -1));

        lblEditPro.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblEditPro.setText("EDIT");
        Rightpanel.add(lblEditPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 610, -1, -1));

        lblAddPro.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblAddPro.setText("ADD");
        Rightpanel.add(lblAddPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, -1, -1));

        BtnAddProcduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        BtnAddProcduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAddProcductMouseClicked(evt);
            }
        });
        Rightpanel.add(BtnAddProcduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 80, -1));

        lblTotalOrder.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTotalOrder.setForeground(new java.awt.Color(89, 89, 89));
        lblTotalOrder.setText("TOTAL");
        Rightpanel.add(lblTotalOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(89, 89, 89));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/homoproduct_1.png"))); // NOI18N
        Rightpanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 60, 70));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(89, 89, 89));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/homeorder_1.png"))); // NOI18N
        Rightpanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, -1, -1));

        lblnumOrder.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblnumOrder.setText("36");
        Rightpanel.add(lblnumOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 110, 60));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(89, 89, 89));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/homepeopel_1.png"))); // NOI18N
        Rightpanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        lblTotalCus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTotalCus.setForeground(new java.awt.Color(89, 89, 89));
        lblTotalCus.setText("TOTAL");
        Rightpanel.add(lblTotalCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 20));

        lblnumProduct.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblnumProduct.setText("54");
        Rightpanel.add(lblnumProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 110, 60));

        lblTotalPro.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTotalPro.setForeground(new java.awt.Color(89, 89, 89));
        lblTotalPro.setText("TOTAL");
        Rightpanel.add(lblTotalPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        lblnumCus.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblnumCus.setText("36");
        Rightpanel.add(lblnumCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 110, 60));

        lblTCus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTCus.setForeground(new java.awt.Color(89, 89, 89));
        lblTCus.setText("CUSTOMER");
        Rightpanel.add(lblTCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        lblAddOrder.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblAddOrder.setText("ADD");
        Rightpanel.add(lblAddOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, -1, -1));

        BtnAddOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add grey.png"))); // NOI18N
        BtnAddOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAddOrderMouseClicked(evt);
            }
        });
        Rightpanel.add(BtnAddOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, 80, -1));

        lblTotalOrderInFile.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTotalOrderInFile.setForeground(new java.awt.Color(89, 89, 89));
        lblTotalOrderInFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/admin home22.png"))); // NOI18N
        lblTotalOrderInFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTotalOrderInFileMouseClicked(evt);
            }
        });
        Rightpanel.add(lblTotalOrderInFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 260, 200));

        lblTPro.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblTPro.setForeground(new java.awt.Color(89, 89, 89));
        lblTPro.setText("PRODUCT");
        Rightpanel.add(lblTPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        lblTotalCusInFile.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTotalCusInFile.setForeground(new java.awt.Color(89, 89, 89));
        lblTotalCusInFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/admin home22.png"))); // NOI18N
        lblTotalCusInFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTotalCusInFileMouseClicked(evt);
            }
        });
        Rightpanel.add(lblTotalCusInFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, 200));

        lblTotalProInFile.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTotalProInFile.setForeground(new java.awt.Color(89, 89, 89));
        lblTotalProInFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/admin home22.png"))); // NOI18N
        lblTotalProInFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTotalProInFileMouseClicked(evt);
            }
        });
        Rightpanel.add(lblTotalProInFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 260, 200));

        lblHome.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblHome.setForeground(new java.awt.Color(89, 89, 89));
        lblHome.setText("HOME");
        Rightpanel.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lblCus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCus.setText("CUSTOMER");
        Rightpanel.add(lblCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        lblPro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPro.setText("PRODUCT");
        Rightpanel.add(lblPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        lblOrder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblOrder.setText("ORDER");
        Rightpanel.add(lblOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, -1, -1));

        BtnSearchCus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/serach grey.png"))); // NOI18N
        BtnSearchCus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSearchCus1MouseClicked(evt);
            }
        });
        Rightpanel.add(BtnSearchCus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 80, 70));

        lblSearchCus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblSearchCus.setText("SEARCH");
        Rightpanel.add(lblSearchCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

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

    private void btnCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseClicked
        this.dispose();
        AddCustomer m = new AddCustomer();
        m.setVisible(true);
    }//GEN-LAST:event_btnCustomerMouseClicked

    private void btnProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductMouseClicked
        this.dispose();
        AddProduct m = new AddProduct();
        m.setVisible(true);
    }//GEN-LAST:event_btnProductMouseClicked

    private void btnOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseClicked
        this.dispose();
        AddOrder m = new AddOrder();
        m.setVisible(true);
    }//GEN-LAST:event_btnOrderMouseClicked

    private void BtnEditCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEditCusMouseClicked
        this.dispose();
        EditCustomer m = new EditCustomer();
        m.setVisible(true);
    }//GEN-LAST:event_BtnEditCusMouseClicked

    private void BtnOrderHisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnOrderHisMouseClicked
        this.dispose();
        ManageOrder m = new ManageOrder();
        m.setVisible(true);
    }//GEN-LAST:event_BtnOrderHisMouseClicked

    private void btnAddCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCusMouseClicked
        this.dispose();
        AddCustomer m = new AddCustomer();
        m.setVisible(true);
    }//GEN-LAST:event_btnAddCusMouseClicked

    private void BtnSearchProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSearchProductMouseClicked
        this.dispose();
        ViewProduct m = new ViewProduct();
        m.setVisible(true);
    }//GEN-LAST:event_BtnSearchProductMouseClicked

    private void BtnEditProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEditProductMouseClicked
        this.dispose();
        EditProduct m = new EditProduct();
        m.setVisible(true);
    }//GEN-LAST:event_BtnEditProductMouseClicked

    private void BtnAddProcductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddProcductMouseClicked
        this.dispose();
        AddProduct m = new AddProduct();
        m.setVisible(true);
    }//GEN-LAST:event_BtnAddProcductMouseClicked

    private void BtnAddOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAddOrderMouseClicked
        this.dispose();
        AddOrder m = new AddOrder();
        m.setVisible(true);
    }//GEN-LAST:event_BtnAddOrderMouseClicked

    private void BtnSearchCus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSearchCus1MouseClicked

        this.dispose();
        ViewCustomer m = new ViewCustomer();
        m.setVisible(true);

    }//GEN-LAST:event_BtnSearchCus1MouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Choice", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            this.dispose();
            LoginPage m = new LoginPage();
            m.setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void lblTotalCusInFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTotalCusInFileMouseClicked
        this.dispose();
        new ViewCustomer().setVisible(true);
    }//GEN-LAST:event_lblTotalCusInFileMouseClicked

    private void lblTotalProInFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTotalProInFileMouseClicked
        this.dispose();
        new ViewProduct().setVisible(true);
    }//GEN-LAST:event_lblTotalProInFileMouseClicked

    private void lblTotalOrderInFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTotalOrderInFileMouseClicked
        this.dispose();
        new ManageOrder().setVisible(true);
    }//GEN-LAST:event_lblTotalOrderInFileMouseClicked

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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADMIN;
    private javax.swing.JPanel Background;
    private javax.swing.JLabel BtnAddOrder;
    private javax.swing.JLabel BtnAddProcduct;
    private javax.swing.JLabel BtnEditCus;
    private javax.swing.JLabel BtnEditProduct;
    private javax.swing.JLabel BtnOrderHis;
    private javax.swing.JLabel BtnSearchCus1;
    private javax.swing.JLabel BtnSearchProduct;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JLabel PANEL;
    private javax.swing.JPanel Rightpanel;
    private javax.swing.JPanel Roundcorner;
    private javax.swing.JLabel btnAddCus;
    private javax.swing.JLabel btnCustomer;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnOrder;
    private javax.swing.JLabel btnProduct;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAddCus;
    private javax.swing.JLabel lblAddOrder;
    private javax.swing.JLabel lblAddPro;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblCus;
    private javax.swing.JLabel lblEditCus;
    private javax.swing.JLabel lblEditPro;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblOrderHis;
    private javax.swing.JLabel lblPro;
    private javax.swing.JLabel lblSearchCus;
    private javax.swing.JLabel lblSearchPro;
    private javax.swing.JLabel lblTCus;
    private javax.swing.JLabel lblTOrder;
    private javax.swing.JLabel lblTPro;
    private javax.swing.JLabel lblTotalCus;
    private javax.swing.JLabel lblTotalCusInFile;
    private javax.swing.JLabel lblTotalOrder;
    private javax.swing.JLabel lblTotalOrderInFile;
    private javax.swing.JLabel lblTotalPro;
    private javax.swing.JLabel lblTotalProInFile;
    private javax.swing.JLabel lblnumCus;
    private javax.swing.JLabel lblnumOrder;
    private javax.swing.JLabel lblnumProduct;
    // End of variables declaration//GEN-END:variables
}
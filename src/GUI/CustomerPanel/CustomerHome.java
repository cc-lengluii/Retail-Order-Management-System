/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.CustomerPanel;

import GUI.LoginPage;
import assignment.Customers.Customer;
import assignment.Customers.CustomerManager;
import assignment.Orders.Cart;
import assignment.Orders.CartManager;
import assignment.Products.Product;
import assignment.Products.ProductManager;
import assignment.Users.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author user
 */
public class CustomerHome extends javax.swing.JFrame {

    /**
     * Creates new form AdminPanel1
     */
    public CustomerHome() {
        initComponents();
        this.setLocationRelativeTo(null);
        addProduct2JTable();
        sortProTable();
        try {
            String cusID = new User().readtemp();
            Customer o = new CustomerManager().search(cusID);
            Cart c = new CartManager().searchcart(cusID);
            lblusername.setText(o.name.getfName().toUpperCase());
            if (c != null) {
                lblcartnumber.setText("(" + String.valueOf(c.getOrderItems().size()) + ")");
            }
        } catch (IOException ex) {
            System.out.println("Error");
        }

    }

    ArrayList<Product> productList = new ArrayList<>();
    DefaultComboBoxModel cusCombo = new DefaultComboBoxModel();

    public void addProduct2JTable() {

        try {
            DefaultTableModel model = (DefaultTableModel) productTbl.getModel();
            ProductManager pManager = new ProductManager();
            CartManager cManager = new CartManager();
            productList = pManager.read();
            Object rowData[] = new Object[6];
            model.setRowCount(0);
            for (int i = 0; i < productList.size(); i++) {
                rowData[0] = productList.get(i).getProductID();
                rowData[1] = productList.get(i).getProductName();
                rowData[2] = productList.get(i).getCategory();
                rowData[3] = productList.get(i).getType();
                rowData[4] = String.format("%.2f", productList.get(i).getPrice());
                rowData[5] = productList.get(i).getStock();
                String cusID = new User().readtemp();
                Cart cartList = cManager.searchcart(cusID);
                if (cartList != null) {
                    for (int j = 0; j < cartList.orderItems.size(); j++) {
                        if (cartList.orderItems.get(j).getProduct().getProductID().equals(productList.get(i).getProductID())) {
                            int stock = productList.get(i).getStock() - cartList.orderItems.get(j).getQuantity();
                            rowData[5] = stock;
                        }
                    }
                }

                model.addRow(rowData);

            }
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public TableRowSorter<DefaultTableModel> sortProTable() {

        DefaultTableModel table = (DefaultTableModel) productTbl.getModel();

        TableRowSorter<DefaultTableModel> sortProTable = new TableRowSorter<>(table);
        productTbl.setRowSorter(sortProTable);
        return sortProTable;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCustomer = new javax.swing.JLabel();
        lblcartnumber = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnOrder1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnOrder = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLogout1 = new javax.swing.JLabel();
        Rightpanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        productTbl = new javax.swing.JTable();
        quantity1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblAdmin1 = new javax.swing.JLabel();
        txtSearchPro = new javax.swing.JTextField();
        lblusername = new javax.swing.JLabel();
        lblAdmin3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Roundcorner = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background.setBackground(new java.awt.Color(255, 110, 109));
        Background.setPreferredSize(new java.awt.Dimension(1160, 660));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LeftPanel.setBackground(new java.awt.Color(255, 110, 109));
        LeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 110, 109));

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home.png"))); // NOI18N
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

        btnCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomer.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnCustomer.setForeground(new java.awt.Color(245, 196, 196));
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cart grey.png"))); // NOI18N
        btnCustomer.setText("  CART");
        btnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerMouseClicked(evt);
            }
        });

        lblcartnumber.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblcartnumber.setForeground(new java.awt.Color(255, 255, 255));
        lblcartnumber.setText("(0)");
        lblcartnumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcartnumberMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCustomer)
                .addGap(18, 18, 18)
                .addComponent(lblcartnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCustomer)
                    .addComponent(lblcartnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        LeftPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 60));

        jPanel3.setBackground(new java.awt.Color(255, 110, 109));

        btnOrder1.setBackground(new java.awt.Color(255, 255, 255));
        btnOrder1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnOrder1.setForeground(new java.awt.Color(245, 196, 196));
        btnOrder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/order grey.png"))); // NOI18N
        btnOrder1.setText("ORDER");
        btnOrder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrder1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(btnOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOrder1)
                .addContainerGap())
        );

        LeftPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, 60));

        jPanel4.setBackground(new java.awt.Color(255, 110, 109));

        btnOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnOrder.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(245, 196, 196));
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/profile grey.png"))); // NOI18N
        btnOrder.setText(" EDIT PROFILE");
        btnOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
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

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/minisearch.png"))); // NOI18N
        Rightpanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 60, 50));

        lblAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rightpanel.add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/productbag.png"))); // NOI18N
        Rightpanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 50));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/admin avatar.png"))); // NOI18N
        Rightpanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, 50));

        productTbl.setAutoCreateRowSorter(true);
        productTbl.setBackground(new java.awt.Color(254, 242, 242));
        productTbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Category", "Type", "Price", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        productTbl.setGridColor(new java.awt.Color(0, 0, 0));
        productTbl.setRowHeight(40);
        productTbl.setSelectionBackground(new java.awt.Color(255, 110, 109));
        productTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(productTbl);

        Rightpanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 860, 430));

        quantity1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantity1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantity1.setText("1");
        quantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantity1ActionPerformed(evt);
            }
        });
        Rightpanel.add(quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 120, 30));

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Rightpanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 110, 30));

        lblAdmin1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAdmin1.setForeground(new java.awt.Color(89, 89, 89));
        lblAdmin1.setText("Quantity");
        Rightpanel.add(lblAdmin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, -1, -1));

        txtSearchPro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchProKeyReleased(evt);
            }
        });
        Rightpanel.add(txtSearchPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 99, 450, 50));

        lblusername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblusername.setText("customer");
        Rightpanel.add(lblusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 70, -1));

        lblAdmin3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAdmin3.setText("HELLO,");
        Rightpanel.add(lblAdmin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(89, 89, 89));
        jLabel12.setText("PRODUCTS");
        Rightpanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

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

        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked

    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseClicked
        this.dispose();
        new CustomerProfile().setVisible(true);
    }//GEN-LAST:event_btnOrderMouseClicked

    private void btnOrder1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrder1MouseClicked
        this.dispose();
        new CustomerOrder().setVisible(true);
    }//GEN-LAST:event_btnOrder1MouseClicked

    private void btnCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseClicked
        this.dispose();
        new CustomerCart().setVisible(true);
    }//GEN-LAST:event_btnCustomerMouseClicked

    private void quantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantity1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) productTbl.getModel();
        if (new CustomerManager().isStringNumeric(quantity1.getText())) {
            JOptionPane.showMessageDialog(null, "Please insert integer");
            return;
        }

        int row = productTbl.getSelectedRow();
        int selectedRow = productTbl.convertRowIndexToModel(row);
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select product");
        } else {

            if (Integer.parseInt(quantity1.getText()) > 0) {
                try {
                    int y = (Integer.parseInt((model.getValueAt(selectedRow, 5).toString())));
                    if (Integer.parseInt(quantity1.getText()) <= y) {
                        int quantity = Integer.parseInt(quantity1.getText());
                        CartManager manager = new CartManager();
                        ProductManager pmanager = new ProductManager();
                        String productID = model.getValueAt(selectedRow, 0).toString();
                        String cusID = new User().readtemp();
                        int a = manager.add(cusID, pmanager.search(productID), quantity);
                        addProduct2JTable();
                        Cart c = manager.searchcart(cusID);
                        if (c != null) {
                            lblcartnumber.setText("(" + String.valueOf(c.getOrderItems().size()) + ")");
                        }
                        if (a == 1) {
                            JOptionPane.showMessageDialog(this, "Product has added into cart");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Out of stock");
                    }
                } catch (IOException ex) {
                    System.out.println("Error");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Quantity must more than 1");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSearchProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchProKeyReleased

        String searchPro = txtSearchPro.getText().trim();
        TableRowSorter<DefaultTableModel> search = sortProTable();
        productTbl.setRowSorter(search);

        search.setRowFilter(RowFilter.regexFilter("(?i)" + searchPro));


    }//GEN-LAST:event_txtSearchProKeyReleased

    private void btnLogout1btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout1btnLogoutMouseClicked
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Choice", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            this.dispose();
            LoginPage m = new LoginPage();
            m.setVisible(true);
        }
    }//GEN-LAST:event_btnLogout1btnLogoutMouseClicked

    private void lblcartnumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcartnumberMouseClicked
        this.dispose();
        new CustomerCart().setVisible(true);
    }//GEN-LAST:event_lblcartnumberMouseClicked

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
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel Rightpanel;
    private javax.swing.JPanel Roundcorner;
    private javax.swing.JLabel btnCustomer;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout1;
    private javax.swing.JLabel btnOrder;
    private javax.swing.JLabel btnOrder1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAdmin1;
    private javax.swing.JLabel lblAdmin3;
    private javax.swing.JLabel lblcartnumber;
    private javax.swing.JLabel lblusername;
    private javax.swing.JTable productTbl;
    private javax.swing.JTextField quantity1;
    private javax.swing.JTextField txtSearchPro;
    // End of variables declaration//GEN-END:variables

}

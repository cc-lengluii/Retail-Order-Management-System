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
import assignment.Orders.Order;
import assignment.Orders.OrderItem;
import assignment.Orders.OrderManager;
import assignment.Products.Product;
import assignment.Products.ProductManager;
import assignment.Users.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class CustomerCart extends javax.swing.JFrame {

    /**
     * Creates new form CustomerCart
     */
    public CustomerCart() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblPrice.setVisible(false);
        lblDatedis.setText(new Order().DateGenerator());
        lblTimedis.setText(new Order().TimeGenerator());
        addProduct2CartJTable();
        try {
            String cusID = new User().readtemp();
            Customer o = new CustomerManager().search(cusID);
            lblusername.setText(o.name.getfName().toUpperCase());
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    private Cart cartList;

    public void addProduct2CartJTable() {
        DefaultTableModel model = (DefaultTableModel) cartTbl.getModel();
        CartManager manager = new CartManager();
        try {
            String cusID = new User().readtemp();
            cartList = manager.searchcart(cusID);
            if (cartList != null) {

                if (!cartList.getCusID().isEmpty()) {

                    Object rowData[] = new Object[7];
                    model.setRowCount(0);
                    double total = 0;
                    //read all order items to jtable
                    for (int i = 0; i < cartList.getOrderItems().size(); i++) {
                        rowData[0] = cartList.orderItems.get(i).getProduct().getProductID();
                        rowData[1] = cartList.orderItems.get(i).getProduct().getProductName();
                        rowData[2] = cartList.orderItems.get(i).getProduct().getCategory();
                        rowData[3] = cartList.orderItems.get(i).getProduct().getType();
                        rowData[4] = cartList.orderItems.get(i).getProduct().getPrice();
                        int quantity = cartList.orderItems.get(i).getQuantity();
                        rowData[5] = quantity;

                        double price = (cartList.orderItems.get(i).getProduct().calculator(quantity));
                        total = total + price;

                        rowData[6] = String.format("%.2f", price);
                        model.addRow(rowData);
                        lblPrice.setText("RM" + String.format("%.2f", total));
                        lblPrice.setVisible(true);
                    }
                }

            } else {
                model.setRowCount(0);

            }

        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public ArrayList<OrderItem> readOrderTbl2ArrayList() {
        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        DefaultTableModel table = (DefaultTableModel) cartTbl.getModel();
        try {
            for (int row = 0; row < table.getRowCount(); row++) {
                Product product = new ProductManager().search(cartTbl.getValueAt(row, 0).toString());
                Order o = new Order();
                o.orderItem.setOrderItem(product, Integer.parseInt(cartTbl.getValueAt(row, 5).toString()));
                orderItemList.add(o.orderItem);
            }

        } catch (IOException e) {
        }
        return orderItemList;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCustomer = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnOrder1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnOrder = new javax.swing.JLabel();
        btnLogout1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Rightpanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTbl = new javax.swing.JTable();
        clearAllBtn = new javax.swing.JButton();
        lblAdmin5 = new javax.swing.JLabel();
        txtEditQuantity = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblAdmin3 = new javax.swing.JLabel();
        lblusername = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        checkOutBtn = new javax.swing.JButton();
        lblTimedis = new javax.swing.JLabel();
        lblDatedis = new javax.swing.JLabel();
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

        btnCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomer.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cart.png"))); // NOI18N
        btnCustomer.setText("  CART");
        btnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCustomerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(btnCustomer)
                .addGap(18, 18, 18))
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
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(btnOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
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

        btnLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sign out.png"))); // NOI18N
        btnLogout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        LeftPanel.add(btnLogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 40, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/shopvus.png"))); // NOI18N
        LeftPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 80));

        Background.add(LeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 660));

        Rightpanel.setBackground(new java.awt.Color(254, 242, 242));
        Rightpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(89, 89, 89));
        jLabel11.setText("SHOPPING CART");
        Rightpanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/shoppingcart.png"))); // NOI18N
        Rightpanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 60, 60));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/admin avatar.png"))); // NOI18N
        Rightpanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, 50));

        cartTbl.setBackground(new java.awt.Color(254, 242, 242));
        cartTbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cartTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Category", "Type", "Price per Unit", "Quantity", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        cartTbl.setRowHeight(40);
        cartTbl.setSelectionBackground(new java.awt.Color(255, 110, 109));
        jScrollPane2.setViewportView(cartTbl);

        Rightpanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 820, 370));

        clearAllBtn.setBackground(new java.awt.Color(255, 0, 0));
        clearAllBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearAllBtn.setText("Clear all");
        clearAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllBtnActionPerformed(evt);
            }
        });
        Rightpanel.add(clearAllBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        lblAdmin5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAdmin5.setText("Quantity");
        Rightpanel.add(lblAdmin5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, -1, 40));

        txtEditQuantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtEditQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Rightpanel.add(txtEditQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 60, 40));

        editBtn.setBackground(new java.awt.Color(0, 153, 204));
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("EDIT QUANTITY");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        Rightpanel.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 130, 40));

        removeBtn.setBackground(new java.awt.Color(255, 51, 51));
        removeBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeBtn.setText("REMOVE PRODUCT");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        Rightpanel.add(removeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 150, 40));

        lblPrice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 51, 51));
        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrice.setText("RM 0.00");
        Rightpanel.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, 140, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("TOTAL PRICE:");
        Rightpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 110, 40));

        lblAdmin3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAdmin3.setText("HELLO,");
        Rightpanel.add(lblAdmin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        lblusername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblusername.setText("customer");
        Rightpanel.add(lblusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 70, -1));

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("Order Time");
        Rightpanel.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 90, -1));

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("Order Date");
        Rightpanel.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 90, -1));

        checkOutBtn.setBackground(new java.awt.Color(0, 153, 0));
        checkOutBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        checkOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        checkOutBtn.setText("CHECKOUT");
        checkOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutBtnActionPerformed(evt);
            }
        });
        Rightpanel.add(checkOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 600, 140, 40));

        lblTimedis.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTimedis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimedis.setText("jLabel1");
        Rightpanel.add(lblTimedis, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 110, 30));

        lblDatedis.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDatedis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatedis.setText("jLabel1");
        Rightpanel.add(lblDatedis, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 110, 30));

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

    private void btnCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomerMouseClicked

    }//GEN-LAST:event_btnCustomerMouseClicked

    private void btnOrder1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrder1MouseClicked
        this.dispose();
        new CustomerOrder().setVisible(true);
    }//GEN-LAST:event_btnOrder1MouseClicked

    private void btnOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseClicked
        this.dispose();
        new CustomerProfile().setVisible(true);
    }//GEN-LAST:event_btnOrderMouseClicked

    private void clearAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllBtnActionPerformed

        try {
            String cusID = new User().readtemp();
            CartManager manager = new CartManager();
            manager.delete(cusID);
            addProduct2CartJTable();
        } catch (IOException ex) {
            Logger.getLogger(CustomerCart.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_clearAllBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if (new CustomerManager().isStringNumeric(txtEditQuantity.getText())) {
            JOptionPane.showMessageDialog(null, "Please insert integer");
            return;
        }
        int row = cartTbl.getSelectedRow();
        int selectedRow = cartTbl.convertRowIndexToModel(row);
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select product");
        } else {
            int quantity = Integer.parseInt(txtEditQuantity.getText());
            if (quantity > 0) {
                CartManager manager = new CartManager();
                ProductManager pmanager = new ProductManager();
                String productID = cartTbl.getValueAt(selectedRow, 0).toString();
                try {
                    String cusID = new User().readtemp();
                    if (quantity <= pmanager.search(productID).getStock()) {
                        manager.modify(cusID, pmanager.search(productID), quantity);
                    } else {
                        JOptionPane.showMessageDialog(this, "Product out of stock");
                    }
                } catch (IOException ex) {
                    System.out.println("Error");
                }
                addProduct2CartJTable();
            } else {
                JOptionPane.showMessageDialog(this, "Quantity must more than 1");
            }

        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed

        int row = cartTbl.getSelectedRow();
        int selectedRow = cartTbl.convertRowIndexToModel(row);

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select product");
        } else {
            CartManager manager = new CartManager();
            ProductManager pmanager = new ProductManager();
            String productID = cartTbl.getValueAt(selectedRow, 0).toString();
            try {
                String cusID = new User().readtemp();
                manager.remove(cusID, pmanager.search(productID));
                addProduct2CartJTable();
            } catch (IOException ex) {
                System.out.println("Error");
            }

        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void checkOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutBtnActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Comfirm Your Order?", "Choice", JOptionPane.YES_NO_OPTION);
        double total = 0;
        if (choice == 0) {
            try {
                OrderManager oManager = new OrderManager();
                Customer customer = new CustomerManager().search(new User().readtemp());
                String OrderID = oManager.generateID();

                for (int i = 0; i < cartList.getOrderItems().size(); i++) {
                    int quantity = cartList.orderItems.get(i).getQuantity();
                    double price = (cartList.orderItems.get(i).getProduct().calculator(quantity));
                    cartList.orderItems.get(i).getProduct().getProductID();
                    total = total + price;
                }
                ArrayList<Product> productList;
                productList = new ProductManager().read();
                for (int i = 0; i < cartList.getOrderItems().size(); i++) {
                    for (int j = 0; j < productList.size(); j++) {
                        if (cartList.orderItems.get(i).getProduct().getProductID().equals(productList.get(j).getProductID())) {
                            productList.get(j).setStock(productList.get(j).getStock() - cartList.orderItems.get(i).getQuantity());
                        }
                    }
                }
                new ProductManager().printProList2File(productList);
                ArrayList<OrderItem> orderItemList = readOrderTbl2ArrayList();
                Order order = new Order(OrderID, customer, lblDatedis.getText(), lblTimedis.getText(), (double) Math.round(total) * 100 / 100, orderItemList);
                ArrayList<Order> orderList = oManager.read();
                orderList.add(order);

                oManager.printOrder2File(orderList);
                JOptionPane.showMessageDialog(null, "Order Successfully Placed");
                DefaultTableModel model = (DefaultTableModel) cartTbl.getModel();
                model.setRowCount(0);
                txtEditQuantity.setText("");
                lblPrice.setText("RM 0.00");
                new CartManager().delete(new User().readtemp());

            } catch (IOException e) {
            }

        }

    }//GEN-LAST:event_checkOutBtnActionPerformed

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Choice", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            this.dispose();
            LoginPage m = new LoginPage();
            m.setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(CustomerCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerCart().setVisible(true);
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
    private javax.swing.JTable cartTbl;
    private javax.swing.JButton checkOutBtn;
    private javax.swing.JButton clearAllBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdmin3;
    private javax.swing.JLabel lblAdmin5;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDatedis;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimedis;
    private javax.swing.JLabel lblusername;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTextField txtEditQuantity;
    // End of variables declaration//GEN-END:variables
}

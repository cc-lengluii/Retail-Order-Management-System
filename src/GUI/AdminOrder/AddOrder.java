/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.AdminOrder;

import GUI.AdminProduct.AddProduct;
import GUI.AdminCustomer.AddCustomer;
import GUI.AdminHome.AdminHome;
import GUI.LoginPage;
import assignment.Products.Product;
import assignment.Products.ProductManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import assignment.Customers.CustomerManager;
import assignment.Customers.Customer;
import assignment.Orders.Order;
import assignment.Orders.OrderItem;
import assignment.Orders.OrderManager;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author user
 */
public class AddOrder extends javax.swing.JFrame {

    DecimalFormat df = new DecimalFormat("#.##");
    ArrayList<Product> productList = new ArrayList<>();
    DefaultComboBoxModel cusCombo = new DefaultComboBoxModel();
    ArrayList<Order> orderList = new ArrayList<>();
    int item = 0;
    boolean modifyHistory = false;
    int selectedOrder;

    /**
     * Creates new form AddOrder
     */
    public AddOrder() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblDatedis1.setVisible(false);
        lblTimedis1.setVisible(false);
        lblDatedis.setText(new Order().DateGenerator()); //current date n time generator
        lblTimedis.setText(new Order().TimeGenerator());
        addProduct2JTable();
        sortProTable();
        try {
            loadCustomer2Combo();
            AutoCompleteDecorator.decorate(jcbCusID);

        } catch (IOException e) {
        }
    }

    //call this constructor admin want to modify a particular order
    public AddOrder(int cusOrder) {
        initComponents();
        this.setLocationRelativeTo(null);
        item = 1;
        modifyHistory = true; //modify previous order
        this.selectedOrder = cusOrder;
        lblDatedis.setText(new Order().DateGenerator());
        lblTimedis.setText(new Order().TimeGenerator());
        lblDatedis.setVisible(false);
        lblTimedis.setVisible(false);
        addRow2OrderJTable(selectedOrder);
        addProduct2JTable();
        sortProTable();
        try {
            loadCustomer2Combo();
            AutoCompleteDecorator.decorate(jcbCusID);

        } catch (IOException e) {
        }
    }

    //Display all available products to jtable
    public void addProduct2JTable() {
        DefaultTableModel model = (DefaultTableModel) productTbl.getModel();
        ProductManager pManager = new ProductManager();
        try {
            productList = pManager.read();
            Object rowData[] = new Object[6];
            model.setRowCount(0);
            for (int i = 0; i < productList.size(); i++) {
                rowData[0] = productList.get(i).getProductID();
                rowData[1] = productList.get(i).getProductName();
                rowData[2] = productList.get(i).getCategory();
                rowData[3] = productList.get(i).getType();
                rowData[4] = productList.get(i).getPrice();
                rowData[5] = productList.get(i).getStock();
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

    //add registered customer's id to combo box
    public void loadCustomer2Combo() throws IOException {

        ArrayList<Customer> customerList = new CustomerManager().read();
        for (Customer cus : customerList) {
            cusCombo.addElement(cus.getCusID());

        }
        jcbCusID.setModel(cusCombo);

    }

    //add customer ordered items from order history to jtable 
    public void addRow2OrderJTable(int cusOrder) {
        DefaultTableModel model = (DefaultTableModel) orderTbl.getModel();
        try {
            OrderManager oManager = new OrderManager();
            orderList = oManager.read();
            Object rowData[] = new Object[7];
            model.setRowCount(0);
            for (int i = 0; i < orderList.get(cusOrder).orderItems.size(); i++) {
                rowData[0] = orderList.get(cusOrder).orderItems.get(i).getProduct().getProductID();
                rowData[1] = orderList.get(cusOrder).orderItems.get(i).getProduct().getProductName();
                rowData[2] = orderList.get(cusOrder).orderItems.get(i).getProduct().getCategory();
                rowData[3] = orderList.get(cusOrder).orderItems.get(i).getProduct().getType();
                rowData[4] = orderList.get(cusOrder).orderItems.get(i).getProduct().getPrice();
                rowData[5] = orderList.get(cusOrder).orderItems.get(i).getQuantity();
                double total = orderList.get(cusOrder).orderItems.get(i).getQuantity() * orderList.get(cusOrder).orderItems.get(i).getProduct().getPrice();
                rowData[6] = total;

                model.addRow(rowData);
            }
            txtTotalPrice.setText(String.valueOf(orderList.get(cusOrder).getTotalPrice()));
            cusCombo.setSelectedItem(orderList.get(cusOrder).getCustomer().getCusID());
            lblDatedis1.setText(orderList.get(cusOrder).getDate());
            lblTimedis1.setText(orderList.get(cusOrder).getTime());
        } catch (IOException e) {
        }
    }

    //read all order items from the jtable and store them in user-defined array list
    public ArrayList<OrderItem> readOrderTbl2ArrayList() {
        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        DefaultTableModel table = (DefaultTableModel) orderTbl.getModel();
        try {
            for (int row = 0; row < table.getRowCount(); row++) {
                Product product = new ProductManager().search(orderTbl.getValueAt(row, 0).toString());
                Order o = new Order();
                o.orderItem.setOrderItem(product, Integer.parseInt(orderTbl.getValueAt(row, 5).toString()));
                orderItemList.add(o.orderItem);
            }

        } catch (IOException e) {
        }
        return orderItemList;
    }

    public void displayPrice() {

        ArrayList<OrderItem> orderItemList = readOrderTbl2ArrayList();
        double itemPrice = 0;
        double totalPrice = 0;
        for (int i = 0; i < orderItemList.size(); i++) {
            itemPrice = (double) Math.round(orderItemList.get(i).getProduct().getPrice() * orderItemList.get(i).getQuantity() * 100) / 100;
            totalPrice = itemPrice + totalPrice;
        }
        txtTotalPrice.setText(String.valueOf(df.format(totalPrice)));

    }

    //display all order items from the new order to jtable
    public void addRow2OrderJTable(ArrayList<OrderItem> orderItemList) {
        DefaultTableModel model = (DefaultTableModel) orderTbl.getModel();
        Object rowData[] = new Object[7];
        model.setRowCount(0);
        for (int i = 0; i < orderItemList.size(); i++) {
            rowData[0] = orderItemList.get(i).getProduct().getProductID();
            rowData[1] = orderItemList.get(i).getProduct().getProductName();
            rowData[2] = orderItemList.get(i).getProduct().getCategory();
            rowData[3] = orderItemList.get(i).getProduct().getType();
            rowData[4] = orderItemList.get(i).getProduct().getPrice();
            rowData[5] = orderItemList.get(i).getQuantity();
            rowData[6] = (double) Math.round(orderItemList.get(i).getProduct().getPrice() * orderItemList.get(i).getQuantity() * 100) / 100;

            model.addRow(rowData);

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
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbCusID = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        addProbtn = new javax.swing.JButton();
        txtSearchPro = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        productTbl = new javax.swing.JTable();
        lblProList1 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        editQuantitybtn = new javax.swing.JButton();
        removeOrderbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTbl = new javax.swing.JTable();
        txtNewQuantity = new javax.swing.JTextField();
        lblNewQuantity = new javax.swing.JLabel();
        lblProList = new javax.swing.JLabel();
        placeOrderBtn = new javax.swing.JButton();
        lblAdmin1 = new javax.swing.JLabel();
        lblAdmin2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        viewOrderHisbtn = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        lblTimedis = new javax.swing.JLabel();
        lblDatedis1 = new javax.swing.JLabel();
        lblTimedis1 = new javax.swing.JLabel();
        lblDatedis = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JLabel();
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
        btnOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/order.png"))); // NOI18N
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
        Rightpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(89, 89, 89));
        jLabel11.setText("Customer Order");
        Rightpanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        Rightpanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTime.setText("Order Time");
        Rightpanel.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/admin avatar.png"))); // NOI18N
        Rightpanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, 50));

        jcbCusID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcbCusID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Rightpanel.add(jcbCusID, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 90, -1));

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addProbtn.setBackground(new java.awt.Color(0, 153, 51));
        addProbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addProbtn.setForeground(new java.awt.Color(255, 255, 255));
        addProbtn.setText("Add Order");
        addProbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProbtnActionPerformed(evt);
            }
        });
        jPanel5.add(addProbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 100, -1));

        txtSearchPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchProKeyReleased(evt);
            }
        });
        jPanel5.add(txtSearchPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 101, -1));

        productTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        productTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        productTbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        productTbl.setSelectionBackground(new java.awt.Color(255, 110, 109));
        jScrollPane3.setViewportView(productTbl);
        if (productTbl.getColumnModel().getColumnCount() > 0) {
            productTbl.getColumnModel().getColumn(0).setPreferredWidth(50);
            productTbl.getColumnModel().getColumn(1).setPreferredWidth(180);
            productTbl.getColumnModel().getColumn(2).setPreferredWidth(100);
            productTbl.getColumnModel().getColumn(3).setPreferredWidth(50);
            productTbl.getColumnModel().getColumn(4).setPreferredWidth(80);
            productTbl.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 48, 539, 142));

        lblProList1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProList1.setForeground(new java.awt.Color(89, 89, 89));
        lblProList1.setText("Product List");
        jPanel5.add(lblProList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 20, -1, -1));

        txtQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel5.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 105, 45, 35));

        lblQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQuantity.setText("Enter Quantity:");
        jPanel5.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 105, -1, 23));

        lblSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSearch.setText("Search");
        jPanel5.add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 20));

        Rightpanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 160, 900, 200));

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));

        editQuantitybtn.setBackground(new java.awt.Color(0, 153, 204));
        editQuantitybtn.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        editQuantitybtn.setForeground(new java.awt.Color(255, 255, 255));
        editQuantitybtn.setText("Edit Quantity");
        editQuantitybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editQuantitybtnActionPerformed(evt);
            }
        });

        removeOrderbtn.setBackground(new java.awt.Color(255, 0, 0));
        removeOrderbtn.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        removeOrderbtn.setForeground(new java.awt.Color(255, 255, 255));
        removeOrderbtn.setText("Remove");
        removeOrderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOrderbtnActionPerformed(evt);
            }
        });

        orderTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        orderTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Category", "Type", "Price per Unit", "Quantity", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        orderTbl.setSelectionBackground(new java.awt.Color(255, 110, 109));
        jScrollPane2.setViewportView(orderTbl);
        if (orderTbl.getColumnModel().getColumnCount() > 0) {
            orderTbl.getColumnModel().getColumn(0).setPreferredWidth(50);
            orderTbl.getColumnModel().getColumn(1).setPreferredWidth(180);
            orderTbl.getColumnModel().getColumn(2).setPreferredWidth(100);
            orderTbl.getColumnModel().getColumn(3).setPreferredWidth(50);
            orderTbl.getColumnModel().getColumn(4).setPreferredWidth(80);
            orderTbl.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        txtNewQuantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNewQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewQuantityActionPerformed(evt);
            }
        });

        lblNewQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNewQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNewQuantity.setText("Enter Quantity:");

        lblProList.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProList.setForeground(new java.awt.Color(89, 89, 89));
        lblProList.setText("Order Items List");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(lblProList))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editQuantitybtn, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(removeOrderbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblNewQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lblProList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editQuantitybtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeOrderbtn)
                        .addGap(28, 28, 28))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Rightpanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 380, 900, -1));

        placeOrderBtn.setBackground(new java.awt.Color(0, 153, 51));
        placeOrderBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        placeOrderBtn.setForeground(new java.awt.Color(255, 255, 255));
        placeOrderBtn.setText("Place Order");
        placeOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOrderBtnActionPerformed(evt);
            }
        });
        Rightpanel.add(placeOrderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 600, -1, -1));

        lblAdmin1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAdmin1.setText("HELLO,Admin");
        Rightpanel.add(lblAdmin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        lblAdmin2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAdmin2.setText("Customer");
        Rightpanel.add(lblAdmin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, -1, -1));

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDate.setText("Order Date");
        Rightpanel.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        viewOrderHisbtn.setBackground(new java.awt.Color(0, 153, 204));
        viewOrderHisbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        viewOrderHisbtn.setForeground(new java.awt.Color(255, 255, 255));
        viewOrderHisbtn.setText("View Order History");
        viewOrderHisbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderHisbtnActionPerformed(evt);
            }
        });
        Rightpanel.add(viewOrderHisbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, -1, -1));

        lblTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTotalPrice.setText("Total Price");
        Rightpanel.add(lblTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 590, 120, 40));

        lblTimedis.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblTimedis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimedis.setText("jLabel1");
        Rightpanel.add(lblTimedis, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 90, 30));

        lblDatedis1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDatedis1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatedis1.setText("jLabel1");
        Rightpanel.add(lblDatedis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 30));

        lblTimedis1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblTimedis1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimedis1.setText("jLabel1");
        Rightpanel.add(lblTimedis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 90, 30));

        lblDatedis.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDatedis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatedis.setText("jLabel1");
        Rightpanel.add(lblDatedis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 30));

        txtTotalPrice.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        txtTotalPrice.setForeground(new java.awt.Color(255, 0, 51));
        txtTotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTotalPrice.setText("RM 0");
        Rightpanel.add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, 110, 50));

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
        AdminHome m = new AdminHome();
        m.setVisible(true);
    }//GEN-LAST:event_btnHomeMouseClicked

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

    private void txtSearchProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchProKeyReleased

        String searchPro = txtSearchPro.getText().trim();
        TableRowSorter<DefaultTableModel> search = sortProTable();
        productTbl.setRowSorter(search);

        search.setRowFilter(RowFilter.regexFilter("(?i)" + searchPro));

    }//GEN-LAST:event_txtSearchProKeyReleased

    private void addProbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProbtnActionPerformed
        if (new CustomerManager().isStringNumeric(txtQuantity.getText())) {
            JOptionPane.showMessageDialog(null, "Please insert quantity");
            return;
        }
        if (Integer.parseInt(txtQuantity.getText()) < 1) {
            JOptionPane.showMessageDialog(null, "Quantity must more than 1");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) orderTbl.getModel();
        ProductManager pManager = new ProductManager();
        boolean flag = true;
        {
            if (item == 0) { //if it is a new order
                int row = productTbl.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select row to add the item");
                } else {
                    try {
                        int selectedRow = productTbl.convertRowIndexToModel(row);
                        productList = pManager.read();

                        int stock = productList.get(selectedRow).getStock();
                        if (Integer.parseInt(txtQuantity.getText()) <= stock) {
                            productList.get(selectedRow).setStock(stock - Integer.parseInt(txtQuantity.getText()));

                            //display to jtable
                            Object rowData[] = new Object[7];
                            rowData[0] = productList.get(selectedRow).getProductID();
                            rowData[1] = productList.get(selectedRow).getProductName();
                            rowData[2] = productList.get(selectedRow).getCategory();
                            rowData[3] = productList.get(selectedRow).getType();
                            rowData[4] = productList.get(selectedRow).getPrice();
                            rowData[5] = txtQuantity.getText();
                            rowData[6] = (double) Math.round(productList.get(selectedRow).getPrice() * Integer.parseInt(txtQuantity.getText()) * 100) / 100;
                            model.addRow(rowData);
                            //write new productlist to file
                            pManager.printProList2File(productList);
                            //display the latest product details to jTable
                            addProduct2JTable();
                            displayPrice();

                            item++;

                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient Stock");
                        }
                    } catch (IOException o) {
                    }

                }
            } else { //if it is from order history and admin needs to modify the order
                ArrayList<OrderItem> orderItemList = readOrderTbl2ArrayList();

                int row = productTbl.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select row to update");
                }
                try {
                    int selectedRow = productTbl.convertRowIndexToModel(row);
                    productList = pManager.read();
                    for (int i = 0; i < orderItemList.size(); i++) {
                        if ((orderItemList.get(i).getProduct().getProductID()).equals(productList.get(selectedRow).getProductID())) {
                            flag = false;
                        }
                    }

                    if (flag == true) {
                        int stock = productList.get(selectedRow).getStock();
                        if (Integer.parseInt(txtQuantity.getText()) <= stock) {
                            productList.get(selectedRow).setStock(stock - Integer.parseInt(txtQuantity.getText()));

                            //display to jtable
                            Object rowData[] = new Object[7];
                            rowData[0] = productList.get(selectedRow).getProductID();
                            rowData[1] = productList.get(selectedRow).getProductName();
                            rowData[2] = productList.get(selectedRow).getCategory();
                            rowData[3] = productList.get(selectedRow).getType();
                            rowData[4] = productList.get(selectedRow).getPrice();
                            rowData[5] = txtQuantity.getText();
                            rowData[6] = (double) Math.round(productList.get(selectedRow).getPrice() * Integer.parseInt(txtQuantity.getText()) * 100) / 100;
                            model.addRow(rowData);
                            //write new productlist to file
                            pManager.printProList2File(productList);
                            //display the latest product details to jTable
                            addProduct2JTable();
                            displayPrice();
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient Stock");

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Product has been added. Please modify the quantity");
                    }

                } catch (IOException o) {
                }

            }
        }
        txtQuantity.setText("");

    }//GEN-LAST:event_addProbtnActionPerformed

    private void placeOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOrderBtnActionPerformed

        ArrayList<OrderItem> orderItemList = readOrderTbl2ArrayList();
        if (!orderItemList.isEmpty()) {

            int choice = JOptionPane.showConfirmDialog(null, "Comfirm Your Order?", "Choice", JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                OrderManager oManager = new OrderManager();
                Customer customer = new CustomerManager().search(jcbCusID.getSelectedItem().toString());
                int selectedRow = -1;
                String OrderID = oManager.generateID(); //generate unique ID for order
                Order order = new Order(OrderID, customer, lblDatedis.getText(), lblTimedis.getText(), Double.parseDouble(txtTotalPrice.getText()), orderItemList);
                try {
                    orderList = oManager.read();
                    if (modifyHistory == false) { //if it is a new order
                        orderList.add(order);

                    } else { //if it is from order history and admin need to modify it
                        for (int index = 0; index < orderList.size(); index++) {
                            if (orderList.get(index).getCustomer().getCusID().equals(order.getCustomer().getCusID())
                                    && orderList.get(index).getDate().equals(lblDatedis1.getText())
                                    && orderList.get(index).getTime().equals(lblTimedis1.getText())) {
                                selectedRow = index;
                            }
                        }

                        order.setOrderID(orderList.get(selectedRow).getOrderID()); //set the order ID same as previous order
                        orderList.remove(selectedRow);
                        orderList.add(selectedRow, order);  //add the order back to its original position

                    }
                    oManager.printOrder2File(orderList);

                } catch (IOException e) {
                }
                JOptionPane.showMessageDialog(null, "Order Successfully Placed");
                DefaultTableModel model = (DefaultTableModel) orderTbl.getModel();
                model.setRowCount(0);
                txtQuantity.setText("");
                txtNewQuantity.setText("");
                txtTotalPrice.setText("");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please add item(s) before check out");

        }

    }//GEN-LAST:event_placeOrderBtnActionPerformed

    private void editQuantitybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editQuantitybtnActionPerformed

        if (new CustomerManager().isStringNumeric(txtNewQuantity.getText())) {
            JOptionPane.showMessageDialog(null, "Please insert quantity");
            return;
        }
        if (Integer.parseInt(txtNewQuantity.getText()) < 1) {
            JOptionPane.showMessageDialog(null, "Quantity must more than 1");
            return;
        }
        ProductManager pManager = new ProductManager();
        ArrayList<OrderItem> orderItemList = readOrderTbl2ArrayList();
        int orderRow = orderTbl.getSelectedRow();
        int selectedProduct = -1;

        if (orderRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select row to update the quantity");
        } else {
            try {
                productList = pManager.read();
                int selectedOrderRow = orderTbl.convertRowIndexToModel(orderRow);
                for (int i = 0; i < productList.size(); i++) {
                    if (productList.get(i).getProductID().equals(orderItemList.get(selectedOrderRow).getProduct().getProductID())) {
                        selectedProduct = i;
                    }
                }
                int stock = (productList.get(selectedProduct).getStock() + orderItemList.get(selectedOrderRow).getQuantity());
                if (Integer.parseInt(txtNewQuantity.getText()) <= stock) {
                    productList.get(selectedProduct).setStock(stock - Integer.parseInt(txtNewQuantity.getText()));

                    pManager.printProList2File(productList);
                    //display the latest product details to product jTable
                    addProduct2JTable();
                    orderItemList.get(selectedOrderRow).setQuantity(Integer.parseInt(txtNewQuantity.getText()));
                    //print new OrderItemList to order list jTble;
                    addRow2OrderJTable(orderItemList);
                    displayPrice();
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient Stock");
                }
                txtNewQuantity.setText("");

            } catch (IOException e) {
            }

        }

    }//GEN-LAST:event_editQuantitybtnActionPerformed

    private void removeOrderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOrderbtnActionPerformed

        ArrayList<OrderItem> orderItemList = readOrderTbl2ArrayList();
        int selectedProduct = -1;
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure to delete this product?", "Delete", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {

            int row = orderTbl.getSelectedRow();
            int selectedRow = orderTbl.convertRowIndexToModel(row);

            //update stock in product list
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductID().equals(orderItemList.get(selectedRow).getProduct().getProductID())) {
                    selectedProduct = i;
                }
            }
            int stock = (productList.get(selectedProduct).getStock() + orderItemList.get(selectedRow).getQuantity());
            productList.get(selectedProduct).setStock(stock);

            orderItemList.remove(selectedRow);

            JOptionPane.showMessageDialog(this, "Delete Successfully");

        }
        try {
            new ProductManager().printProList2File(productList);
            //display the latest product details to product jTable
            addProduct2JTable();
            addRow2OrderJTable(orderItemList);
            displayPrice();
        } catch (IOException e) {
        }

    }//GEN-LAST:event_removeOrderbtnActionPerformed

    private void viewOrderHisbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderHisbtnActionPerformed

        setVisible(false);
        new ManageOrder().setVisible(true);

    }//GEN-LAST:event_viewOrderHisbtnActionPerformed

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Choice", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            this.dispose();
            LoginPage m = new LoginPage();
            m.setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void txtNewQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewQuantityActionPerformed

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
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADMIN;
    private javax.swing.JPanel Background;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JLabel PANEL;
    private javax.swing.JPanel Rightpanel;
    private javax.swing.JPanel Roundcorner;
    private javax.swing.JButton addProbtn;
    private javax.swing.JLabel btnCustomer;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnOrder;
    private javax.swing.JLabel btnProduct;
    private javax.swing.JButton editQuantitybtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jcbCusID;
    private javax.swing.JLabel lblAdmin1;
    private javax.swing.JLabel lblAdmin2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDatedis;
    private javax.swing.JLabel lblDatedis1;
    private javax.swing.JLabel lblNewQuantity;
    private javax.swing.JLabel lblProList;
    private javax.swing.JLabel lblProList1;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimedis;
    private javax.swing.JLabel lblTimedis1;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JTable orderTbl;
    private javax.swing.JButton placeOrderBtn;
    private javax.swing.JTable productTbl;
    private javax.swing.JButton removeOrderbtn;
    private javax.swing.JTextField txtNewQuantity;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearchPro;
    private javax.swing.JLabel txtTotalPrice;
    private javax.swing.JButton viewOrderHisbtn;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juju.pharmacy;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author user
 */
public class bill extends javax.swing.JPanel {

    /**
     * Creates new form bill
     */
    public bill() {
        initComponents();
        AutoCompleteDecorator.decorate(brand_name);
        med_load();
        mtb_load();

    }
    java.util.Date today;
    java.sql.Date date;
    int sn=1;
    int sel;
    int qty_flag=0;
    private static final DecimalFormat decfor = new DecimalFormat("0.00"); 
    public void med_load(){
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT DISTINCT brand_name FROM medicine");
            Vector v=new Vector(); 
            while(rs.next()){ 
                v.add(rs.getString("brand_name"));
                DefaultComboBoxModel com=new DefaultComboBoxModel(v);
                brand_name.setModel(com);
            }
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public String sup_id(String id){
        String name="";
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM supplier where id="+id);
            if(rs.next())
                name = rs.getString(2);
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        return name;
    }
    public String med_id(String bt,String bname){
        String name="";
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine where batch_no='"+bt+"' and brand_name='"+bname+"'");
            if(rs.next())
                name = rs.getString(1);
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        return name;
    }
    public void mtb_load(){
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable2.getModel();
            dt.setRowCount(0);
            
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine");
            while(rs.next()){
                
                Vector v=new Vector();  
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(sup_id(rs.getString(5)));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(11));
                v.add(rs.getString(10));
                dt.addRow(v);
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void mtb_load(String sql){
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable2.getModel();
            dt.setRowCount(0);
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                Vector v=new Vector();  
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(sup_id(rs.getString(5)));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(11));
                v.add(rs.getString(10));
                dt.addRow(v);
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void billtb_load(){
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable2.getModel();
            dt.setRowCount(0);
            int dec=0;
            int check=1,display=1;
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine");
            while(rs.next()){
                
                Vector v=new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(sup_id(rs.getString(5)));
                dec=rs.getInt(6);
                for(int i=0;i<jTable1.getRowCount();i++){
                    if(jTable1.getValueAt(i,4).toString().equals(rs.getString("batch_no"))&&jTable1.getValueAt(i,1).toString().equals(rs.getString("brand_name"))){
                        dec=dec-Integer.parseInt(jTable1.getValueAt(i,2).toString());
                        display=0;
                        if(dec<1)
                            check=0;
                    }
                    
                }
                if(display==1)
                    v.add(rs.getString(6));
                else
                    v.add(dec);
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(11));
                v.add(rs.getString(10));
                if(check==1)
                    dt.addRow(v);
                check=1;
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        batch_no = new javax.swing.JTextField();
        unit_price = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        brand_name = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        discount_amt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        grand_total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        payment = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        balance = new javax.swing.JTextField();
        each_total = new javax.swing.JTextField();
        discount = new javax.swing.JTextField();
        add_bill = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        get_bill = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        print_bill = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTxt = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Brand Name :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("unit price :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Batch No.  :");

        batch_no.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        batch_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batch_noActionPerformed(evt);
            }
        });
        batch_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                batch_noKeyReleased(evt);
            }
        });

        unit_price.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        unit_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unit_priceActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Product Id :");

        pid.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pidKeyTyped(evt);
            }
        });

        quantity.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Quantity :");

        brand_name.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        brand_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        brand_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                brand_nameItemStateChanged(evt);
            }
        });
        brand_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brand_nameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Total:");

        discount_amt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Discount:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Grand Total");

        grand_total.setEditable(false);
        grand_total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        grand_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grand_totalActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Payment :");

        payment.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Balance :");

        balance.setEditable(false);
        balance.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceActionPerformed(evt);
            }
        });

        each_total.setEditable(false);
        each_total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        each_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                each_totalActionPerformed(evt);
            }
        });

        discount.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        add_bill.setBackground(new java.awt.Color(255, 255, 255));
        add_bill.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        add_bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/adds.png"))); // NOI18N
        add_bill.setText("Add to bill");
        add_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_billActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/edits.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/deletes.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        get_bill.setBackground(new java.awt.Color(255, 255, 255));
        get_bill.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        get_bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/bills.png"))); // NOI18N
        get_bill.setText("Get Bill");
        get_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_billActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(255, 255, 255));
        clear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/clears.png"))); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(add_bill)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(unit_price, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(batch_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pid)
                                .addComponent(quantity)
                                .addComponent(brand_name, 0, 191, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(update)
                        .addGap(37, 37, 37)
                        .addComponent(delete)))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(balance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(grand_total)
                                .addComponent(each_total)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(discount_amt, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(clear)
                        .addGap(57, 57, 57)
                        .addComponent(get_bill)))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(brand_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(unit_price, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(batch_no, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(each_total, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(discount_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(grand_total, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(add_bill)
                    .addComponent(get_bill)
                    .addComponent(update)
                    .addComponent(clear))
                .addContainerGap())
        );

        print_bill.setBackground(new java.awt.Color(255, 255, 255));
        print_bill.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        print_bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/prints.jpg"))); // NOI18N
        print_bill.setText("Print Bill");
        print_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_billActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "S.N ", "Product Name", "Quantity", "Price", "Batch No", "Total"
            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BillTxt.setColumns(20);
        BillTxt.setRows(5);
        jScrollPane2.setViewportView(BillTxt);

        jTable2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Product Id", "Brand Name", "Generic Name", "Company Name", "Supplier", "Quantity", "Cost Price", "Market Price", "Batch no", "Expiry Date", "Entry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFillsViewportHeight(true);
        jTable2.setRowHeight(25);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1243, Short.MAX_VALUE)
                        .addGap(84, 84, 84)
                        .addComponent(print_bill)
                        .addGap(94, 94, 94)))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(print_bill)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void batch_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batch_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batch_noActionPerformed

    private void unit_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unit_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unit_priceActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void brand_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brand_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brand_nameActionPerformed

    private void grand_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grand_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grand_totalActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        // TODO add your handling code here:
        float bal=Float.parseFloat(payment.getText())-Float.parseFloat(grand_total.getText());
        balance.setText(decfor.format(bal));
    }//GEN-LAST:event_paymentActionPerformed

    private void balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceActionPerformed

    private void each_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_each_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_each_totalActionPerformed

    private void get_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_billActionPerformed
        // TODO add your handling code here:
        float total=0;;
        int last_id=0;
        DefaultTableModel dt= (DefaultTableModel) jTable1.getModel();
        for(int i=0;i<jTable1.getRowCount();i++){
            total=total+Float.parseFloat(jTable1.getValueAt(i,5).toString());
        }
        String dis=discount.getText().isEmpty()?"0":discount.getText();
        String grand=grand_total.getText();
        String pay=payment.getText();
        String bal=balance.getText();
        try{
            today=new java.util.Date(); ;
            date= new java.sql.Date(today.getTime());
        }catch(Exception e){
            System.out.println(e);
        }
        if(grand_total.getText().isEmpty()||payment.getText().isEmpty()||balance.getText().isEmpty()||total==0){
            JOptionPane.showMessageDialog(null, "Missing Information");
        }else{
            try{
                String query="INSERT INTO bill (date,total,discount,grand_total,payment,balance) VALUES(?,?,?,?,?,?)";
                PreparedStatement pst=db.mycon().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                pst.setDate(1, date);
                pst.setFloat(2, total);
                pst.setFloat(3, Float.parseFloat(dis));
                pst.setFloat(4, Float.parseFloat(grand));
                pst.setFloat(5, Float.parseFloat(pay));
                pst.setFloat(6, Float.parseFloat(bal));
                pst.executeUpdate();
                
                ResultSet rs=pst.getGeneratedKeys();
                if(rs.next())
                    last_id=rs.getInt(1);
                query="INSERT INTO sale_purchase (medicine_id,quantity,price,batch_no,total,date,bill_id) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement pst1=db.mycon().prepareStatement(query);
                PreparedStatement pst2=db.mycon().prepareStatement("UPDATE medicine set quantity=quantity-? where product_id=? AND batch_no=?");
                int med,qty;
                String btch;
                float price,etotal;
                for(int i=0;i<jTable1.getRowCount();i++){
                    btch=jTable1.getValueAt(i, 4).toString();
                    med=Integer.parseInt(med_id(btch,jTable1.getValueAt(i, 1).toString()));
                    qty=Integer.parseInt(jTable1.getValueAt(i, 2).toString());
                    price=Float.parseFloat(jTable1.getValueAt(i, 3).toString());
                    etotal=Float.parseFloat(jTable1.getValueAt(i, 5).toString());
                    pst1.setInt(1, med);
                    pst1.setInt(2, qty);
                    pst1.setFloat(3, price);
                    pst1.setString(4, btch);
                    pst1.setFloat(5, etotal);
                    pst1.setDate(6, date);
                    pst1.setInt(7,last_id);
                    pst1.executeUpdate(); 
                    
                    pst2.setInt(1, qty);
                    pst2.setInt(2, med);
                    pst2.setString(3, btch);
                    pst2.executeUpdate();
                    
                }
                
                Statement s=db.mycon().createStatement();
                ResultSet rs1=s.executeQuery("SELECT * FROM sale where date='"+date+"'");
                if(rs1.next()){
                    query="UPDATE sale set total=total+? where date=CURDATE()";
                    PreparedStatement pst3=db.mycon().prepareStatement(query);
                    pst3.setFloat(1,Float.parseFloat(grand));
                    pst3.executeUpdate();
                    pst3.close();
                }
                
                else{
                    query="INSERT INTO sale (date,total) VALUES(?,?)";
                    PreparedStatement pst3=db.mycon().prepareStatement(query);
                    pst3.setFloat(2,Float.parseFloat(grand));
                    pst3.setDate(1, date);
                    pst3.executeUpdate();
                    pst3.close();
                }
                Statement s1=db.mycon().createStatement();
                ResultSet rs2=s1.executeQuery("SELECT * FROM medicine where quantity<=0");
                if(rs2.next()){
                    Statement s2=db.mycon().createStatement();
                    s.executeUpdate("DELETE  FROM medicine where product_id="+rs2.getString("product_id")+" AND batch_no='"+rs2.getString("batch_no")+"'");
                    s2.close();
                }
                    s.close();
                    pst.close();
                    pst1.close();
                    pst2.close();
                    s1.close();
                    db.mycon().close();
                    
                
             }catch(Exception e){    
                System.out.println(e);
                
            } 
        }       
        String paper="        \t\t******************JUJU PHARMACY******************\n "+
                "\t S.N \tMedicine \t\tPrice \tQuantity \tTotal\n";
        for(int i=0;i<jTable1.getRowCount();i++){
            paper=paper+"\t "+jTable1.getValueAt(i, 0).toString()+"\t"+jTable1.getValueAt(i, 1).toString()+" \t\t"+jTable1.getValueAt(i, 3).toString()+" \t"+jTable1.getValueAt(i, 2).toString() +"\t"+jTable1.getValueAt(i, 5).toString()+"\n";
        }
        paper=paper+"\tGrand Total="+grand+"\n\tDiscount="+dis+"\n\tPayment="+pay+"\n\tBalance="+bal;
        BillTxt.setText(paper);
        dt.setRowCount(0);
        sn=1;
        billtb_load();
        
    }//GEN-LAST:event_get_billActionPerformed

    private void print_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_billActionPerformed
        // TODO add your handling code here:
        try{
            BillTxt.print();
            BillTxt.setText("");
        }catch(Exception e){
            System.out.println(e);
        }
        
    }//GEN-LAST:event_print_billActionPerformed

    private void brand_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_brand_nameItemStateChanged
        // TODO add your handling code here:
        String sql="SELECT * FROM medicine";
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine where brand_name='"+brand_name.getSelectedItem()+"'");
            if(rs.next()){
                if(pid.getText().isEmpty()&&batch_no.getText().isEmpty())
                    sql = sql+" where brand_name='"+brand_name.getSelectedItem()+"'";
                else{ 
                    if(batch_no.getText().isEmpty())
                        sql = sql+" where batch_no='"+batch_no.getText()+"' or brand_name='"+brand_name.getSelectedItem()+"'";
                    else
                        sql = sql+" where product_id='"+pid.getText()+"' or brand_name='"+brand_name.getSelectedItem()+"'";
                }
            }
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        mtb_load(sql);
        
    }//GEN-LAST:event_brand_nameItemStateChanged

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int r= jTable2.getSelectedRow();
        String id=jTable2.getValueAt(r, 0).toString();
        String brand= jTable2.getValueAt(r, 1).toString();
        String mp= jTable2.getValueAt(r, 7).toString();
        String btch= jTable2.getValueAt(r, 8).toString();
        pid.setText(id);
        brand_name.setSelectedItem(brand);
        unit_price.setText(mp);
        batch_no.setText(btch);
        mtb_load();
    }//GEN-LAST:event_jTable2MouseClicked

    private void pidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pidKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pidKeyTyped

    private void pidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pidKeyReleased
        // TODO add your handling code here:
        String sql="SELECT * FROM medicine";
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine where product_id="+pid.getText());
            if(rs.next()){
                if(batch_no.getText().isEmpty()){
                    sql = sql+" where product_id="+pid.getText();
                    brand_name.setSelectedItem(rs.getString("brand_name"));
                }
                else
                    sql = sql+" where product_id='"+pid.getText()+"' and batch_no='"+batch_no.getText()+"'";
            }
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        mtb_load(sql);
    }//GEN-LAST:event_pidKeyReleased

    private void batch_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_batch_noKeyReleased
        // TODO add your handling code here:
        String sql="SELECT * FROM medicine";
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine where batch_no='"+batch_no.getText()+"'");
            if(rs.next()){
                if(pid.getText().isEmpty()){
                    sql = sql+" where batch_no='"+batch_no.getText()+"'";
//                    brand_name.setSelectedItem(rs.getString("brand_name"));
                }
                else{
                    sql = sql+" where product_id='"+pid.getText()+"' and batch_no='"+batch_no.getText()+"'";
                }
            }
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        mtb_load(sql);
    }//GEN-LAST:event_batch_noKeyReleased

    private void add_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_billActionPerformed
        // TODO add your handling code here:
        float grand=0;
        float price=Float.parseFloat(unit_price.getText());
        int qty=Integer.parseInt(quantity.getText());
        int new_qty=check_quantity(qty);
        if(qty_flag==0){
            qty=new_qty;
        float total=(float)price*qty;
                DefaultTableModel dt= (DefaultTableModel) jTable1.getModel();
        if(sn==1)
            dt.setRowCount(0);
        dt.addRow(new Object[]{
            sn++,
            brand_name.getSelectedItem(),
            qty,
            unit_price.getText(),
            batch_no.getText(),
            decfor.format(total)
        });
        each_total.setText(decfor.format(total));
        for(int i=0;i<jTable1.getRowCount();i++){
            grand=grand+Float.parseFloat(jTable1.getValueAt(i,5).toString());
        }
        if(!discount.getText().isEmpty()){
            float amt=(Float.parseFloat(discount.getText())*grand)/100;
            discount_amt.setText(decfor.format(amt));
            grand=grand-amt;
            grand_total.setText(decfor.format(grand));
        }
        grand_total.setText(decfor.format(grand));
        pid.setText("");
        brand_name.setSelectedIndex(0);
        quantity.setText("");
        unit_price.setText("");
        batch_no.setText("");
        mtb_load();
        }
        qty_flag=0;
        
    }//GEN-LAST:event_add_billActionPerformed

    public int check_quantity(int qty){
        int ret=qty;
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine where batch_no="+batch_no.getText()+" AND product_id="+pid.getText());
            if(rs.next()){
                if(rs.getInt("quantity")<qty){
                    qty_flag=1;
                    ret=rs.getInt("quantity");
                    JOptionPane.showMessageDialog(null, "There is not enough stock of medicine for this batch_no");
                    
//                    int dialogResult=JOptionPane.showConfirmDialog(null,"","Confirmation",JOptionPane.YES_NO_OPTION );
//                    if(dialogResult==JOptionPane.YES_OPTION){
//
//                    }
                }
            }
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        return ret;
    }
    
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        pid.setText("");
        brand_name.setSelectedIndex(0);
        quantity.setText("");
        unit_price.setText("");
        batch_no.setText("");
        mtb_load();
    }//GEN-LAST:event_clearActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int r= jTable1.getSelectedRow();
        sel=r;
        String brand= jTable1.getValueAt(r, 1).toString();
        String qty= jTable1.getValueAt(r, 2).toString();
        String mp= jTable1.getValueAt(r, 3).toString();
        String btch= jTable1.getValueAt(r, 4).toString();
        pid.setText(med_id(btch,brand));
        brand_name.setSelectedItem(brand);
        quantity.setText(qty);
        unit_price.setText(mp);
        batch_no.setText(btch);
    }//GEN-LAST:event_jTable1MouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        float grand=0;
        DefaultTableModel dt= (DefaultTableModel) jTable1.getModel();
        dt.setValueAt(quantity.getText(), sel, 2);
        float price=Float.parseFloat(unit_price.getText());
        int qty=Integer.parseInt(quantity.getText());
        float total=(float)price*qty;
        dt.setValueAt(total, sel, 5);
         each_total.setText(decfor.format(total));
        for(int i=0;i<jTable1.getRowCount();i++){
            grand=grand+Float.parseFloat(jTable1.getValueAt(i,5).toString());
        }
        if(!discount.getText().isEmpty()){
            float amt=(Float.parseFloat(discount.getText())*grand)/100;
            discount_amt.setText(decfor.format(amt));
            grand=grand-amt;
            grand_total.setText(decfor.format(grand));
        }
        grand_total.setText(decfor.format(grand));
        pid.setText("");
        brand_name.setSelectedIndex(0);
        quantity.setText("");
        unit_price.setText("");
        batch_no.setText("");
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        float grand=0;
        DefaultTableModel dt= (DefaultTableModel) jTable1.getModel();
        sn=0;
        if(jTable1.getSelectedRow() != -1) {
               dt.removeRow(jTable1.getSelectedRow());
               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
            }
        for(int i=0;i<jTable1.getRowCount();i++){
            grand=grand+Float.parseFloat(jTable1.getValueAt(i,5).toString());
            dt.setValueAt(++sn, i, 0);
        }
        if(!discount.getText().isEmpty()){
            float amt=(Float.parseFloat(discount.getText())*grand)/100;
            discount_amt.setText(decfor.format(amt));
            grand=grand-amt;
            grand_total.setText(decfor.format(grand));
        }
        grand_total.setText(decfor.format(grand));
        pid.setText("");
        brand_name.setSelectedIndex(0);
        quantity.setText("");
        unit_price.setText("");
        batch_no.setText("");
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea BillTxt;
    private javax.swing.JButton add_bill;
    private javax.swing.JTextField balance;
    private javax.swing.JTextField batch_no;
    private javax.swing.JComboBox<String> brand_name;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JTextField discount;
    private javax.swing.JTextField discount_amt;
    private javax.swing.JTextField each_total;
    private javax.swing.JButton get_bill;
    private javax.swing.JTextField grand_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField payment;
    private javax.swing.JTextField pid;
    private javax.swing.JButton print_bill;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField unit_price;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

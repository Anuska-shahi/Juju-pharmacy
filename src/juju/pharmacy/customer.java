/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juju.pharmacy;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author user
 */
public class customer extends javax.swing.JPanel {

    /** Creates new form customer */
    String gender="Male";
    String cm_gender="Male";
    public customer() {
        initComponents();
        tb_load();
        cdata_load();
        med_load();
        AutoCompleteDecorator.decorate(cm_name);
        AutoCompleteDecorator.decorate(cm_brand_name);
    }
    java.util.Date last_purchase;
    java.sql.Date recent;
    public void cdata_load(){
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM customer");
            Vector v=new Vector(); 
            while(rs.next()){ 
                v.add(rs.getString("name"));
                DefaultComboBoxModel com=new DefaultComboBoxModel(v);
                cm_name.setModel(com);
            }
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void tb_load(){
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM customer");
            while(rs.next()){
                Vector v=new Vector();  
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                
                dt.addRow(v);
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void tb_load(String sql){
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                Vector v=new Vector();  
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                
                dt.addRow(v);
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void genderSelect(){
        if(male.isSelected())
            gender="Male";
        else if(female.isSelected())
            gender="Female";
        else
            gender="Other";
    }
    public void med_load(){
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT DISTINCT brand_name FROM medicine");
            Vector v=new Vector(); 
            while(rs.next()){ 
                v.add(rs.getString("brand_name"));
                DefaultComboBoxModel com=new DefaultComboBoxModel(v);
                cm_brand_name.setModel(com);
            }
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void medtb_load(){
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable2.getModel();
            dt.setRowCount(0);
            
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM cusmedicine where customer_id="+cm_id.getText());
            while(rs.next()){
                Vector v=new Vector();  
                v.add(med_name(rs.getString(2)));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));    
                
                dt.addRow(v);
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void medtb_load(String sql){
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable2.getModel();
            dt.setRowCount(0);
            
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                Vector v=new Vector();  
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));  
                
                dt.addRow(v);
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public String med_id(String bname){
        String name="";
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine where brand_name='"+bname+"'");
            if(rs.next())
                name = rs.getString(1);
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        return name;
    }
    public String med_name(String id){
        String name="";
        try{
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine where product_id="+id+"");
            if(rs.next())
                name = rs.getString(2);
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        return name;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender_grp = new javax.swing.ButtonGroup();
        cm_gender_grp = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        c_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_add = new javax.swing.JButton();
        c_search = new javax.swing.JButton();
        c_update = new javax.swing.JButton();
        c_delete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        c_disease = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        other = new javax.swing.JRadioButton();
        c_contact = new javax.swing.JTextField();
        c_address = new javax.swing.JTextField();
        c_name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cm_id = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cm_male = new javax.swing.JRadioButton();
        cm_female = new javax.swing.JRadioButton();
        cm_other = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        cm_address = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cm_contact = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cm_disease = new javax.swing.JTextField();
        cm_name = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cmr_medicine = new javax.swing.JTextField();
        cmr_quantity = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cm_clear = new javax.swing.JButton();
        cmr_interval = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cmr_last_purchase = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        cm_add = new javax.swing.JButton();
        cm_update = new javax.swing.JButton();
        cm_delete = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cm_brand_name = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cm_quantity = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cm_interval = new javax.swing.JTextField();
        cm_last_purchase = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setAutoscrolls(true);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Customers Info :");

        c_id.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Search Id :");

        c_clear.setBackground(new java.awt.Color(255, 255, 255));
        c_clear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/clears.png"))); // NOI18N
        c_clear.setText("Clear");
        c_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel4)
                        .addGap(56, 56, 56)
                        .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(c_clear))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(c_clear))
                .addGap(31, 31, 31))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Name :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Address :");

        c_add.setBackground(new java.awt.Color(255, 255, 255));
        c_add.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/saves.png"))); // NOI18N
        c_add.setText("Save");
        c_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_addActionPerformed(evt);
            }
        });

        c_search.setBackground(new java.awt.Color(255, 255, 255));
        c_search.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/searchs.jpg"))); // NOI18N
        c_search.setText("Search");
        c_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_searchActionPerformed(evt);
            }
        });

        c_update.setBackground(new java.awt.Color(255, 255, 255));
        c_update.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/edits.png"))); // NOI18N
        c_update.setText("Update");
        c_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_updateActionPerformed(evt);
            }
        });

        c_delete.setBackground(new java.awt.Color(255, 255, 255));
        c_delete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/deletes.png"))); // NOI18N
        c_delete.setText("Delete");
        c_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_deleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Contact no. :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Disease :");

        c_disease.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c_disease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_diseaseActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Gender :");

        gender_grp.add(male);
        male.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        male.setSelected(true);
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        gender_grp.add(female);
        female.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        gender_grp.add(other);
        other.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        other.setText("Other");
        other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherActionPerformed(evt);
            }
        });

        c_contact.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_contactActionPerformed(evt);
            }
        });

        c_address.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_addressActionPerformed(evt);
            }
        });

        c_name.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        c_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_nameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c_address, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c_contact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(c_disease, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(male)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(female)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(other)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(c_add)
                .addGap(12, 12, 12)
                .addComponent(c_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(male)
                    .addComponent(female)
                    .addComponent(other))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_address, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_disease, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_add)
                    .addComponent(c_search)
                    .addComponent(c_update)
                    .addComponent(c_delete))
                .addGap(83, 83, 83))
        );

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Gender", "Address", "Contact", "Disease"
            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setRowHeight(26);
        jTable1.setRowMargin(2);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Customer", jPanel1);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setAutoscrolls(true);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Customers Info :");

        cm_id.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_idActionPerformed(evt);
            }
        });
        cm_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cm_idKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Search Id :");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setText("Name :");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setText("Gender :");

        cm_gender_grp.add(cm_male);
        cm_male.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cm_male.setSelected(true);
        cm_male.setText("Male");
        cm_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_maleActionPerformed(evt);
            }
        });

        cm_gender_grp.add(cm_female);
        cm_female.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cm_female.setText("Female");
        cm_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_femaleActionPerformed(evt);
            }
        });

        cm_gender_grp.add(cm_other);
        cm_other.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cm_other.setText("Other");
        cm_other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_otherActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setText("Address :");

        cm_address.setEditable(false);
        cm_address.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_addressActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setText("Contact no. :");

        cm_contact.setEditable(false);
        cm_contact.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_contactActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setText("Disease :");

        cm_disease.setEditable(false);
        cm_disease.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_disease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_diseaseActionPerformed(evt);
            }
        });

        cm_name.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        cm_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cm_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cm_nameItemStateChanged(evt);
            }
        });
        cm_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_nameActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setText("Medicine:");

        cmr_medicine.setEditable(false);
        cmr_medicine.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cmr_medicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmr_medicineActionPerformed(evt);
            }
        });

        cmr_quantity.setEditable(false);
        cmr_quantity.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cmr_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmr_quantityActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setText("Quantity:");

        cm_clear.setBackground(new java.awt.Color(255, 255, 255));
        cm_clear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/clears.png"))); // NOI18N
        cm_clear.setText("Clear");
        cm_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_clearActionPerformed(evt);
            }
        });

        cmr_interval.setEditable(false);
        cmr_interval.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cmr_interval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmr_intervalActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel27.setText("Interval:");

        cmr_last_purchase.setEditable(false);
        cmr_last_purchase.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cmr_last_purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmr_last_purchaseActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel28.setText("Last purchase:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cm_clear)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cm_disease, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cm_address, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cm_contact, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cmr_medicine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmr_quantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmr_interval, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmr_last_purchase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cm_male)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cm_female)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cm_other))
                    .addComponent(cm_id, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cm_clear))
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cm_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cm_male)
                    .addComponent(cm_female)
                    .addComponent(cm_other))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cm_address, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cm_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cm_disease, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cmr_medicine, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cmr_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cmr_interval, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cmr_last_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cm_add.setBackground(new java.awt.Color(255, 255, 255));
        cm_add.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/saves.png"))); // NOI18N
        cm_add.setText("Save");
        cm_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_addActionPerformed(evt);
            }
        });

        cm_update.setBackground(new java.awt.Color(255, 255, 255));
        cm_update.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/edits.png"))); // NOI18N
        cm_update.setText("Update");
        cm_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_updateActionPerformed(evt);
            }
        });

        cm_delete.setBackground(new java.awt.Color(255, 255, 255));
        cm_delete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/juju/pharmacy/img/deletes.png"))); // NOI18N
        cm_delete.setText("Delete");
        cm_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_deleteActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel20.setText("Medicine Info :");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setText("Medicine (Brand Name):");

        cm_brand_name.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        cm_brand_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cm_brand_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_brand_nameActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setText("Quantity:");

        cm_quantity.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_quantityActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel24.setText("Last Purchase Date:");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel26.setText("Interval (Days):");

        cm_interval.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cm_interval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_intervalActionPerformed(evt);
            }
        });

        cm_last_purchase.setBackground(new java.awt.Color(255, 255, 255));
        cm_last_purchase.setDateFormatString("yyyy-MM-dd");
        cm_last_purchase.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cm_last_purchase.setMinSelectableDate(new java.util.Date(-62135786593000L));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cm_add)
                .addGap(28, 28, 28)
                .addComponent(cm_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cm_delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24))
                .addGap(45, 45, 45)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cm_last_purchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cm_brand_name, 0, 194, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(31, 31, 31)
                        .addComponent(cm_interval, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(45, 45, 45)
                        .addComponent(cm_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel20)
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cm_brand_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cm_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26)
                            .addComponent(cm_interval, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cm_add)
                            .addComponent(cm_update)
                            .addComponent(cm_delete))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(cm_last_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTable2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Medicine", "Quantity", "Interval (Days)", "Last Purchase"
            }
        ));
        jTable2.setFillsViewportHeight(true);
        jTable2.setRowHeight(26);
        jTable2.setRowMargin(2);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Medicine", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void c_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_searchActionPerformed
        // TODO add your handling code here:
        String sql="SELECT * FROM customer";
        String id= c_id.getText();
        String name= c_name.getText();
        String address= c_address.getText();
        String contact= c_contact.getText();
        String disease= c_disease.getText();
        genderSelect();
        int flag=0;
        if(c_id.getText().isEmpty()){
            try{
              if(!c_name.getText().isEmpty()){
                  if (flag==0){
                      sql=sql+" where name LIKE'"+name+"%'";
                      flag=1;
                  }else{
                      sql=sql+" OR name LIKE'"+name+"%'";
                  }     
              }
              if(!c_address.getText().isEmpty()){
                  if (flag==0){
                      sql=sql+" where address LIKE'"+address+"%'";
                      flag=1;
                  }else{
                      sql=sql+" OR address LIKE'"+address+"%'";
                  }     
              }
              if(!c_contact.getText().isEmpty()){
                  if (flag==0){
                      sql=sql+" where contact_no LIKE'"+contact+"%'";
                      flag=1;
                  }else{
                      sql=sql+" OR contact_no LIKE'"+contact+"%'";
                  }     
              }
              if(!c_disease.getText().isEmpty()){
                  if (flag==0){
                      sql=sql+" where disease LIKE'"+disease+"%'";
                      flag=1;
                  }else{
                      sql=sql+" OR disease LIKE'"+disease+"%'";
                  }     
              }
              int dialogResult=JOptionPane.showConfirmDialog(null, "Do you want to filter by selected gender?","Filter",JOptionPane.YES_NO_OPTION);
              if(dialogResult==JOptionPane.YES_OPTION)
                  sql=sql+" AND gender='"+gender+"'";
               
            }catch(Exception e){
                 System.out.println(e);
            } 
        }else{
            try{
                Statement s=db.mycon().createStatement();
                ResultSet rs=s.executeQuery("SELECT * FROM customer WHERE id="+id);
                if(rs.next()){
                    c_name.setText(rs.getString(2));
                    if(rs.getString(3).equals("Male")){
                        male.setSelected(true);
                    }else if(rs.getString(3).equals("Female")){
                        female.setSelected(true);
                    }
                    else{
                        other.setSelected(true);
                    }     
                    c_address.setText(rs.getString(4));
                    c_contact.setText(rs.getString(5));
                    c_disease.setText(rs.getString(6));
                    sql=sql+" where id="+id;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Id not found");
                    c_name.setText("");
                    male.setSelected(true);
                    c_address.setText("");
                    c_contact.setText("");
                    c_disease.setText("");
                }
                 s.close();
                 db.mycon().close();
            }catch(Exception e){
                 System.out.println(e);
            }  
        }
        tb_load(sql);
        
    }//GEN-LAST:event_c_searchActionPerformed

    private void c_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_updateActionPerformed
        // TODO add your handling code here:
        String id= c_id.getText();
        String name= c_name.getText();
        String address= c_address.getText();
        String contact= c_contact.getText();
        String disease= c_disease.getText();
        genderSelect();
        if(c_id.getText().isEmpty()||c_disease.getText().isEmpty()||c_name.getText().isEmpty()||c_address.getText().isEmpty()||c_contact.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Missing Information");
        }else{
           try{
              Statement s=db.mycon().createStatement();
              int result=s.executeUpdate("UPDATE customer SET name='"+name+"',gender='"+gender+"',address='"+address+"',contact_no='"+contact+"',disease='"+disease+"' WHERE id="+id);
              if(result>0){
                     JOptionPane.showMessageDialog(null, "Customer updated successfully");
              }else{
                  if(result==0)   
                    JOptionPane.showMessageDialog(null, "Id not found");
                  else
                      JOptionPane.showMessageDialog(null, "Error occured");
                 }
               s.close();
               db.mycon().close();
          }catch(Exception e){
              if(contact.length()>10)
                JOptionPane.showMessageDialog(null,"Contact should not be more than 10 digits");
               System.out.println(e);
          }  
        }
        tb_load();
    }//GEN-LAST:event_c_updateActionPerformed

    private void c_diseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_diseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_diseaseActionPerformed

    private void c_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_contactActionPerformed

    private void c_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_addressActionPerformed

    private void c_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_nameActionPerformed

    private void cm_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_updateActionPerformed
        // TODO add your handling code here:
        String med= med_id(cm_brand_name.getSelectedItem().toString());
        String qty= cm_quantity.getText();
        String interval= cm_interval.getText();
        String cusid= cm_id.getText();
        try{
            last_purchase=cm_last_purchase.getDate();
            recent= new java.sql.Date(last_purchase.getTime());
        }catch(Exception e){
            System.out.println(e);
        }
        if(cm_id.getText().isEmpty()||cm_quantity.getText().isEmpty()||cm_interval.getText().isEmpty()||cm_address.getText().isEmpty()||recent==null){
            JOptionPane.showMessageDialog(null, "Missing Information");
        }else{
           try{
              Statement s=db.mycon().createStatement();
              int result=s.executeUpdate("UPDATE cusmedicine SET medicine_id="+med+",quantity="+qty+",interval_days="+interval+",last_purchase='"+recent+"' WHERE customer_id="+cusid);
              if(result>0){
                     JOptionPane.showMessageDialog(null, "Customer medicine updated successfully");
              }else{
                  if(result==0)   
                    JOptionPane.showMessageDialog(null, "Id not found");
                  else
                      JOptionPane.showMessageDialog(null, "Error occured");
                 }
               s.close();
               db.mycon().close();
          }catch(Exception e){
               System.out.println(e);
          }  
        }
        cmr_medicine.setText(med_name(med));
        cmr_quantity.setText(qty);    
        cmr_interval.setText(interval);
        cmr_last_purchase.setText(recent.toString());
        medtb_load();
    }//GEN-LAST:event_cm_updateActionPerformed

    private void cm_diseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_diseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_diseaseActionPerformed

    private void cm_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_contactActionPerformed

    private void cm_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_addressActionPerformed

    private void cm_brand_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_brand_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_brand_nameActionPerformed

    private void cm_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_nameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cm_nameActionPerformed

    private void cmr_medicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmr_medicineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmr_medicineActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
        gender="Male";
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
        gender="Female";
    }//GEN-LAST:event_femaleActionPerformed

    private void otherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherActionPerformed
        // TODO add your handling code here:
        gender="Other";
    }//GEN-LAST:event_otherActionPerformed

    private void c_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_addActionPerformed
        // TODO add your handling code here:
        String name= c_name.getText();
        String address= c_address.getText();
        String contact= c_contact.getText();
        String disease= c_disease.getText();
        if(c_disease.getText().isEmpty()||c_name.getText().isEmpty()||c_address.getText().isEmpty()||c_contact.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Missing Information");
        }else{
            try{
                Statement s=db.mycon().createStatement();
                int result=s.executeUpdate("INSERT INTO customer (name,gender,address,contact_no,disease) VALUES('"+name+"','"+gender+"','"+address+"','"+contact+"','"+disease+"')");
                if(result!=-1){
                       JOptionPane.showMessageDialog(null, "customer added successfully");
                       tb_load();
                }else{
                       JOptionPane.showMessageDialog(null, "Error occured");
                   }
                s.close();
               db.mycon().close();
            }catch(Exception e){
                if(contact.length()>10)
                    JOptionPane.showMessageDialog(null,"Contact should not be more than 10 digits");
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_c_addActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int r= jTable1.getSelectedRow();
        String id=jTable1.getValueAt(r, 0).toString();
        String name= jTable1.getValueAt(r, 1).toString();
        String gender= jTable1.getValueAt(r, 2).toString();
        String address= jTable1.getValueAt(r, 3).toString();
        String contact= jTable1.getValueAt(r, 4).toString();
        String disease= jTable1.getValueAt(r, 5).toString();
        c_id.setText(id);
        c_name.setText(name);
        if(gender.equals("Male")){
            male.setSelected(true);
        }else if(gender.equals("Female")){
            female.setSelected(true);
        }
        else{
            other.setSelected(true);
        }     
        c_address.setText(address);
        c_contact.setText(contact);
        c_disease.setText(disease);
    }//GEN-LAST:event_jTable1MouseClicked

    private void c_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_deleteActionPerformed
        // TODO add your handling code here:
        String id= c_id.getText();
        int dialogResult=JOptionPane.showConfirmDialog(null,"Do you want to delete record of id="+id,"Confirmation",JOptionPane.YES_NO_OPTION );
        if(!c_id.getText().isEmpty()&& dialogResult==JOptionPane.YES_OPTION){
            try{
              Statement s=db.mycon().createStatement();
              int result=s.executeUpdate("DELETE FROM customer where id="+id);
              if(result>0){
                     JOptionPane.showMessageDialog(null, "Customer Deleted successfully");
              }else{
                  if(result==0)   
                    JOptionPane.showMessageDialog(null, "Id not found");
                  
                  else
                      JOptionPane.showMessageDialog(null, "Error occured");
                 }
               s.close();
               db.mycon().close();
            }catch(Exception e){
                 System.out.println(e);
            }  
        }
        tb_load();
    }//GEN-LAST:event_c_deleteActionPerformed

    private void c_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_clearActionPerformed
        // TODO add your handling code here:
        c_id.setText("");
        c_name.setText("");
        male.setSelected(true);
        c_address.setText("");
        c_contact.setText("");
        c_disease.setText("");
        tb_load();
    }//GEN-LAST:event_c_clearActionPerformed

    private void cm_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_quantityActionPerformed

    private void cmr_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmr_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmr_quantityActionPerformed

    private void cm_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_clearActionPerformed
        // TODO add your handling code here:
        cm_id.setText("");
        cm_name.setSelectedIndex(0);
        cm_male.setSelected(true);
        cm_address.setText("");
        cm_contact.setText("");
        cm_disease.setText("");
        cmr_medicine.setText("");
        cmr_quantity.setText("");    
        cmr_interval.setText("");
        cmr_last_purchase.setText("");
        cm_brand_name.setSelectedIndex(0);
        cm_quantity.setText("");    
        cm_interval.setText("");
        ((JTextField)cm_last_purchase.getDateEditor().getUiComponent()).setText("");
        medtb_load("select * from cusmedicine where customer_id=-1");
    }//GEN-LAST:event_cm_clearActionPerformed

    private void cm_intervalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_intervalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_intervalActionPerformed

    private void cmr_intervalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmr_intervalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmr_intervalActionPerformed

    private void cmr_last_purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmr_last_purchaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmr_last_purchaseActionPerformed

    private void cm_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_idActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cm_idActionPerformed

    private void cm_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_maleActionPerformed
        // TODO add your handling code here:
        cm_gender="Male";
    }//GEN-LAST:event_cm_maleActionPerformed

    private void cm_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_femaleActionPerformed
        // TODO add your handling code here:
        cm_gender="Female";
    }//GEN-LAST:event_cm_femaleActionPerformed

    private void cm_otherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_otherActionPerformed
        // TODO add your handling code here:
        cm_gender="Other";
    }//GEN-LAST:event_cm_otherActionPerformed

    private void cm_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cm_nameItemStateChanged
        // TODO add your handling code here:
        try{
              Statement s=db.mycon().createStatement();
                ResultSet rs=s.executeQuery("SELECT * FROM customer WHERE name='"+cm_name.getSelectedItem()+"'");
                if(rs.next()){
                    cm_address.setText(rs.getString("address"));
                    if(rs.getString("gender").equals("Male")){
                        cm_male.setSelected(true);
                    }else if(rs.getString("gender").equals("Female")){
                        cm_female.setSelected(true);
                    }
                    else{
                        cm_other.setSelected(true);
                    } 
                    cm_contact.setText(rs.getString("contact_no"));
                    cm_disease.setText(rs.getString("disease"));
                    cm_id.setText(rs.getString("id"));
                    medtb_load();
                }else{
                    cm_id.setText("");
                    cm_name.setSelectedIndex(0);
                    cm_male.setSelected(true);
                    cm_address.setText("");
                    cm_contact.setText("");
                    cm_disease.setText("");
                }
               s.close();
               db.mycon().close();
          }catch(Exception e){
               System.out.println(e);
          }  
        
    }//GEN-LAST:event_cm_nameItemStateChanged

    private void cm_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cm_idKeyReleased
        // TODO add your handling code here:
        try{
              Statement s=db.mycon().createStatement();
                ResultSet rs=s.executeQuery("SELECT * FROM customer WHERE id="+cm_id.getText());
                if(rs.next()){
                    cm_address.setText(rs.getString("address"));
                    if(rs.getString("gender").equals("Male")){
                        cm_male.setSelected(true);
                    }else if(rs.getString("gender").equals("Female")){
                        cm_female.setSelected(true);
                    }
                    else{
                        cm_other.setSelected(true);
                    } 
                    cm_contact.setText(rs.getString("contact_no"));
                    cm_disease.setText(rs.getString("disease"));
                    cm_name.setSelectedItem(rs.getString("name"));
                }else{
                    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                        JOptionPane.showMessageDialog(null, "Id not found");
                        cm_id.setText("");
                    }
                    cm_name.setSelectedIndex(0);
                    cm_male.setSelected(true);
                    cm_address.setText("");
                    cm_contact.setText("");
                    cm_disease.setText("");
                }
               s.close();
               db.mycon().close();
          }catch(Exception e){
               System.out.println(e);
          }  
        medtb_load();
    }//GEN-LAST:event_cm_idKeyReleased

    private void cm_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_addActionPerformed
        // TODO add your handling code here:
        String med= med_id(cm_brand_name.getSelectedItem().toString());
        String qty= cm_quantity.getText();
        String interval= cm_interval.getText();
        String cusid= cm_id.getText();
        try{
            last_purchase=cm_last_purchase.getDate();
            recent= new java.sql.Date(last_purchase.getTime());
        }catch(Exception e){
            System.out.println(e);
        }
        if(cm_quantity.getText().isEmpty()||cm_interval.getText().isEmpty()||cm_id.getText().isEmpty()||cm_contact.getText().isEmpty()||recent==null){
            JOptionPane.showMessageDialog(null, "Missing Information");
        }else{
            try{
                Statement s=db.mycon().createStatement();
                int result=s.executeUpdate("INSERT INTO cusmedicine  VALUES("+cusid+","+med+","+qty+","+interval+",'"+recent+"')");
                if(result!=-1){
                       JOptionPane.showMessageDialog(null, "customer medicine added successfully");
                       medtb_load();
                }else{
                       JOptionPane.showMessageDialog(null, "Error occured");
                   }
                s.close();
               db.mycon().close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_cm_addActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int r= jTable2.getSelectedRow();
        String name= jTable2.getValueAt(r, 0).toString();
        String qty= jTable2.getValueAt(r, 1).toString();
        String interval= jTable2.getValueAt(r, 2).toString();
        String purchase_date= jTable2.getValueAt(r, 3).toString();
        cmr_medicine.setText(name);
        cmr_quantity.setText(qty);    
        cmr_interval.setText(interval);
        cmr_last_purchase.setText(purchase_date);
        cm_brand_name.setSelectedItem(name);
        cm_quantity.setText(qty);    
        cm_interval.setText(interval);
        ((JTextField)cm_last_purchase.getDateEditor().getUiComponent()).setText(purchase_date);
    }//GEN-LAST:event_jTable2MouseClicked

    private void cm_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_deleteActionPerformed
        // TODO add your handling code here:
        String id= cm_id.getText();
        String med_id= med_id(cm_brand_name.getSelectedItem().toString());
        int dialogResult=JOptionPane.showConfirmDialog(null,"Do you want to delete record of medicine="+cm_brand_name.getSelectedItem()+" of customer="+cm_name.getSelectedItem(),"Confirmation",JOptionPane.YES_NO_OPTION );
        if(!cm_id.getText().isEmpty()&&!cmr_medicine.getText().isEmpty()&& dialogResult==JOptionPane.YES_OPTION){
            try{
              Statement s=db.mycon().createStatement();
              int result=s.executeUpdate("DELETE FROM cusmedicine where customer_id="+id+" AND medicine_id="+med_id);
              if(result>0){
                     JOptionPane.showMessageDialog(null, "Customer Deleted successfully");
              }else{
                  if(result==0)   
                    JOptionPane.showMessageDialog(null, "Id not found");
                  
                  else
                      JOptionPane.showMessageDialog(null, "Error occured");
                 }
               s.close();
               db.mycon().close();
            }catch(Exception e){
                 System.out.println(e);
            }  
        }
        medtb_load();
        
    }//GEN-LAST:event_cm_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton c_add;
    private javax.swing.JTextField c_address;
    private javax.swing.JButton c_clear;
    private javax.swing.JTextField c_contact;
    private javax.swing.JButton c_delete;
    private javax.swing.JTextField c_disease;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField c_name;
    private javax.swing.JButton c_search;
    private javax.swing.JButton c_update;
    private javax.swing.JButton cm_add;
    private javax.swing.JTextField cm_address;
    private javax.swing.JComboBox<String> cm_brand_name;
    private javax.swing.JButton cm_clear;
    private javax.swing.JTextField cm_contact;
    private javax.swing.JButton cm_delete;
    private javax.swing.JTextField cm_disease;
    private javax.swing.JRadioButton cm_female;
    private javax.swing.ButtonGroup cm_gender_grp;
    private javax.swing.JTextField cm_id;
    private javax.swing.JTextField cm_interval;
    private com.toedter.calendar.JDateChooser cm_last_purchase;
    private javax.swing.JRadioButton cm_male;
    private javax.swing.JComboBox<String> cm_name;
    private javax.swing.JRadioButton cm_other;
    private javax.swing.JTextField cm_quantity;
    private javax.swing.JButton cm_update;
    private javax.swing.JTextField cmr_interval;
    private javax.swing.JTextField cmr_last_purchase;
    private javax.swing.JTextField cmr_medicine;
    private javax.swing.JTextField cmr_quantity;
    private javax.swing.JRadioButton female;
    private javax.swing.ButtonGroup gender_grp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton other;
    // End of variables declaration//GEN-END:variables

}

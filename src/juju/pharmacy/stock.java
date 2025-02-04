/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juju.pharmacy;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class stock extends javax.swing.JPanel {

    /** Creates new form customer */
    public stock() {
        initComponents();
        mtb_load();
        exptb_load();
        lesstb_load();
        to_be_tb_load();
    }
    java.util.Date today;
    java.sql.Date date;
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
    public void mtb_load(){
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable6.getModel();
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
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                dt.addRow(v);
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void exptb_load(){
        try{
            Date today=new Date();
            date= new java.sql.Date(today.getTime());
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable3.getModel();
            dt.setRowCount(0);
            
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine where expiry_date<=CURDATE() ORDER BY expiry_date DESC");
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
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                dt.addRow(v);
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void lesstb_load(){
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable4.getModel();
            dt.setRowCount(0);
            
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine");
            while(rs.next()){
                
                Vector v=new Vector();  
                if(quantity_count(rs.getString(1))==0){
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(sup_id(rs.getString(5)));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                dt.addRow(v);
                }
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void to_be_tb_load(){
        try{
            today=new java.util.Date();
            date= new java.sql.Date(today.getTime());
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            DefaultTableModel dt= (DefaultTableModel) jTable5.getModel();
            dt.setRowCount(0);
            
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM medicine WHERE expiry_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(),INTERVAL 30 DAY)");
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
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                dt.addRow(v);
            }
            s.close();
            db.mycon().close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public int quantity_count(String id){
        try{
            int qty=0;
            Statement s=db.mycon().createStatement();
            ResultSet rs=s.executeQuery("SELECT product_id, brand_name, generic_name, company, supplier_id, sum(quantity) AS qnty, cost_price, market_price, batch_no, entry_date, expiry_date FROM medicine GROUP BY product_id having expiry_date>=CURDATE() and product_id="+id);
            if(rs.next()){
                System.out.println(qty);
                Statement s1=db.mycon().createStatement();
                ResultSet rs1=s1.executeQuery("SELECT medicine_id,quantity FROM cusmedicine where medicine_id="+rs.getString("product_id")+" and (DATE_ADD(last_purchase,INTERVAL interval_days DAY)<DATE_ADD(CURDATE(),INTERVAL 10 DAY))");
                while(rs1.next()){
                    qty=qty-rs1.getInt("quantity");
                }
                if(qty<10)
                    return 0;
            }
            s.close();
            db.mycon().close();
        }catch(Exception e){
            System.out.println(e);
        }
        return 1;
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jTable6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
                "Product Id", "Brand Name", "Generic Name", "Company Name", "Supplier", "Quantity", "Cost Price", "Market Price", "Batch no", "Entry Date", "Expiry Date"
            }
        ));
        jTable6.setFillsViewportHeight(true);
        jTable6.setRowHeight(25);
        jScrollPane6.setViewportView(jTable6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1458, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("All Medicine", jPanel1);

        jTable3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
                "Product Id", "Brand Name", "Generic Name", "Company Name", "Supplier", "Quantity", "Cost Price", "Market Price", "Batch no", "Entry Date", "Expiry Date"
            }
        ));
        jTable3.setFillsViewportHeight(true);
        jTable3.setRowHeight(25);
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1458, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Expired", jPanel4);

        jTable4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
                "Product Id", "Brand Name", "Generic Name", "Company Name", "Supplier", "Quantity", "Cost Price", "Market Price", "Batch no", "Entry Date", "Expiry Date"
            }
        ));
        jTable4.setFillsViewportHeight(true);
        jTable4.setRowHeight(25);
        jScrollPane4.setViewportView(jTable4);

        jTabbedPane1.addTab("Less in stock", jScrollPane4);

        jTable5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
                "Product Id", "Brand Name", "Generic Name", "Company Name", "Supplier", "Quantity", "Cost Price", "Market Price", "Batch no", "Entry Date", "Expiry Date"
            }
        ));
        jTable5.setFillsViewportHeight(true);
        jTable5.setRowHeight(25);
        jScrollPane5.setViewportView(jTable5);

        jTabbedPane1.addTab("To be expired", jScrollPane5);

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gender_grp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    // End of variables declaration//GEN-END:variables

}

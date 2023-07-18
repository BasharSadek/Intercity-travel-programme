/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sql;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
/**
 *
 * @author Mohammed
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Sql {
   static String URL="jdbc:mysql://localhost/travelbetweencities";
  static   public Connection co;
   static public void setUrl(){
    
    }
   static  public void setconnection(){
        try {
            co= DriverManager.getConnection(URL,"root","");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
             System.exit(0);
        }
    }
   static  public boolean chekUserAndPassowerd(String strquery) throws IOException{
       try {
         // Runtime.getRuntime().exec("sudo /usr/local/mysql/support-files/mysql.server start");6
           setconnection();
           Statement stmt=co.createStatement();
//           System.out.println(co);
//           String strquery="select * from users where user='"+user.toLowerCase()+"'and password='"+password.toLowerCase()+"'";
//           System.out.println(stmt);
           stmt.executeQuery(strquery);
           while(stmt.getResultSet().next()){
               return true;}
           co.close();
       } catch (SQLException ex) {
           Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
   }
   static  public void selectAll(){
       
   }  Statement stmt;
   static public void setModleCombo(String ColumName , String TableName, JComboBox combo){
            try{  setconnection();
           Statement stmt=co.createStatement();
           String strquery="select "+ColumName+" from "+TableName;
           ResultSet rs=stmt.executeQuery(strquery);
           rs.last();
           int c=rs.getRow();
           String row[]=new String[c+1];
           rs.beforeFirst();
           int i=0;
           row[0]=null;
           while(rs.next()){
           row[i+1]=rs.getString(1);
           i++;
           }
           co.close();
           combo.setModel(new DefaultComboBoxModel(row));
            }
            catch(SQLException e){
                System.out.println( e.getMessage()); 
            }
   }
   static public Object[] selectRow(String strQurey){
       Object row[]=null;
       try {
           setconnection();
           Statement stmt=co.createStatement();
           ResultSet rs=stmt.executeQuery(strQurey);
//           System.out.println(rs.getString(3));
           ResultSetMetaData rsmd=rs.getMetaData();
           if (rs.next()==false) return row;
           int c=rsmd.getColumnCount();
           row=new Object[c];
           int i=0;
           while(i<c){
               row[i]=rs.getString(i+1);
               i++;}
           co.close();
       } catch (SQLException ex) {
           Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
       }
           return row;
   }
   static public void setModleTable(String strQurey,String name[], JTable jt){
    DefaultTableModel dtm = null;
       try {

           setconnection();
           Statement stmt=co.createStatement();
           ResultSet rs=stmt.executeQuery(strQurey);
           ResultSetMetaData rsmd=rs.getMetaData();
            if (rs.next()==true){    
           int c=rsmd.getColumnCount();
           int i=0;
           rs.last();
           int r=rs.getRow();
           rs.beforeFirst();
            Object tb[][]=new String[r][c];
           while(rs.next()){
               for (int j = c-1; j >= 0; j--) 
                   tb[i][j]=(Object)rs.getString(c-j);
               i++;

           }
           jt.setModel(new DefaultTableModel(tb, name));
            }
       } catch (SQLException ex) {
           Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   static public void  insertRow(String strQurey){
     int i=0;
       try {
           if(strQurey.charAt(0)=='d'){
         i=  JOptionPane.showConfirmDialog(null, "هل تريد بالـاكيد الحذف ؟","استعلام",JOptionPane.YES_NO_OPTION);}
           if(i==0){
           setconnection();
           Statement stmt=co.createStatement();
           stmt.executeUpdate(strQurey);
           }
           if (strQurey.charAt(0)=='i') JOptionPane.showMessageDialog(null, "تم إدخال البيانات بنجاح", "العملية تمت", JOptionPane.INFORMATION_MESSAGE);
           else if(strQurey.charAt(0)=='u') JOptionPane.showMessageDialog(null, "تم تعديل البيانات بنجاح", "العملية تمت", JOptionPane.INFORMATION_MESSAGE);
        
       } catch (SQLException ex) {
           Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
}

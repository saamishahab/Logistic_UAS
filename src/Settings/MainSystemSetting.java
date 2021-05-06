/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import Master.Master;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ami
 */
public class MainSystemSetting {
    /**
     * @param args the command line arguments
     */
    
    
    public static PreparedStatement ps;
    public static Connection con;
    public static Statement stm;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        connection();
        if(con != null)
        {
            JOptionPane.showMessageDialog(null, "Connection Success", "System", JOptionPane.DEFAULT_OPTION);
            Master plg = new Master();
//            plg.getConnection();
            plg.getDataCustomer();
            plg.setVisible(true);
        }else
        {
            JOptionPane.showMessageDialog(null, "Connection Failed", "System", JOptionPane.DEFAULT_OPTION);
        }
        
    }
    
    public static Connection connection(){
        try{
            String url ="jdbc:mariadb://localhost:3306/db_logistic";
            String user="root";
            String pass="";
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            System.err.println("koneksi gagal " +e.getMessage());
        }
        return con;
    }
    
}

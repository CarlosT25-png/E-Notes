/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author carto
 */
public class Conexion {
    public static Connection getConnection(){
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=ENOTES;"
                + "user=sa;"
                + "password=123;"
                + "loginTimeout=30;";
        
        try {
            Connection con  = DriverManager.getConnection(conexionUrl);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public static ResultSet Consulta(String consulta){
        try {
            String query = consulta;
            Connection con = getConexion();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            return rs;
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }


   
}

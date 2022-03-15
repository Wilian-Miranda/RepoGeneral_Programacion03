/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilian.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Willian
 */
public class ConexionMYSQL {
    
    public static Connection variableConexion = null;
    
    public Connection ObtenerConexion(){
        try {
            String url = "jdbc:mysql://localhost:3306/Estudiantes";
            String user = "root";
            String pass = "root";
            
            variableConexion = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexión exitosa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: \n"+e.toString());
        }
        return variableConexion;
    }
    
}

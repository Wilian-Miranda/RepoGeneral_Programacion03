/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilian.DAO;

import com.wilian.DataBase.ConexionMYSQL;
import com.wilian.Entidades.Login;
import com.wilian.services.ILogin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class CDLogin implements ILogin{
    
    //clase para la conexion
    ConexionMYSQL clsConexion = new ConexionMYSQL();

    @Override
    public Boolean Acceso(Login log) {
        
        //variable para almacenar la conexion
        Connection conexion = clsConexion.ObtenerConexion();
        
        Boolean validacion = false; 
                
        try{
            
            CallableStatement variableConsulta =conexion.prepareCall("call SP_S_USUARIOS(?, ?);");
            variableConsulta.setString("Pusuario", log.getUsers());
            variableConsulta.setString("Ppassword", log.getPasswords());
            
            ResultSet resultado =  variableConsulta.executeQuery();
            
            int a = 0;
            while (resultado.next())
            {                  
                a +=1;
            }
            
            switch (a) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                    validacion = true;
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Error al iniciar sesion.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Datos ambiguos. Usuarios repetidos");
                    break;           
            }

            
            variableConsulta.close();
            resultado.close();
                      
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos./n Info: /n"+ex);
        }       
       return validacion;
    }

    @Override
    public void InsertarUsuario(Login log) {
        //abriendo conexion con el server
        Connection conexion = clsConexion.ObtenerConexion();
        
        try {
            //preparando la consulta
            CallableStatement variableConsulta = conexion.prepareCall("call SP_I_USUARIOS(?,?);");
            //Agregando los parametros
            variableConsulta.setString("Pusuario", log.getUsers());
            variableConsulta.setString("Ppassword", log.getPasswords());
            
            //ejecutando la consulta
            variableConsulta.execute();
            
            JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente.");
            
            variableConsulta.close();
            conexion.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar usuario"+ e.toString());
        } 
        
    }

    @Override
    public Boolean VerificarUsuario(Login log) {
                
        //variable para almacenar la conexion
        Connection conexion = clsConexion.ObtenerConexion();
        
        Boolean validacion = false; 
                
        try{
            
            CallableStatement variableConsulta =conexion.prepareCall("call SP_S_USUARIOS(?, ?);");
            variableConsulta.setString("Pusuario", log.getUsers());
            variableConsulta.setString("Ppassword", log.getPasswords());
            
            ResultSet resultado =  variableConsulta.executeQuery();
            
            int a = 0;
            while (resultado.next())
            {                  
                a +=1;
            }
            
            switch (a) {
                case 1:
                    validacion = true;
                    break;
                default:
                    validacion = false;
                    break;           
            }

            
            variableConsulta.close();
            resultado.close();
                      
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos./n Info: /n"+ex);
        }       
       return validacion;
    }
    
 
    
}

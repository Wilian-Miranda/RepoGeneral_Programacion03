/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilian.DAO;

import com.wilian.DataBase.ConexionMYSQL;
import com.wilian.Entidades.DbNotas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class CDNotas {
        ConexionMYSQL variableConexion = new ConexionMYSQL();
    
    //mostrar datos
    
    public ArrayList<DbNotas> MostrarNotas(){
        ArrayList<DbNotas> listado = null;
        Connection conexion = variableConexion.ObtenerConexion();
        
        try {
            listado = new ArrayList<DbNotas>();
            
                CallableStatement variableConsulta = conexion.prepareCall("{call sp_S_MostrarNotas()}");
               //CallableStatement variableConsulta = conexion.prepareCall("Select * from Tbl_Estudiantes");
            
            ResultSet resultadoConsulta = variableConsulta.executeQuery();
            
            while(resultadoConsulta.next()){
                DbNotas notas = new DbNotas();
                notas.setId(resultadoConsulta.getInt("idnotas"));
                notas.setNombres(resultadoConsulta.getString("nombres"));
                notas.setApellidos(resultadoConsulta.getString("apellidos"));
                notas.setNombreMateria(resultadoConsulta.getString("nombreMateria"));
                notas.setNota(resultadoConsulta.getString("nota"));
                listado.add(notas);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al mostrar notas:\n"+e.toString());
        }
        return listado;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilian.DAO;

import ViewModels.ViewModelNotas;
import com.wilian.DataBase.ConexionMYSQL;
import com.wilian.Entidades.DbNotas;
//import com.wilian.Entidades.DbNotas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class CDNotas {
        ConexionMYSQL variableConexion = new ConexionMYSQL();
    
        public ArrayList<ViewModelNotas> MostrarNotas(){
        ArrayList<ViewModelNotas> listado = null;
        Connection conexion = variableConexion.ObtenerConexion();
        
        try {
            listado = new ArrayList<>();
            
                CallableStatement variableConsulta = conexion.prepareCall("{call SP_S_NOTAS()}");
               //CallableStatement variableConsulta = conexion.prepareCall("Select * from Tbl_Estudiantes");
            
            ResultSet resultadoConsulta = variableConsulta.executeQuery();
            
            while(resultadoConsulta.next()){
                ViewModelNotas notas = new ViewModelNotas();
                notas.setIdnotas(resultadoConsulta.getInt("idnotas"));
                notas.setNombres(resultadoConsulta.getString("nombres"));
                notas.setApellidos(resultadoConsulta.getString("apellidos"));
                notas.setNombreMateria(resultadoConsulta.getString("nombreMateria"));
                notas.setNota(resultadoConsulta.getString("nota"));
                listado.add(notas);
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al mostrar notas:\n" + e.toString());
        }
        return listado;
    }
        
           public void AgregarNota(DbNotas es){
        
        Connection conexion = variableConexion.ObtenerConexion();
        CallableStatement variableConsulta;
        try {
            variableConsulta = conexion.prepareCall("{call SP_I_NOTAS(?, ?,?)}");
            variableConsulta.setDouble(1, es.getNota());
            variableConsulta.setInt(2, es.getIdmateria());
            variableConsulta.setInt(3, es.getIdEstudiante());

            variableConsulta.execute();
            
            JOptionPane.showMessageDialog(null, "Inscripcion agregada exitosamente");
            

            variableConsulta.close();
            conexion.close();

        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar inscripcion:\n"+e.toString());
        }
        

    }
        
}

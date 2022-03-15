/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilian.DAO;

import com.wilian.DataBase.ConexionMYSQL;
import com.wilian.Entidades.DbNotas;
import com.wilian.Entidades.Estudiantes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class CDEstudiantes {
    
    //Conexion
    ConexionMYSQL variableConexion = new ConexionMYSQL();
    
    //mostrar datos
    
    public ArrayList<Estudiantes> MostrarEstudiantes(){
        
        ArrayList<Estudiantes> listado = null;
        Connection conexion = variableConexion.ObtenerConexion();
        
        try {
            listado = new ArrayList<Estudiantes>();
            
                CallableStatement variableConsulta = conexion.prepareCall("{call sp_s_estudiantes()}");
               //CallableStatement variableConsulta = conexion.prepareCall("Select * from Tbl_Estudiantes");
            
            ResultSet resultadoConsulta = variableConsulta.executeQuery();
            
            while(resultadoConsulta.next()){
                Estudiantes estudiantes = new Estudiantes();
                estudiantes.setId(resultadoConsulta.getInt("id"));
                estudiantes.setNombres(resultadoConsulta.getString("nombres"));
                estudiantes.setApellidos(resultadoConsulta.getString("apellidos"));
                listado.add(estudiantes);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al mostrar estudiantes:\n"+e.toString());
        }
        return listado;
    }
    
    public ArrayList<Estudiantes> AgregarEstudiante(Estudiantes es){
        
        ArrayList<Estudiantes> listado = null;
        Connection conexion = variableConexion.ObtenerConexion();
        
        try {
            CallableStatement variableConsulta = conexion.prepareCall("{call sp_I_Estudiantes(?, ?)}");
            variableConsulta.setString("pNombre", es.getNombres());
            variableConsulta.setString("pApellido", es.getApellidos());
            /*
            CallableStatement variableConsulta = conexion.prepareCall("insert into Tbl_Estudiantes(nombres, apellidos) values ("
            +"'"+es.getNombres()+"'" +","
            +"'"+es.getApellidos()+"'"
                    +");");*/

            variableConsulta.execute();
            
            JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente");

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar estudiantes:\n"+e.toString());
        }
        return listado;
        

    }
}

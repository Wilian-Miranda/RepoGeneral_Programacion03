/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilian.DAO;

import com.wilian.DataBase.ConexionMYSQL;
import com.wilian.Entidades.DbNotas;
import com.wilian.Entidades.Estudiantes;
import com.wilian.services.IEstudiantes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class CDEstudiantes implements IEstudiantes{
    
    //Conexion
    ConexionMYSQL variableConexion = new ConexionMYSQL();
    
    //mostrar datos
    @Override   
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
            
            conexion.close();
            variableConsulta.close();
            resultadoConsulta.close();
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al mostrar estudiantes:\n"+e.toString());
        }
        return listado;
    }
   
    @Override
    public ArrayList<Estudiantes> AgregarEstudiante(Estudiantes es){
        
        ArrayList<Estudiantes> listado = null;
        Connection conexion = variableConexion.ObtenerConexion();
        
        try {
            CallableStatement variableConsulta = conexion.prepareCall("{call sp_I_Estudiantes(?, ?,?)}");
            variableConsulta.setString(1, es.getNombres());
            variableConsulta.setString(2, es.getApellidos());
            variableConsulta.setDate(3, new java.sql.Date(es.getFecha().getTime()));
            /*
            CallableStatement variableConsulta = conexion.prepareCall("insert into Tbl_Estudiantes(nombres, apellidos) values ("
            +"'"+es.getNombres()+"'" +","
            +"'"+es.getApellidos()+"'"
                    +");");*/

            variableConsulta.execute();
            
            JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente");
            
            conexion.close();
            variableConsulta.close();

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar estudiantes:\n"+e.toString());
        }
        return listado;
        

    }

    @Override
    public void ActualizarEstudiante(Estudiantes es) {
        //conexion a la db
        Connection conexion = variableConexion.ObtenerConexion();
        
        try {
            //preparando la consulta
            CallableStatement variableConsulta = conexion.prepareCall("call SP_U_ESTUDIANTES(?, ?, ?);");
            variableConsulta.setInt("Pid", es.getId());
            variableConsulta.setString("Pnombres", es.getNombres());
            variableConsulta.setString("Papellidos", es.getApellidos());
            
            //ejecutando  la consulta
            variableConsulta.execute();
            
            JOptionPane.showMessageDialog(null, "Estudiante actualizado exitosamente."); 
            
            conexion.close();
            variableConsulta.close();
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Error al actualizar estudiante. \n\nInfo: \n"+ e.toString());          
        }
    }

    @Override
    public void EliminarEstudiante(int id) {
        //conexion a la db
        Connection conexion = variableConexion.ObtenerConexion();

        try {
            //preparando la consulta
            CallableStatement variableConsulta = conexion.prepareCall("call SP_D_ESTUDIANTES(?);");
            variableConsulta.setInt("Pid", id);

            //ejecutando  la consulta
            variableConsulta.execute();

            JOptionPane.showMessageDialog(null, "Estudiante eliminado exitosamente.");

            conexion.close();
            variableConsulta.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar estudiante. \n\nInfo: \n" + e.toString());
        }
    }
}

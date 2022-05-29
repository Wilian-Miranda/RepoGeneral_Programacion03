/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilian.DAO;

import com.wilian.DataBase.ConexionMYSQL;
import com.wilian.Entidades.DbMaterias;
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
public class CDMaterias {
         ConexionMYSQL variableConexion = new ConexionMYSQL();
            public ArrayList<DbMaterias> MostrarMaterias(){
        ArrayList<DbMaterias> listado = null;
        Connection conexion = variableConexion.ObtenerConexion();
        
        try {
            listado = new ArrayList<>();
            
                CallableStatement variableConsulta = conexion.prepareCall("SELECT * FROM materias;");
               //CallableStatement variableConsulta = conexion.prepareCall("Select * from Tbl_Estudiantes");
            
            ResultSet resultadoConsulta = variableConsulta.executeQuery();
            
            while(resultadoConsulta.next()){
                DbMaterias materia = new DbMaterias();
                materia.setIdMateria(resultadoConsulta.getInt("idmateria"));
                materia.setNombreMateria(resultadoConsulta.getString("nombreMateria"));
                listado.add(materia);
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al mostrar materias:\n" + e.toString());
        }
        return listado;
    }
       
    
}

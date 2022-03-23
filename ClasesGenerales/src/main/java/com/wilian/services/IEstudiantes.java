/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wilian.services;

import com.wilian.Entidades.Estudiantes;
import java.util.ArrayList;

/**
 *
 * @author Willian
 */
public interface IEstudiantes {
    ArrayList<Estudiantes> MostrarEstudiantes();
    ArrayList<Estudiantes> AgregarEstudiante(Estudiantes es);
    void ActualizarEstudiante(Estudiantes es);
    void EliminarEstudiante(int id);
}

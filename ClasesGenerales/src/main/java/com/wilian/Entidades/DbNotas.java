/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilian.Entidades;

/**
 *
 * @author Willian
 */
public class DbNotas {

 
    private int idEstudiante;
    private int idmateria;
   private double nota;
   
   public DbNotas(){
       
   }
      public DbNotas(int idEstudiante, int idmateria, int nota) {
        this.idEstudiante = idEstudiante;
        this.idmateria = idmateria;
        this.nota = nota;
    }
       public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }



    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
   

}

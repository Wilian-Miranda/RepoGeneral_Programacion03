/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilian.services;

import com.wilian.Entidades.Login;

/**
 *
 * @author Willian
 */
public interface ILogin {
    Boolean  Acceso(Login log);
    void InsertarUsuario(Login log);
    Boolean VerificarUsuario(Login log);
    
}

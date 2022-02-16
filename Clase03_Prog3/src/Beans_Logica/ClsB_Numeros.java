/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans_Logica;

import Pojos_Modelo.Numeros;
import Services.TipoNumeros;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ClsB_Numeros implements TipoNumeros{

    @Override
    public int VerificarTipoNumeroUno(Numeros num) {  
        
        if (Double.parseDouble(num.getCantidadUno()) > 0) {
            return 1;
        }else if (Double.parseDouble(num.getCantidadUno()) == 0){
            return 2;
        }else{
            return 0;
        }
        
    }

    @Override
    public int VerificarTipoNumeroDos(Numeros num) {
                if (Double.parseDouble(num.getCantidadDos()) > 0) {
            return 1;
        }else if (Double.parseDouble(num.getCantidadDos()) == 0){
            return 2;
        }else{
            return 0;
        }
    }

}

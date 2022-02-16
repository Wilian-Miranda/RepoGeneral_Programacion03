/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase03_prog3;
import Beans_Logica.ClsB_Numeros;
import Pojos_Modelo.Numeros;
import java.util.Scanner;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Clase03_Prog3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Numeros num = new Numeros();
        ClsB_Numeros clsB_num = new ClsB_Numeros();
                
        
        System.out.println("NOTA: 1-Positivo 0-Negativo 2-Cero");
        Scanner sr = new Scanner(System.in);
        System.out.print("Ingrese la cantidad uno: ");
        num.setCantidadUno(sr.nextLine());
        System.out.print("Ingrese la cantidad dos: ");
        num.setCantidadDos(sr.nextLine());
        //sr.close();
        

        int a = clsB_num.VerificarTipoNumeroUno(num);
        int b = clsB_num.VerificarTipoNumeroDos(num);
        
        switch (a) {
            case 1:
                System.out.println( a + "-El numero Uno:"+ num.getCantidadUno()+ " es positivo");
                break;
            case 0:
                System.out.println(a + "-El numero Uno:"+ num.getCantidadUno()+ " es negativo");
                break;
            default:
                System.out.println(a + "-El numero Uno:"+ num.getCantidadUno()+ " es cero");
                break;
        }
        
        switch (b) {
            case 1:
                System.out.println(b + "-El numero Dos:"+ num.getCantidadDos()+ " es positivo");
                break;
            case 0:
                System.out.println(b + "-El numero Dos:"+ num.getCantidadDos()+ " es Negativo");
                break;
            default:
                System.out.println(b + "-El numero Dos:"+ num.getCantidadDos()+ " es cero");
                break;
        }
    }
    
}

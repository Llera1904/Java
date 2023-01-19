/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica;

/**
 *
 * @author Macario
 */
public class InterfazGrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new Vista(); // Se crea una instancia anómina de la Vista
        
        // Información del directorio de trabajo
        
        String home = System.getProperty("user.dir");
        System.out.println("Directorio de trabajo: " + home);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalia;

/**
 *
 * @author Macario
 */
public class Animalia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Felino silvestre = new Gato("Silvestre","Abuelita");
        silvestre.mostrarInfo();
        ((Gato)(silvestre)).maullar(5);
        
        Leon simba = new Leon("simba");
        simba.mostrarInfo();
        
        Presa piolin = new Canario();
        Presa speedy = new Raton();
        Presa mickey = new Raton();
        
        simba.acechar(mickey);
        silvestre.atrapar(piolin);
        silvestre.atrapar(speedy);
        simba.asearse();
        silvestre.asearse();
        
        Chita chester = new Chita("Chester Chetoos");
        chester.asearse();
        chester.atrapar(piolin);
    }
    
}

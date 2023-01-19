/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfismo;

/**
 *
 * @author
 */
public class Polimorfismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("\nEjemplo de Polimorfismo\n");
        Animal tom = new Animal();  // La variable tom es una referencia a una instancia de la clase Animal
        tom.show();
        tom.emitirSonido();
    
        tom = new Gato();    // Ahora la variable tom es una referencia a una instancia de la clase Gato
        tom.show();
        tom.emitirSonido();
        ((Gato)tom).dejarseQuerer();  // Comportarse como Mascota
    
        tom = new Perro();   // Ahora la variable tom es una referencia a una instancia de la clase Perro
        tom.show();
        tom.emitirSonido();
        ((Perro)tom).dejarseQuerer(); // Comportarse como Mascota
        
        System.out.println("\n====================\nThe End...");
    }
    
}

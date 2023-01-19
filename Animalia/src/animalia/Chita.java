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
public class Chita extends Felino 
{
            
    // Constructor    
    public Chita(String nombre)
    {
        super(nombre);
    }
    
    
    @Override
    public void asearse()
    {
        System.out.println("El chita se limpia con su baba");
    }
}

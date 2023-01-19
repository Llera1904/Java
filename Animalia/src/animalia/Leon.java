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
public class Leon extends Felino
{
    
    // Constructor    
    public Leon(String nombre)
    {
        super(nombre);
    }
    
    
    @Override
    public void asearse()
    {
        System.out.println("Leon aseandose con su garrota");
    }
}

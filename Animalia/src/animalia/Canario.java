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
public class Canario implements Presa, Volador
{
    
    private String nombre;
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return nombre;
    }
    
    @Override
    public void sufrir()
    {
        System.out.println("Canario Sufriendo");
    }
      
    @Override
    public void despegar()
    {
        System.out.println("Canario Despegando");
    }
 
        @Override
    public void volar()
    {
        System.out.println("Canario Volando");
    }
 
    @Override
    public void aterrizar()
    {
        System.out.println("Canario Aterrizando");
    }
 
}
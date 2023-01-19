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
public class Perro extends Animal implements Mascota
{
    @Override
    public void emitirSonido()
    {
        System.out.println("Guau!!!");
    }
    
    @Override
    public void show()
    {
        System.out.println("Soy perrísimo");
    }
    
    @Override
    public void dejarseQuerer()
    {
        System.out.println("Moviendo la colita...▼(´ᴥ`)▼");
    }
}

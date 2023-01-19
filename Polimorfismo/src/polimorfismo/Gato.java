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
public class Gato extends Animal implements Mascota
{
    @Override
    public void emitirSonido()
    {
        System.out.println("Miau!!!");
    }
        
    @Override
    public void show()
    {
        System.out.println("Soy michi");
    }
    
    @Override
    public void dejarseQuerer()
    {
        System.out.println("Ronroneando... =^.^= ");
    }
}
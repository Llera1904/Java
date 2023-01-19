/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

/**
 *
 * @author Macario
 */

// Almacena el estado del Sprite

public class Parametros
{
        int xAzul= 0;
        int yAzul = 0;
        int xRojo = 0;
        int yRojo = 0;
        
	public boolean moving = true;

	public boolean isMoving()
	{
		return moving;
	}

	public void stopMoving()
	{
		moving = false;
	}

	public void startMoving()
	{
		moving = true;
	}

        public int getXazul ()
        {
            return xAzul;
        }
        
        public int getXrojo ()
        {
            return xRojo;
        }
        
        public int getYazul ()
        {
            return yAzul;
        }
        
        public int getYrojo ()
        {
            return yRojo;
        }
        
        public void setXazul (int x)
        {
             xAzul= x;
        }
        
        public void setXrojo (int x)
        {
             xRojo= x;
        }
         
        public void setYazul (int y)
        {
             yAzul= y;
        }
        
        public void setYrojo (int y)
        {
             yRojo= y;
        }
}
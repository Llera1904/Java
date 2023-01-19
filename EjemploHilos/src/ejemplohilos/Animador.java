/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

import javax.swing.*;

public class Animador extends Thread
{
	private JLabel et;
	private Parametros  p;
	private int width;
	private int height;

	public Animador(JLabel et, Parametros p, ImageIcon face, int w, int h)
	{
		width = w;
		height= h;
		this.p = p;
		this.et = et;
		et.setIcon(face);
	}

        @Override
	public void run()
	{
		    int x = et.getX();
		    int y = et.getY();   
                    int dirX=1;
                    int dirY=1;

                    while(true)
                    {

			System.out.println(et.getText()+ " en coordenadas (" + x + "," + y + ")");
                        
                        if (et.getText().equals("Azul"))
                          {
                              p.setXazul(x);
                              //p.setYazul(y);  
                              
                              //if(p.getXazul() + et.getWidth() == p.getXrojo()) dirX=-1;
                              if(p.getXazul() == p.getXrojo() + et.getWidth()) dirX=1;
                          }
                        else if (et.getText().equals("Rojo"))
                          {
                              p.setXrojo(x);
                              //p.setYrojo(y);
                              
                              //if(p.getXrojo() == p.getXazul() + et.getWidth()) dirX=1;
                              if(p.getXrojo() + et.getWidth() == p.getXazul()) dirX=-1;
                          }
                    
			if(p.isMoving())
			{   

                            if(x > width-et.getWidth()-10 && dirX == 1) dirX=-1;
                            if(x < 10 && dirX==-1) dirX=1;

                            if(y > height-et.getHeight()-10 && dirY ==1) dirY=-1;
                            if(y < 10 && dirY==-1) dirY=1;

                            et.setLocation(x,y);

                            try
                            {
				sleep(10);
                            }
                            catch (Exception ex)
                            {
				ex.printStackTrace();
                            }
                            x=x+dirX;
                            y=y+dirY;
                            
                            
			}

                    }
	}
}

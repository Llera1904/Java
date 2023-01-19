/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

/**
 *
 * @author 
 */
public class Calculadora 
{
        private double memoria = 0;
	private char operadorAnterior = '=';
        private boolean radianes = true;

	public void operacion(double numero, char operador)
	{
            
            if(operadorAnterior == '=')
                memoria = numero;
            else
            	switch(operadorAnterior)
		{
                    case '+': memoria+=numero; break;
                    case '-': memoria-=numero; break;
                    case '*': memoria*=numero; break;
                    case '/': memoria/=numero; break;
		}
            operadorAnterior=operador;
	}
        
        public void trigonometrica(double numero, char operador)
	{  
          switch (operador)
		{
                    case 's': memoria= Math.sin(((numero)*(Math.PI/180))); break;
                    case 'c': memoria=Math.cos(((numero)*(Math.PI/180))); break;
                    case 't': memoria=Math.tan(((numero)*(Math.PI/180))); break;
		}
	}
        
        public void inverso (double numero)
	{  
          memoria= Math.pow(numero, -1);
	}
        
        public void cuadrado (double numero)
	{  
          memoria= Math.pow(numero, 2);
	}
         
        public void raiz2 (double numero)
	{  
          memoria= Math.sqrt(numero);
	}
         
        public void raiz3 (double numero)
	{  
          memoria= Math.cbrt(numero);
	}

        public void clearMemory()
        {
            memoria=0;
        }
        
	public double getMemoria()
	{
		return memoria;
	}

        public void setRadianes()
        {
            radianes=false;
        }
        
        public void setDegrees()
        {
            radianes=false;
        }
        
        public boolean isRadianes()
        {
            return radianes;
        }
}

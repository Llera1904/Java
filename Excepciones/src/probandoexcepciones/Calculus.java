/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandoexcepciones;

/**
 *
 * @author Macario
 */
public class Calculus 
{
    public static double tangente(double angle) throws InvalidAngleException
    {
    	if(angle == 90) throw new InvalidAngleException("Angulo invalido");
    	return Math.tan(angle*Math.PI/180);
    }

    public static int factorial(int n) throws InvalidNumberException
    {
		if(n < 0 || n > 10) throw new InvalidNumberException("Numero invalido");

		if(n==1) return 1;

		int f=1;

		for(int i=1;i<=n;i++)
		    f=f*i;

		return f;
    }
    
    public static double raiz(double n) throws NegativeException
    {
        if(n < 0) throw new NegativeException("Radicando negativo en raíz cuadrada");
        return Math.sqrt(n);
    }
    
}

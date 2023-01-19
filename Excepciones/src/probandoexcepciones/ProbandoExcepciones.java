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
public class ProbandoExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  
    {

        try
	{
            double t = Calculus.tangente(80);
            System.out.println(Calculus.factorial(-5));
            System.out.println(t);
            System.out.println(Calculus.raiz(1));
	}
	catch (InvalidAngleException ex)
	{
            ex.printStackTrace();
	}
       	catch (InvalidNumberException ex)
	{
            ex.printStackTrace();
	}
        
        catch (NegativeException ex)
	{
            ex.printStackTrace();
	}
        finally
        {
            System.out.println("Cuando cachamos excepciones todo va bien!!!");
        }
       System.out.println("Fin del programa!!!");
    } 
}

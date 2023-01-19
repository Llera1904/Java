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
public interface Depredador 
{
    	public void acechar(Presa presa);
	public void perseguir(Presa presa);
	public void atrapar(Presa presa);
}

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
public final class Gato extends Felino
{
    
    private String nombreDueño;  // Atributo privado

    public Gato(String nombre, String nombreDueño)  // Constructor
    {
	super(nombre); 
	this.nombreDueño = nombreDueño;
    }

    public void setDueño(String nombreDueño)
    {
        this.nombreDueño = nombreDueño;
    }
    
    public String getDueño()
    {
        return nombreDueño;
    }
    
    public void maullar()
    {
        System.out.println("Miauu");
    }

    public void maullar(int n) // Sobrecarga
    {
        for(int i=0;i<n;i++) maullar();
    }

    @Override
    public void atrapar(Presa presa)
    {   
        presa.sufrir();
    }

    @Override
    public void mostrarInfo() // Sobreescritura de método
    {
		super.mostrarInfo(); // LLama al mostrarInfo() de la superclase
		System.out.println("Es un gato");
		System.out.println("Nombre del Dueño : " + nombreDueño);
    }
    
    @Override
    public void asearse()
    {
        System.out.println("Gato aseandose con su manita");
    }
}

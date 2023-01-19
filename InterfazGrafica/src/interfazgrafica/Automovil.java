package interfazgrafica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macario
 */
public class Automovil {
    
    private String marca;
    private String modelo;
    private String color;
    private String imagen;
    
    // Constructor
    public Automovil (String marca, String modelo, String color, String imagen)
    {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.imagen = imagen;
    }        
    
    // Métodos get
    
    public String getMarca ()
    {
        return this.marca;
    }   
   
    public String getModelo ()
    {
        return this.modelo;
    }     
    
    public String getColor ()
    {
        return this.color;
    } 

    public String getImagen ()
    {
        return this.imagen;
    } 
    
    
    // Métodos set
    
    public void setMarca (String marca)
    {
        this.marca = marca;
    }
       
    public void setModelo (String modelo)
    {
        this.modelo = modelo;
    }
        
    public void setColor (String color)
    {
        this.color = color;
    }
  
    public void setImagen (String imagen)
    {
        this.imagen = imagen;
    }
    // Métodos auxiliares
    
    public String getData()
    {
        String data = "\nDATOS DEL AUTOMOVIL\n";
        data = data.concat("\nMarca : " + this.marca);
        data = data.concat("\nModelo: " + this.modelo);
        data = data.concat("\nColor : " + this.color);

        return data;
    }
    
}

    


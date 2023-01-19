/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplanet;

/**
 *
 * @author leoll
 */
public class VideoGame {
    
    private String imagen;
    
    private String upc;
    private String descripcion;
    private String desarrollador;    
    private String plataforma;       
    private String clasificacion;       
    private String genero;        
    private String precio; 
    
    public VideoGame (String upc, String descripcion, String desarrollador, String plataforma, String clasificacion, String genero, String precio) 
    {
       this.upc = upc;
       this.descripcion = descripcion;
       this.desarrollador = desarrollador;    
       this.plataforma = plataforma;       
       this.clasificacion = clasificacion;       
       this.genero = genero; 
       this.precio = precio; 
     }
    
    public String getClasificacion() {
        
       switch  (this.clasificacion)
       {
           case "EVERYONE" : imagen = "E"; break;
           case "EVERYONE +10" : imagen = "E10"; break;
           case "TEEN" : imagen = "T"; break;
           case "MATURE +17" : imagen = "M"; break;
           case "ADULTS ONLY +18" : imagen = "A"; break;
       }
       
       return imagen;
    // Otra forma de hacerlo
       /*if (clasificacion.equals("EVERYONE"))
         imagen = "E";
       else if (clasificacion.equals("EVERYONE +10"))
         imagen = "E10";
       else if (clasificacion.equals("TEEN"))
         imagen = "T";
       else if (clasificacion.equals("Maduros (+17)"))
         imagen = "M";
       else if (clasificacion.equals("ADULTS ONLY +18"))
         imagen = "A";  
       
       return imagen;*/
    }
    
    public String getData ()
    {
        String data = "";
        data = data.concat("\nUCP : " + this.upc);
        data = data.concat("\nDescripcion: " + this.descripcion);
        data = data.concat("\nDesarrollador : " + this.desarrollador);
        data = data.concat("\nPrecio : " + this.precio);
        data = data.concat("\nPlataforma: " + this.plataforma);
        data = data.concat("\nClasificacion: " + this.clasificacion);
        data = data.concat("\nGenero : " + this.genero);
        
        return data;
    }
}
  
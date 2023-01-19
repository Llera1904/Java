/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplanet2;

/**
 *
 * @author leoll
 */

import java.sql.*;
import java.util.*;

public class VideoGame {
    
    private String imagen;
    
    private String upc;
    private String descripcion;
    private String desarrollador;    
    private String plataforma;       
    private String clasificacion;       
    private String genero; 
    private String imagenJuego;
    private double precio; 
    
    public VideoGame()
    {}
    
    public VideoGame (String upc, String descripcion, String desarrollador, String plataforma, String clasificacion, String genero, String imagenJuego, double precio) 
    {
       this.upc = upc;
       this.descripcion = descripcion;
       this.desarrollador = desarrollador;    
       this.plataforma = plataforma;       
       this.clasificacion = clasificacion;       
       this.genero = genero; 
       this.imagenJuego = imagenJuego;
       this.precio = precio; 
     }
    
    // Metodos get

	public String getUpc()
	{
	    return upc;
	}

	public String getDescripcion()
	{
	    return descripcion;
	}

	public String getDesarrollador()
	{
	    return desarrollador;
	}

	public String getPlataforma()
	{
	    return plataforma;
	}
        
        public  String getClasificacion()
	{
	    return clasificacion;
	}
        
        public  String getGenero()
	{
	    return genero;
	}
        
        public  String getImagenJuego()
	{
	    return imagenJuego;
	}

	public  double getPrecio()
	{
	    return precio;
	}
        
    public String getImagenClasificacion() {
        
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
        data = data.concat("\nPlataforma: " + this.plataforma);
        data = data.concat("\nClasificacion: " + this.clasificacion);
        data = data.concat("\nGenero : " + this.genero);
        data = data.concat("\nPrecio : " + String.valueOf(this.precio));
        
        return data;
    }
    
    // Métodos set

	public void setUpc(String upc)
	{
	    this.upc= upc;
	}

	public void setDescripcion (String descripcion)
	{
	    this.descripcion = descripcion;
	}

	public void setDesarrollador(String desarrollador)
	{
	    this.desarrollador = desarrollador;
	}

        public void setPlataforma(String plataforma)
	{
	    this.plataforma = plataforma;
	}
        
        
	public void setClasificacion(String clasificacion)
	{
	    this.clasificacion = clasificacion;
	}
        
        public void setGenero(String genero)
	{
	    this.genero = genero;
	}
        
        public void setImagenJuego(String imagenJuego)
	{
	    this.imagenJuego = imagenJuego;
	}

	public void setPrecio(double precio)
	{
	    this.precio = precio;
	}   
        
        public static VideoGame getJuegoFromDB(String upcConsulta, Properties prop)
	{
            VideoGame newGame = new VideoGame(); // Nuevo Juego en blanco

            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password;
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("SELECT * FROM VIDEOJUEGOS WHERE UPC = ?");
                ps.setString(1,upcConsulta);
                System.out.println(ps.toString());
                ps.executeQuery();
                ResultSet rs = ps.getResultSet();

                if(rs!=null && rs.next())
                {
                    String upc   = rs.getString("upc");
                    String descripcion = rs.getString("descripcion");
                    String desarrollador = rs.getString("desarrollador");
                    String plataforma = rs.getString("plataforma");
                    String clasificacion = rs.getString("clasificacion");
                    String genero = rs.getString("genero");
                    String imagenJuego = rs.getString("imagen");
                    double precio = rs.getDouble("precio");

                    newGame.setUpc(upc);
                    newGame.setDescripcion(descripcion);
                    newGame.setDesarrollador(desarrollador);
                    newGame.setPlataforma(plataforma);
                    newGame.setClasificacion(clasificacion);
                    newGame.setGenero(genero);
                    newGame.setImagenJuego(imagenJuego);
                    newGame.setPrecio(precio);
                    con.close();
                    return newGame;
                }

	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return null;
	}
        
        public boolean cambiar(Properties prop)
	{
            boolean exito = false;
            
            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password;
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("UPDATE VIDEOJUEGOS SET DESCRIPCION = ?, DESARROLLADOR = ?, PLATAFORMA = ?, CLASIFICACION = ?, GENERO = ?, IMAGEN = ?, PRECIO = ? WHERE UPC = ?");
                
                ps.setString(1, this.descripcion); 
                ps.setString(2, this.desarrollador);
                ps.setString(3, this.plataforma);
                ps.setString(4, this.clasificacion);
                ps.setString(5, this.genero);
                ps.setString(6, this.imagenJuego);
                ps.setDouble(7, this.precio);
                ps.setString(8, this.upc);
                System.out.println(ps.toString());
                exito = ps.executeUpdate() > 0;
                con.close();
               
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return exito;
	}

        public boolean borrar(Properties prop)
	{
            boolean exito = false;
            
            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password;
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("DELETE FROM VIDEOJUEGOS WHERE UPC= ?");
                ps.setString(1, this.upc);
                System.out.println(ps.toString());
                exito = ps.executeUpdate() > 0;
                con.close();
               
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return exito;
	}

        public boolean alta(Properties prop)
	{
            boolean exito = false;
            
            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password;
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("INSERT INTO VIDEOJUEGOS (UPC, DESCRIPCION, DESARROLLADOR, PLATAFORMA, CLASIFICACION, GENERO, IMAGEN, PRECIO) VALUES (?,?,?,?,?,?,?,?)");
                ps.setString(1, this.upc);
                ps.setString(2, this.descripcion); 
                ps.setString(3, this.desarrollador);
                ps.setString(4, this.plataforma);
                ps.setString(5, this.clasificacion);
                ps.setString(6, this.genero);
                ps.setString(7, this.imagenJuego);
                ps.setDouble(8, this.precio);
                System.out.println(ps.toString());
                exito = ps.executeUpdate() > 0;
                con.close();
               
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return exito;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectolibreria;

/**
 *
 * @author 
 */

import java.sql.*;
import java.util.*;

public class Libro
{
	private String isbn;
	private String titulo;
	private String autor;
        private String editorial;
	private String imagen;
	private double precio;

	public Libro()
	{}

	public Libro(String isbn, String titulo, String autor, String editorial, String imagen, double precio)
	{
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
                this.editorial = editorial;
		this.imagen = imagen;
		this.precio = precio;

	}

	// Metodos get

	public String getIsbn()
	{
		return isbn;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public String getAutor()
	{
		return autor;
	}

	public String getImagen()
	{
		return "imagenes/" + imagen;
	}
        
        public  String getEditorial()
	{
		return editorial;
	}

	public  double getPrecio()
	{
		return precio;
	}

	// Métodos set

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public void setAutor(String autor)
	{
		this.autor = autor;
	}

        public void setEditorial(String editorial)
	{
		this.editorial = editorial;
	}
        
	public void setImagen(String imagen)
	{
		this.imagen = imagen;
	}

	public void setPrecio(double precio)
	{
		this.precio = precio;
	}


	public void muestraDatos()
	{
		System.out.println("ISBN  :" + isbn);
		System.out.println("Titulo:" + titulo);
		System.out.println("Autor :" + autor);
                System.out.println("Autor :" + editorial);
		System.out.println("Precio:" + precio);
	}


	public static Libro getLibroFromDB(String isbnConsulta, Properties prop)
	{
            Libro libro = new Libro(); // Nuevo libro en blanco

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

                PreparedStatement ps = con.prepareStatement("SELECT * FROM LIBROS WHERE ISBN = ?");
                ps.setString(1,isbnConsulta);
                System.out.println(ps.toString());
                ps.executeQuery();
                ResultSet rs = ps.getResultSet();

                if(rs!=null && rs.next())
                {
                    String isbn   = rs.getString("isbn");
                    String titulo = rs.getString("titulo");
                    String autor  = rs.getString("autor");
                    String editorial  = rs.getString("editorial");
                    String imagen = rs.getString("imagen");
                    double precio = rs.getDouble("precio");

                    libro.setIsbn(isbn);
                    libro.setTitulo(titulo);
                    libro.setAutor(autor);
                    libro.setEditorial(editorial);
                    libro.setPrecio(precio);
                    libro.setImagen(imagen);
                    con.close();
                    return libro;
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

                PreparedStatement ps = con.prepareStatement("UPDATE LIBROS SET TITULO = ?, AUTOR = ?, EDITORIAL = ?, PRECIO = ? WHERE ISBN = ?");
                
                ps.setString(1, this.titulo); // El titulo que llega de la Vista
                ps.setString(2, this.autor);
                ps.setString(3, this.editorial);
                ps.setDouble(4, this.precio);
                //ps.setString(5, this.imagen);
                ps.setString(5, this.isbn);
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

                PreparedStatement ps = con.prepareStatement("DELETE FROM LIBROS WHERE ISBN = ?");
                ps.setString(1, this.isbn);
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

                PreparedStatement ps = con.prepareStatement("INSERT INTO LIBROS (ISBN, TITULO, AUTOR, EDITORIAL, PRECIO) VALUES (?,?,?,?,?)");
                ps.setString(1, this.isbn); 
                ps.setString(2, this.titulo);
                ps.setString(3, this.autor);
                ps.setString(4, this.editorial);
                ps.setDouble(5, this.precio);
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
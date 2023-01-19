/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajdbc;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Macario
 */
public class PruebaJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String mySQLHost = "jdbc:mysql://localhost:3306/";
        String dbName = "world";  // Esta base de datos debe estar en el servidor
        String user = "root"; // No es lo adecuado, este es un usuario para el admin
        String password = ""; 
        JPasswordField pwd = new JPasswordField(10); // Enmascara 
        int option = JOptionPane.showConfirmDialog(null, pwd,"Enter root password",JOptionPane.OK_CANCEL_OPTION);
        if (option == 0) password = new String(pwd.getPassword());
         
        Connection con= null;
	try
	{
            Class.forName("com.mysql.cj.jdbc.Driver");   //Carga el driver
            String urlBD = mySQLHost + dbName+ "?user=" + user + "&password=" + password + "&useSSL=false"; // Construye la URL de la base de datos
            con = DriverManager.getConnection(urlBD); // Intenta abrir la conexión (si no la logra lanza una excepción
            Statement st = con.createStatement();    // Statement permite enviar comandos SQL al DBMS
            
            if (st.execute("show tables")) // Envía un comando, si hubo resultados regresa true
              {
                String resultados = "";
                ResultSet rs = st.getResultSet();
                while (rs.next())
                     {
                       resultados+= rs.getString(1)+"\n";
                     }
                JOptionPane.showMessageDialog(null, resultados, "Éxito!!! Estas son la tablas de la DB: " + dbName, JOptionPane.PLAIN_MESSAGE);
              }
            con.close();
        }
	catch (ClassNotFoundException ex)
        {
            JOptionPane.showConfirmDialog(null, "Error al cargar el driver", "Problema!!!" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
	}
        catch (SQLException ex)
        {
            JOptionPane.showConfirmDialog(null, "Error de SQL al hacer la conexión o la consulta", "Problema!!!" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }   
}

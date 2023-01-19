/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gameplanet2;



/**
 *
 * @author leoll
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class GamePlanet2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean todoBien = true;
        Properties prop   = new Properties();  // Para guardar la conf de la base de datos
        
        // Carga las propiedades desde el archivo
	try
	{
            prop.load(new FileInputStream("config.properties"));
	}
	catch (Exception ex)
	{
            todoBien = false;
            JOptionPane.showMessageDialog(null, "Problema con el archivo de propiedades", "Aviso!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
	}
        
        if(todoBien)
        {
            String driver = prop.getProperty("dbdriver");
            String host   = prop.getProperty("dbhost");
            String user   = prop.getProperty("dbuser");
            String password = prop.getProperty("dbpassword");
            String name     = prop.getProperty("dbname");
            String url = host + name  + "?user=" + user + "&password=" + password;
            System.out.println("Conexion a la BD: " + url);

            try
            {
                Class.forName(driver);     // Carga el driver
                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD
                con.close();
            }
            catch (ClassNotFoundException ex)
            {
                todoBien = false;
                JOptionPane.showConfirmDialog(null, "Problema al cargar el driver", "Aviso!!!" , JOptionPane.ERROR_MESSAGE);
            }
            catch (SQLException ex)
            {
                todoBien = false;
                JOptionPane.showConfirmDialog(null, "Problema al tratar de hacer la conexion", "Aviso!!!" , JOptionPane.ERROR_MESSAGE);
            }            
        }
        
        if(todoBien) // Solo si todo está bien con la BD
        {
            Vista v = new Vista(prop);
            v.setVisible(true);
        }
    }
}

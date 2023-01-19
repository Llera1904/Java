/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookshop;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author macario
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        String ipServidor="";
        int puerto=0;
        
        boolean todoBien = true;
        Properties prop   = new Properties();  // Para guardar la conf de la base de datos
        
        // Carga las propiedades desde el archivo
	try
	{
            prop.load(new FileInputStream("config.properties"));
            ipServidor = prop.getProperty("ipServidor");
            puerto = Integer.parseInt(prop.getProperty("puerto"));
            
	}
	catch (Exception ex)
	{
            todoBien = false;
            JOptionPane.showMessageDialog(null, "Problema con el archivo de propiedades", "Aviso!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
	}
        
        if(todoBien)
        {
            try
            {
                Socket skCliente = new Socket( ipServidor , puerto ); // Crea un socket hacia el servidor

                // Envia solicitud al servidor

                OutputStream flujoSalida = skCliente.getOutputStream();
                ObjectOutputStream salida = new ObjectOutputStream( flujoSalida );
                JSONObject jsonEnviar = new JSONObject();
                jsonEnviar.put("operacion","test");
                jsonEnviar.put("dato", "none");
                
                System.out.println(jsonEnviar.toString());
                salida.writeObject(jsonEnviar.toString());
   
                // Recupera la respuesta
                    
                InputStream flujoEntrada = skCliente.getInputStream();
                ObjectInputStream entrada = new ObjectInputStream( flujoEntrada );
                String respuesta = (String) entrada.readObject();
                skCliente.close(); 
          
            }
            catch (Exception ex)
            {
                todoBien = false;
                JOptionPane.showMessageDialog(null, "El servidor no está funcionando", "Aviso!", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
       
        // Si pasa los test continúa
        if(todoBien)
        {       
            Login loginDialog = new Login(ipServidor, puerto);
            loginDialog.setVisible(true);
        }
    }    
}

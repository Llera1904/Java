/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author macario
 */
public class Vista extends JFrame {
    
    // DECLARACION DE CAMPOS Y BOTONES
    
    private final JTextField jTextName = new JTextField();
    private final JTextField jTextEmail = new JTextField();
    private final JTextField jTextNumber = new JTextField();
    private final JTextField jTextPhoto = new JTextField();
    private final JPasswordField jTextPassword = new JPasswordField();
    
    // Cuadro Imagen
    private final JLabel jLabelFotografia = new JLabel();
    
    // Botones
    private final JButton jButtonProcesar = new JButton("Process");
    private final JButton jButtonLimpiar  = new JButton("Clear");
        
    public Vista() // Constructor
    {
        this.setTitle("User Registration");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,640,480);
        
        initComponents();
  
        this.setVisible(true);
    }
    
    public void initComponents()
    {
        // Declaración de etiquetas
        JLabel etiquetaName   = new JLabel("Name:");
        JLabel etiquetaEmail    = new JLabel("e-Mail:");
        JLabel etiquetaNumber   = new JLabel("Number:");
        JLabel etiquetaPhoto   = new JLabel("Photo:");
        JLabel etiquetaPassword = new JLabel("Password:");

        // Diseña menú
        JMenuBar barraMenus = new JMenuBar();
	JMenu archivo 	  = new JMenu("File");
	JMenuItem salir   = new JMenuItem("Exit");
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        archivo.add(salir);
            
        // Posiciones de los componentes
        this.setLayout(null); // El programador indica coordenadas y tamaño
        
        etiquetaName.setBounds(100,50,100,30);
        jTextName.setBounds(200,50,200,30);
        
        etiquetaEmail.setBounds(100,100,100,30);
        jTextEmail.setBounds(200,100,200,30);
        
        etiquetaNumber.setBounds(100,150,100,30);
        jTextNumber.setBounds(200,150,200,30);
        
        etiquetaPhoto.setBounds(100,200,100,30);
        jTextPhoto.setBounds(200,200,200,30);
        
        etiquetaPassword.setBounds(100,250,100,30);
        jTextPassword.setBounds(200,250,200,30);
       
        jLabelFotografia.setBounds(450,50,100,150);
        
        jButtonProcesar.setBounds(200,350,100,40);
        jButtonLimpiar.setBounds(320,350,100,40);
        
        // Propiedades de los componentes
        
        jLabelFotografia.setBorder(BorderFactory.createLineBorder(Color.black));
        //jLabelFotografia.setIcon(new ImageIcon("img/saiki.png"));
         
        
        // Agrega los componentes al Frame (y se mostrarán en el Frame)
        
        this.add(jLabelFotografia);
        
        this.add(etiquetaName);
        this.add(jTextName);
        
        this.add(etiquetaEmail);
        this.add(jTextEmail);
        
        this.add(etiquetaNumber);
        this.add(jTextNumber);
        
        this.add(etiquetaPhoto);
        this.add(jTextPhoto);
        
        this.add(etiquetaPassword);
        this.add(jTextPassword);
      
        this.add(jButtonProcesar);
        this.add(jButtonLimpiar);
        
        // GESTION DE EVENTOS
        
        // Lo que se debe hacer cuando el usuario elija la opción "Salir" 
        salir.addActionListener(evt -> gestionaSalir(evt));
            
        // Lo que se debe hacer cuando el usuario elija el botón "Procesar"
        jButtonProcesar.addActionListener(evt -> gestionaProcesar(evt));
        
        // Lo que se debe hacer cuando el usuario elija la opción "Limpiar"
        jButtonLimpiar.addActionListener(evt -> gestionaLimpiar(evt));
                
        // Lo que se debe hacer cuando e usurio elija la "X" de la ventana para salir      
        class MyWindowAdapter extends WindowAdapter
	{
            @Override
            public void windowClosing(WindowEvent e)
            {
		exit(); 
            }
	}
        addWindowListener(new MyWindowAdapter());
        
    }
    
    public void gestionaSalir(java.awt.event.ActionEvent evt)
    {
        exit();
    }

    public void exit()
    {
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Aviso",JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
    }
    
    public void gestionaProcesar(java.awt.event.ActionEvent evt)
    {
        // Escriba aqui el código para recuperar los datos desde las cajas de texto 
        // y crear con ellos un objeto Usuario (y mostrar la fotografía)
        // Obtiene los datos capturados en las cajas de texto
        String nameCapturado = jTextName.getText().toUpperCase();
        String emailCapturado = jTextEmail.getText().toUpperCase();
        String numberCapturado = jTextNumber.getText().toUpperCase();
        String photoCapturada = jTextPhoto.getText().toUpperCase();
        String passwordCapturada = jTextPassword.getText().toUpperCase();
        
         boolean hayError = false;
        
        // Validaciones
        
        if(nameCapturado.length() == 0)
        {    
            JOptionPane.showConfirmDialog(rootPane, "Error!! El campo de Name no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
         
        if(emailCapturado.length() == 0)
        {    
            JOptionPane.showConfirmDialog(rootPane, "Error!! El campo de e-Mail no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
                   
        if(numberCapturado.length() == 0)
        {   
            JOptionPane.showConfirmDialog(rootPane, "Error!! El campo de Number no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }

        if(passwordCapturada.length() == 0)
        {    
            JOptionPane.showConfirmDialog(rootPane, "Error!! El campo de Password no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
        
        if(!hayError)  // Si no hubo error
        {
            String datosCaptados;
            Usuario nuevoUsuario = new Usuario(nameCapturado, emailCapturado, numberCapturado, photoCapturada, passwordCapturada);
        
            datosCaptados = "DATOS DEL USUARIO";
            datosCaptados = nuevoUsuario.getData();
            
            jLabelFotografia.setIcon(new ImageIcon("img/" + nuevoUsuario.getPhoto() + ".png"));
            JOptionPane.showMessageDialog(rootPane, datosCaptados);
        }     
    }
    
    public void gestionaLimpiar(java.awt.event.ActionEvent evt)
    { 
        // Escriba aquí el código para limpiar la caja de texto y la foto
        jTextName.setText("");
        jTextEmail.setText("");
        jTextNumber.setText("");
        jTextPhoto.setText("");
        jTextPassword.setText("");
        jLabelFotografia.setIcon(null);
    }
}

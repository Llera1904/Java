/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author 
 */

// La clase vista extiende la clase JFrame de la biblioteca SWING que modela
// una ventana típica de aplicación

public class Vista extends JFrame
{
    
    // COMPONENTES PRINCIPALES
    
    //Cajas de Texto
    private JTextField marca = new JTextField();
    private JTextField modelo = new JTextField();
    private JTextField color = new JTextField();
    private JTextField imagen = new JTextField();
    
    // Area de Texto
    private JTextArea  resultados = new JTextArea();

    // Botones
    private JButton jButtonProcesar = new JButton("Procesar");
    private JButton jButtonLimpiar  = new JButton("Limpiar");
    
    // Label para la Imagen  
    private JLabel cuadroImagen = new JLabel();
        
    // Constructor de la vista
    public Vista()
    {
        this.setTitle("Autos Usados 'El Mofles'");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,640,480);
        
        initComponents();
  
        this.setVisible(true);
    }
    
    public void initComponents()
    {
        // Diseña menú
        JMenuBar barraMenus = new JMenuBar();
	JMenu archivo 	  = new JMenu("Archivo");
        JMenuItem abrir   = new JMenuItem("Abrir");
	JMenuItem salir   = new JMenuItem("Salir");
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        archivo.add(abrir);
        archivo.add(salir);
        
        // Componentes auxiliares
        JLabel etiqueta1 = new JLabel("Marca:");
        JLabel etiqueta2 = new JLabel("Modelo:");
        JLabel etiqueta3 = new JLabel("Color:");
        JLabel etiqueta4 = new JLabel("Imagen:");
        JLabel etiqueta5 = new JLabel("Resultado:");
            
        // Posiciones de los componentes
        this.setLayout(null); // El programador indica coordenadas y tamaño
        etiqueta1.setBounds(50,30,100,30);
        etiqueta2.setBounds(50,80,100,30);
        etiqueta3.setBounds(50,130,100,30);
        etiqueta4.setBounds(50,180,100,30);
        etiqueta5.setBounds(50,230,200,30);  
        
        marca.setBounds(120,30,400,30);
        modelo.setBounds(120,80,400,30);
        color.setBounds(120,130,400,30);
        imagen.setBounds(120,180,400,30);
        cuadroImagen.setBounds(420,230,100,100);
        resultados.setBounds(120,230,250,100);
        jButtonProcesar.setBounds(200,350,100,40);
        jButtonLimpiar.setBounds(320,350,100,40);

         // Características de componentes
        resultados.setLineWrap(true);  // Para que sea multilinea
        resultados.setBorder(BorderFactory.createLineBorder(Color.black));
        resultados.setEditable(false);
        resultados.setFont(new Font("Courier New", Font.PLAIN, 12));
        cuadroImagen.setBorder(BorderFactory.createLineBorder(Color.black));
        
        // Coloca componentes en la ventana
        this.add(etiqueta1);
        this.add(etiqueta2);
        this.add(etiqueta3);
        this.add(etiqueta4);
        this.add(etiqueta5);

        this.add(marca);
        this.add(modelo);
        this.add(color);
        this.add(imagen);
        this.add(cuadroImagen);
        this.add(resultados);
        
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

        // Obtiene los datos capturados en las cajas de texto
        String marcaCapturada = marca.getText().toUpperCase();
        String modeloCapturado = modelo.getText().toUpperCase();
        String colorCapturado = color.getText().toUpperCase();
        String imagenCapturada = imagen.getText();
        
        // Variable lógica que cambiará a true si encuetra errores
        boolean hayError = false;
        
        // Validaciones
        
        if(marcaCapturada.length() == 0)
        {    
            JOptionPane.showConfirmDialog(rootPane, "Error!! La marca no puede ser vacía", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
         
        if(modeloCapturado.length() == 0)
        {    
            JOptionPane.showConfirmDialog(rootPane, "Error!! El modelo no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
                   
        if(colorCapturado.length() == 0)
        {   
            JOptionPane.showConfirmDialog(rootPane, "Error!! El color no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }

        if(imagenCapturada.length() == 0)
        {    
            JOptionPane.showConfirmDialog(rootPane, "Error!! El nombre del archivo de magen no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
           
        if(!hayError)  // Si no hubo error
        {
            Automovil myCar = new Automovil(marcaCapturada, modeloCapturado, colorCapturado, imagenCapturada);
            resultados.setText(myCar.getData());
            
            // Mostrar la imagen
            
            cuadroImagen.setIcon(new ImageIcon("img/"+imagenCapturada));
        }    
        
    }
    
    public void gestionaLimpiar(java.awt.event.ActionEvent evt)
    {
        marca.setText("");
        modelo.setText("");
        color.setText("");
        imagen.setText("");
        resultados.setText("");
        cuadroImagen.setIcon(null);
    }
    
    
}

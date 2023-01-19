/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplanet2;

/**
 *
 * @author leoll
 */

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Vista extends JFrame {
    
    private final JLabel cuadroImagen = new JLabel("Juego");
    private final JLabel cuadroImagen2 = new JLabel("Clasificacion");
    
    // Lista desplegable
    private final JComboBox plataforma = new JComboBox();
    
    // Casillas de verificación
    private final JCheckBox accion = new JCheckBox("Accion");
    private final JCheckBox arcade = new JCheckBox("Arcade");
    private final JCheckBox aventura = new JCheckBox("aventura");
   
    // Radio Botone
    private final ButtonGroup clasificacion = new ButtonGroup();
    private final JRadioButton todos = new JRadioButton("Todos");
    private final JRadioButton todos2 = new JRadioButton("Todos (+10)");
    private final JRadioButton adolescentes = new JRadioButton("Adolescentes");
    private final JRadioButton maduros = new JRadioButton("Maduros (+17)");
    private final JRadioButton adultos = new JRadioButton("Adultos (+18)");
   
    // Botones de acción
    private final JButton btOpenFile = new JButton();
    private JButton    btBuscar  = new JButton("Buscar");
    private JButton    btInsertar  = new JButton("Agregar");
    private JButton    btBorrar  = new JButton("Eliminar");
    private JButton    btCambiar  = new JButton("Cambiar");
    private JButton    btLimpiar = new JButton("Limpiar");
    
    // Cajas de texto
    private final JTextField  upc = new JTextField();
    private final JTextField  descripcion= new JTextField();
    private final JTextField  desarrollador = new JTextField();
    private final JTextField  imagen = new JTextField();
    private final JTextField  precio = new JTextField();
    
    // Variables auxiliares
    private Properties prop;
    private String mensajeError = "";
 
    public Vista(Properties prop) // Constructor
    {
        this.prop = prop;
        this.setTitle("GamePlanet");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,640,530);
        
        initComponents();
        
        // Carga las propiedades desde el archivo
	try
	{
	    prop.load(new FileInputStream("config.properties"));
	}
	catch (Exception ex)
	{
	    ex.printStackTrace();
	}
  
        //this.setVisible(true);
    }
    
    public void initComponents()
    {
        // Etiquetas
        JLabel et1 = new JLabel("UPC:");
        JLabel et2 = new JLabel("Descripcion:");
        JLabel et3 = new JLabel("Desarrollador:");
        JLabel et4 = new JLabel("Precio:");
        JLabel et5 = new JLabel("Plataforma:");
        JLabel et6 = new JLabel("Clasificacion:");
        JLabel et7 = new JLabel("Generos:");   
        JLabel et8 = new JLabel("Imagen:");

        // Diseña menú
        JMenuBar barraMenus = new JMenuBar();
	JMenu archivo 	  = new JMenu("Archivo");
	JMenuItem salir   = new JMenuItem("Salir");
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        archivo.add(salir);

        // Elementos del ComboBox plataforma
        plataforma.addItem("PlayStation");
        plataforma.addItem("Xbox");
        plataforma.addItem("Pc");
        plataforma.setSelectedIndex(0); // Selecciona por defecto
        
        // Radio Botones
        todos.setActionCommand("EVERYONE");
        todos2.setActionCommand("EVERYONE +10");
        adolescentes.setActionCommand("TEEN"); 
        maduros.setActionCommand("MATURE +17");  
        adultos.setActionCommand("ADULTS ONLY +18");  
        clasificacion.add(todos);
        clasificacion.add(todos2);
        clasificacion.add(adolescentes);
        clasificacion.add(maduros);
        clasificacion.add(adultos);
        adultos.setSelected(true); // Selecciona por defecto        
       
        // Casillas de Verificación
        accion.setActionCommand("Accion");
        arcade.setActionCommand("Arcade");
        aventura.setActionCommand("Aventura");
         
        // Tamaño y posición
        this.setLayout(null);
        et1.setBounds(50,30,150,20); 
        et2.setBounds(50,70,150,20); 
        et3.setBounds(50,110,150,20); 
        et4.setBounds(50,150,150,20);   
        et5.setBounds(50,190,150,20);   
        et6.setBounds(50,230,150,20);  
        et7.setBounds(50,380,100,20);  
        et8.setBounds(380,240,60,20);  
        
        upc.setBounds(210,30,150,20);
        descripcion.setBounds(210,70,150,20);
        desarrollador.setBounds(210,110,150,20);
        imagen.setBounds(380,270,200,20);
        precio.setBounds(210,150,150,20);
        
        plataforma.setBounds(210,190,150,20);
        
        todos.setBounds(210,230,150,20);
        todos2.setBounds(210,260,150,20);
        adolescentes.setBounds(210,290,150,20);
        maduros.setBounds(210,320,150,20);
        adultos.setBounds(210,350,150,20);
        
        accion.setBounds(160,380,100,20);
        arcade.setBounds(270,380,100,20);
        aventura.setBounds(390,380,100,20);
        
        cuadroImagen.setBounds(380,30,200,200);
        cuadroImagen2.setBounds(50,260,100,110);
        
        btBuscar.setBounds(500,300,80,25);
        btInsertar.setBounds(100,410,80,25);
        btBorrar.setBounds(220,410,80,25);
        btCambiar.setBounds(340,410,80,25);
        btLimpiar.setBounds(460,410,80,25);        

        cuadroImagen.setBorder(BorderFactory.createLineBorder(Color.black));
        cuadroImagen.setHorizontalAlignment(SwingConstants.CENTER);
        cuadroImagen2.setBorder(BorderFactory.createLineBorder(Color.black));
        cuadroImagen2.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Agrega Componentes
        this.add(et1);
        this.add(et2);
        this.add(et3);
        this.add(et4);
        this.add(et5);
        this.add(et6);
        this.add(et7);
        this.add(et8);
        
        this.add(upc);
        this.add(descripcion);
        this.add(desarrollador);
        this.add(imagen);
        this.add(precio);
        
        this.add(plataforma);
        
        this.add(todos);
        this.add(todos2);
        this.add(adolescentes);
        this.add(maduros);
        this.add(adultos);
        
        this.add(accion);
        this.add(arcade);
        this.add(aventura);
       
        this.add(cuadroImagen);
        this.add(cuadroImagen2);
        
        this.add(btBuscar);
        this.add(btInsertar);
        this.add(btBorrar);
        this.add(btCambiar);
        this.add(btLimpiar);

        // Lo que se debe hacer cuando el usuario elija la opción "Salir" 
        salir.addActionListener(evt -> gestionaSalir(evt));
        
        // Eventos de botónes
        btBuscar.addActionListener(evt -> gestionaBuscar(evt));
        btInsertar.addActionListener(evt -> gestionaInsertar(evt));
        btBorrar.addActionListener(evt -> gestionaBorrar(evt));
        btCambiar.addActionListener(evt -> gestionaCambiar(evt));
        btLimpiar.addActionListener(evt -> gestionaLimpiar(evt));
        
        // Lo que se debe hacer cuando el usurio elija la "X" de la ventana para salir      
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
    
    // Gestiona opción de menú "Salir"
    public void gestionaSalir(java.awt.event.ActionEvent evt)
    {
        exit();
    }
    
    public void exit()
    {
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Aviso",JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
    }
    
    public void gestionaBuscar(java.awt.event.ActionEvent evt)
        {
            if(upc.getText().isBlank())
            {
		JOptionPane.showMessageDialog(this, "Para localizar un juego se requiere el UPC", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                VideoGame newGame = VideoGame.getJuegoFromDB(upc.getText(),prop); // Método estático para obtener un juego desde la BD 
		if(newGame != null) // Si hubo éxito
		{
                    upc.setText(newGame.getUpc());
                    descripcion.setText(newGame.getDescripcion());
                    desarrollador.setText(newGame.getDesarrollador());
                    imagen.setText(newGame.getImagenJuego());
                    precio.setText(String.valueOf(newGame.getPrecio()));
                    
                    switch (newGame.getPlataforma())
                          {
                            case "PlayStation" : plataforma.setSelectedIndex(0); break;
                            case "Xbox" : plataforma.setSelectedIndex(1); break;
                            case "Pc" : plataforma.setSelectedIndex(2); break;  
                          }
                    
                    switch (newGame.getClasificacion())
                          {
                            case "EVERYONE" : todos.setSelected(true); break;
                            case "EVERYONE +10" : todos2.setSelected(true); break;
                            case "TEEN" : adolescentes.setSelected(true); break;
                            case "MATURE +17" : maduros.setSelected(true); break;
                            case "ADULTS ONLY +18" : adultos.setSelected(true);  break;
                          }
                    
                     switch (newGame.getGenero())
                          {
                            case "Accion" : accion.setSelected(true); break;
                            case "Arcade" : arcade.setSelected(true); break;
                            case "Aventura": aventura.setSelected(true); break;  
                          }
                    
                    cuadroImagen.setIcon(new ImageIcon("img_rep/" + newGame.getImagenJuego() + ".JPG"));
                    cuadroImagen2.setIcon(new ImageIcon("img_class/" + newGame.getImagenClasificacion() + ".PNG"));
                    JOptionPane.showMessageDialog(rootPane, newGame.getData(), "Resultados", JOptionPane.INFORMATION_MESSAGE);    
		}
                else JOptionPane.showMessageDialog(this, "El Juego con el UCP indicado no fue localizado", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        public void gestionaCambiar(java.awt.event.ActionEvent evt)
        {
            if(upc.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Para localizar el juego que se va \na actualizar se requiere el UPC", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                
                if(!invalido()) // Se intenta realizar el UPDATE solo si no hay error de captura
                {
                    VideoGame newGame = VideoGame.getJuegoFromDB(upc.getText(),prop); // Método estático para obtener un libro desde la BD 
                    if(newGame != null)
                    {
                        newGame.setUpc (upc.getText()); 
                        newGame.setDescripcion (descripcion.getText()); 
                        newGame.setDesarrollador (desarrollador.getText()); 
                        newGame.setPlataforma ((String) plataforma.getSelectedItem());
                        newGame.setClasificacion (clasificacion.getSelection().getActionCommand());
                        newGame.setImagenJuego (imagen.getText());
                        newGame.setPrecio (Double.parseDouble(precio.getText())); 

                        if(accion.isSelected()) newGame.setGenero ("" + accion.getActionCommand() + " ");
                        if(arcade.isSelected()) newGame.setGenero ("" + arcade.getActionCommand() + " ");
                        if(aventura.isSelected())  newGame.setGenero ("" + aventura.getActionCommand() + " "); 

                        if(newGame.cambiar(prop)) // Si hubo éxito
                            JOptionPane.showMessageDialog(this, "Registro actualizado: " + upc.getText(), "Aviso!",JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(this, "Acción no realizada!!","Aviso!",JOptionPane.ERROR_MESSAGE);
                    }
                    else JOptionPane.showMessageDialog(this, "El juego con el UPC indicado no fue localizado", "Aviso!", JOptionPane.ERROR_MESSAGE);                    
                } 
                else JOptionPane.showMessageDialog(this, mensajeError, "Aviso!", JOptionPane.ERROR_MESSAGE);                
	    }
                                       
        }
        
        public void gestionaInsertar(java.awt.event.ActionEvent evt)
        {
            if(!invalido()) // Se intenta realizar el INSERT solo si no hay error de captura
            {               
               // Primero investigamos si no hay otro registro con el mismo ISBN
                VideoGame newGame = VideoGame.getJuegoFromDB(upc.getText(),prop);
               
                if(newGame == null) // Solo si el UPC no está registrado 
                {                        
                    // Adquirimos los datos de la vista              
                    newGame = new VideoGame();
                    newGame.setUpc (upc.getText()); 
                    newGame.setDescripcion (descripcion.getText()); 
                    newGame.setDesarrollador (desarrollador.getText()); 
                    newGame.setPlataforma ((String) plataforma.getSelectedItem());
                    newGame.setClasificacion (clasificacion.getSelection().getActionCommand());
                    newGame.setImagenJuego (imagen.getText());
                    newGame.setPrecio (Double.parseDouble(precio.getText())); 

                    if(accion.isSelected()) newGame.setGenero ("" + accion.getActionCommand() + " ");
                    if(arcade.isSelected()) newGame.setGenero ("" + arcade.getActionCommand() + " ");
                    if(aventura.isSelected())  newGame.setGenero ("" + aventura.getActionCommand() + " "); 
                
                    // Tratamos de ejecutar el alta
                                
                    if(newGame.alta(prop)) // Si la alta fue exitosa
                        JOptionPane.showMessageDialog(this, "Registro agregado: " + upc.getText(), "Aviso!",JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(this, "Acción no realizada!!","Aviso!",JOptionPane.ERROR_MESSAGE);                           
                }
                else JOptionPane.showMessageDialog(this, "El UPC ya está registrado", "Aviso!", JOptionPane.ERROR_MESSAGE); 
            } 
            else JOptionPane.showMessageDialog(this, mensajeError, "Aviso!", JOptionPane.ERROR_MESSAGE);          
        }
        
        public void gestionaBorrar(java.awt.event.ActionEvent evt)
        {
            if(upc.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Para localizar el juego que se va \na eliminar se requiere el UPC", "Aviso!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                // Solicitamos confirmación     
                int respuesta = JOptionPane.showConfirmDialog(this, "Desea borrar este registro?", "Atención!!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
                if(respuesta==JOptionPane.YES_OPTION) // Si el usuario confirma
                {

                    VideoGame newGame = VideoGame.getJuegoFromDB(upc.getText(),prop); // Trata de recuperar el juego de la BD
                    
                    if(newGame != null) // Si lo encuentra
                    {
                        // Intenta eliminar el registro
                        if(newGame.borrar(prop)) // Si hubo éxito
                        {   
                            JOptionPane.showMessageDialog(this, "Registro eliminado: " + upc.getText(), "Aviso!",JOptionPane.WARNING_MESSAGE);
                            limpiarCampos();
                        }    
                        else JOptionPane.showMessageDialog(this, "Acción no realizada!!","Aviso!",JOptionPane.ERROR_MESSAGE);
                    }
                    else JOptionPane.showMessageDialog(this, "El juego con el UPC indicado no fue localizado", "Aviso!", JOptionPane.ERROR_MESSAGE);            
		}
            }
            
        }
    
    public void gestionaLimpiar(java.awt.event.ActionEvent evt)
    {
       limpiarCampos();
    } 
    
    public void limpiarCampos()
    {
       upc.setText("");
       descripcion.setText("");
       desarrollador.setText("");
       imagen.setText("");
       precio.setText("");
       
       plataforma.setSelectedIndex(0);
       
       adultos.setSelected(true);
       accion.setSelected(false);
       arcade.setSelected(false);
       aventura.setSelected(false);
       
       cuadroImagen.setBounds(380,30,200,200);
       cuadroImagen2.setBounds(50,260,100,110);
       cuadroImagen.setIcon(null);
       cuadroImagen2.setIcon(null);
    } 
    
    // Validación de datos
        private boolean invalido()
        {
            boolean hayError = false;
            mensajeError = "";
            
            if(upc.getText().isBlank())
            {
                hayError = true;
                mensajeError = mensajeError.concat("No debe dejar el UPC en blanco\n");
            }
            
            if(descripcion.getText().isBlank())
            {
                        hayError = true;
                        mensajeError = mensajeError.concat("No debe dejar la descripcion en blanco\n");
            }
            
            if(desarrollador.getText().isBlank())
            {
                        hayError = true;
                        mensajeError = mensajeError.concat("No debe dejar el desarrolador en blanco\n");
            }
            
            if(accion.isSelected() && (arcade.isSelected() || aventura.isSelected()))
            {
                        hayError = true;
                        mensajeError = mensajeError.concat("No puede marcar dos generos \n");
            }
            
            if(precio.getText().isBlank())
            {
                        hayError = true;
                        mensajeError = mensajeError.concat("No debe dejar el precio en blanco\n");
            }
            
            return hayError;
        }
}

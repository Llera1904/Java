/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameplanet;

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
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author leoll
 */
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
    private final JButton btProcesar = new JButton("Procesar");
    private final JButton btRestablecer  = new JButton("Restablecer");
    
    // Cajas de texto
    private final JTextField  upc = new JTextField();
    private final JTextField  descripcion= new JTextField();
    private final JTextField  desarrollador = new JTextField();
    private final JTextField  precio = new JTextField();
    
    // Variables auxiliares
    File archivoImagen;
    
    public Vista() // Constructor
    {
        this.setTitle("GamePlanet");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,640,530);
        
        initComponents();
  
        this.setVisible(true);
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
        et8.setBounds(380,240,100,20);  
        
        upc.setBounds(210,30,150,20);
        descripcion.setBounds(210,70,150,20);
        desarrollador.setBounds(210,110,150,20);
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
        
        btOpenFile.setBounds(530,240,50,50);
       
        btProcesar.setBounds(100,410,120,30);
        btRestablecer.setBounds(270,410,120,30);
         
        // Características de los componentes
        btOpenFile.setToolTipText("Abrir archivo desde disco");
        btOpenFile.setIcon(new ImageIcon("img_app/open.png"));
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
       
        this.add(btOpenFile);
        this.add(cuadroImagen);
        this.add(cuadroImagen2);
        this.add(btProcesar);
        this.add(btRestablecer);

        // Lo que se debe hacer cuando el usuario elija la opción "Salir" 
        salir.addActionListener(evt -> gestionaSalir(evt));
        
        // Eventos de botónes
        btOpenFile.addActionListener(evt -> gestionaOpenFile(evt));
        btProcesar.addActionListener(evt -> gestionaProcesar(evt));
        btRestablecer.addActionListener(evt -> gestionaRestablecer(evt));
        
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
    
    public void gestionaOpenFile(java.awt.event.ActionEvent evt)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"/img_rep")); // Abre directo en esa direccion
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG", "jpg", "gif", "png"); // Abre esas extens¿iones
        fileChooser.setFileFilter(filter);
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION)
        {
             archivoImagen = fileChooser.getSelectedFile();
             ImageIcon imagenCargada = new ImageIcon(archivoImagen.getAbsolutePath());
             double w = imagenCargada.getIconWidth();
             double h = imagenCargada.getIconHeight();
             
             // Redimensionar la imagen
             if(h > 200 ||  w > 200)
             {
                 double r;
                 if( h > w)
                    r = 200.0/h;
                 else
                    r = 200.0/w;
                 w = w*r;
                 h = h*r;
                 Image imagenOriginal = imagenCargada.getImage();
                 Image imagenRedimensionada = imagenOriginal.getScaledInstance((int)w, (int)h, java.awt.Image.SCALE_SMOOTH);
                 imagenCargada = new ImageIcon(imagenRedimensionada);
                 
            }         
            cuadroImagen.setBounds(380,30,imagenCargada.getIconWidth(), imagenCargada.getIconHeight());
            cuadroImagen.setIcon(imagenCargada); 
        }
    }
        
    public void gestionaProcesar(java.awt.event.ActionEvent evt)
    {       
       String sUpc = upc.getText(); 
       String sDescripcion = descripcion.getText(); 
       String sDesarrollador = desarrollador.getText(); 
       String sPrecio = precio.getText(); 
        
       String sPlataforma = (String) plataforma.getSelectedItem();
       String sClasificacion = clasificacion.getSelection().getActionCommand();
       String sGenero = "";
       String nombreArchivoImagen = "no hay";
       
       if (archivoImagen!=null) nombreArchivoImagen = archivoImagen.getName();
       
       if(accion.isSelected()) sGenero+= accion.getActionCommand() + " ";
       if(arcade.isSelected()) sGenero+= arcade.getActionCommand() + " ";
       if(aventura.isSelected()) sGenero+= aventura.getActionCommand() + " ";
       
       VideoGame juego = new VideoGame(sUpc, sDescripcion, sDesarrollador, sPlataforma, sClasificacion, sGenero, sPrecio);
       
       /*String resultados = "";
       resultados = resultados.concat("\nPlataforma: " + sPlataforma);
       resultados = resultados.concat("\nGenero: " + sGenero);
       resultados = resultados.concat("\nClasificacion: " + sClasificacion);
       resultados = resultados.concat("\nImagen: " + nombreArchivoImagen);*/
       
       cuadroImagen2.setIcon(new ImageIcon("img_class/" + juego.getClasificacion() + ".PNG"));
       JOptionPane.showMessageDialog(rootPane, juego.getData(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void gestionaRestablecer(java.awt.event.ActionEvent evt)
    {
       upc.setText("");
       descripcion.setText("");
       desarrollador.setText("");
       precio.setText("");
       plataforma.setSelectedIndex(0);
       adultos.setSelected(true);
       accion.setSelected(false);
       arcade.setSelected(false);
       aventura.setSelected(false);
       archivoImagen = null; 
       cuadroImagen.setBounds(380,30,200,200);
       cuadroImagen2.setBounds(50,260,100,110);
       cuadroImagen.setIcon(null);
       cuadroImagen2.setIcon(null);
    } 
}

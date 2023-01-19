/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guiplus;

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


/**
 *
 * @author macario
 */
public class Vista extends JFrame
{

    private final JLabel cuadroImagen = new JLabel("Imagen");
    
    // Lista desplegable
    private final JComboBox delegacion = new JComboBox();
    
    // Casillas de verificación
    private final JCheckBox ingles = new JCheckBox("Inglés");
    private final JCheckBox frances = new JCheckBox("Francés");
   
    // Radio Botone
    private final ButtonGroup estadoCivil = new ButtonGroup();
    private final JRadioButton soltero = new JRadioButton("Soltero");
    private final JRadioButton casado = new JRadioButton("Casado");
    private final JRadioButton divorciado = new JRadioButton("Divorciado");
   
    // Botones de acción
    private final JButton btOpenFile = new JButton();
    private final JButton btProcesar = new JButton("Procesar");
    private final JButton btRestablecer  = new JButton("Restablecer");
     
    // Variables auxiliares
    File archivoImagen;
    
    public Vista() // Constructor
    {
        this.setTitle("Componentes SWING");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,500,480);
        
        initComponents();
  
        this.setVisible(true);
    }
    
    public void initComponents()
    {
        // Etiquetas
        
        JLabel et1 = new JLabel("Delegación:");
        JLabel et2 = new JLabel("Idiomas extranjeros:");
        JLabel et3 = new JLabel("Estado civil:");
        JLabel et4 = new JLabel("Imagen: ");

        // Diseña menú
        JMenuBar barraMenus = new JMenuBar();
	JMenu archivo 	  = new JMenu("Archivo");
	JMenuItem salir   = new JMenuItem("Salir");
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        archivo.add(salir);

        // Elementos del ComboBox delegacion
        
        delegacion.addItem("Azcapotzalco");
        delegacion.addItem("Benito Juárez");
        delegacion.addItem("Cuauhtemoc");
        delegacion.setSelectedIndex(1); // Selecciona por defecto
        
        // Radio Botones
        
        soltero.setActionCommand("Single");
        casado.setActionCommand("Married");
        divorciado.setActionCommand("Divorced");        
        estadoCivil.add(soltero);
        estadoCivil.add(casado);
        estadoCivil.add(divorciado);
        soltero.setSelected(true); // Selecciona por defecto        
       
        // Casillas de Verificación
        ingles.setActionCommand("001");
        frances.setActionCommand("002");
        
        
        // Tamaño y posición
        this.setLayout(null);
        et1.setBounds(50,30,150,20); 
        delegacion.setBounds(210,30,150,20);
        et2.setBounds(50,60,150,20); 
        ingles.setBounds(210,60,80,20); 
        frances.setBounds(290,60,80,20);
        et3.setBounds(50,90,150,20); 
        soltero.setBounds(210,90,100,20); 
        casado.setBounds(210,110,100,20); 
        divorciado.setBounds(210,130,100,20); 
        et4.setBounds(50,180,150,20);     
        
        btOpenFile.setBounds(210,160,50,50);
        cuadroImagen.setBounds(270,160,200,200);
        btProcesar.setBounds(100,370,120,30);
        btRestablecer.setBounds(270,370,120,30);
         
        // Características de los componentes
        btOpenFile.setToolTipText("Abrir archivo desde disco");
        btOpenFile.setIcon(new ImageIcon("img_app/open.png"));
        cuadroImagen.setBorder(BorderFactory.createLineBorder(Color.black));
        cuadroImagen.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Agrega Componentes
        
        this.add(et1); 
        this.add(delegacion);
        this.add(et2); 
        this.add(ingles); 
        this.add(frances);
        this.add(et3); 
        this.add(soltero);
        this.add(casado);
        this.add(divorciado);
        this.add(et4);
        this.add(btOpenFile);
        this.add(cuadroImagen);
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
            cuadroImagen.setBounds(270,160,imagenCargada.getIconWidth(), imagenCargada.getIconHeight());
            cuadroImagen.setIcon(imagenCargada);
            
        }
    }
        
    public void gestionaProcesar(java.awt.event.ActionEvent evt)
    {
       String sDelegacion = (String) delegacion.getSelectedItem();
       String sIdiomas="";
       String sEstadoCivil=estadoCivil.getSelection().getActionCommand();
       String nombreArchivoImagen="no hay";
       if (archivoImagen!=null) nombreArchivoImagen = archivoImagen.getName();
       
       if(ingles.isSelected()) sIdiomas+= ingles.getActionCommand()+" ";
       if(frances.isSelected()) sIdiomas+= frances.getActionCommand()+" ";
       
       String resultados = "";
       resultados = resultados.concat("\nDelegción: " + sDelegacion);
       resultados = resultados.concat("\nIdiomas: " + sIdiomas);
       resultados = resultados.concat("\nEstado Civil : " + sEstadoCivil);
       resultados = resultados.concat("\nImagen: " + nombreArchivoImagen);
       
       JOptionPane.showMessageDialog(rootPane, resultados, "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void gestionaRestablecer(java.awt.event.ActionEvent evt)
    {
       delegacion.setSelectedIndex(1);
       ingles.setSelected(false);
       frances.setSelected(false);
       soltero.setSelected(true);
       archivoImagen = null;       
       cuadroImagen.setBounds(270,160,200,200);
       cuadroImagen.setIcon(null);
    }
}

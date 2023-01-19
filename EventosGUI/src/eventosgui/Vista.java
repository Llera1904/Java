package eventosgui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macario
 */
public class Vista extends JFrame
{
    private final JComboBox     personajes        = new JComboBox();
    private final JLabel        imagenPersonaje   = new JLabel();   
    private final JCheckBox     indicadorVisible  = new JCheckBox("Visible");
    private final ButtonGroup   color             = new ButtonGroup();
    private final JRadioButton  blanco            = new JRadioButton("Blanco");
    private final JRadioButton  gris              = new JRadioButton("Gris");
    
 
    public Vista() // Constructor
    {
        this.setTitle("GUI Sample");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,500,480);
        initComponents();
    }
    
    public void initComponents()
    {
        JLabel logo = new JLabel();   
        
        //Etiquetas
        JLabel et0 = new JLabel("Personaje");
        JLabel et1 = new JLabel("Color de fondo:");
        
        // Diseña menú
        JMenuBar barraMenus = new JMenuBar();
	JMenu archivo 	  = new JMenu("File");
	JMenuItem salir   = new JMenuItem("Exit");
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        archivo.add(salir);

        // Combo Box
        personajes.addItem("homero");
        personajes.addItem("marge");
        personajes.addItem("bart");
        personajes.addItem("lisa");
        personajes.addItem("maggie");
                
        // ButtonGroup
        color.add(gris);
        color.add(blanco);
        
        
        // Posicionamiento
        logo.setBounds(150,10,200,80);
        et0.setBounds(20,100,100,30);
        et1.setBounds(20,300,100,30);
    
        personajes.setBounds(120,100,100,30);
        imagenPersonaje.setBounds(250,100,200,200);
        indicadorVisible.setBounds(120,150,100,30);
        gris.setBounds(120,300,100,30);
        blanco.setBounds(220,300,100,30);
        
        // Agrega componentes
        this.setLayout(null);
        this.add(logo);        
        this.add(et0);
        this.add(et1);
        this.add(personajes);
        this.add(imagenPersonaje);
        this.add(indicadorVisible);
        this.add(gris);
        this.add(blanco);
        
        ImageIcon iconLogo = new ImageIcon("img/logo.png");
        Image imagenLogo = iconLogo.getImage();
        Image newImage = imagenLogo.getScaledInstance(200, 75, java.awt.Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(newImage));
               
        // Lo que se debe hacer cuando el usuario elija la opción "Salir" 
        salir.addActionListener(evt -> gestionSalir(evt));
        personajes.addItemListener(evt -> gestionPersonajes(evt));
        indicadorVisible.addItemListener(evt ->  gestionVisible(evt));
        gris.addItemListener(evt -> gestionColor(evt));
        blanco.addItemListener(evt -> gestionColor(evt));
        
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
        
        // Condiciones iniciales
        
        personajes.setSelectedIndex(1);
        personajes.setSelectedIndex(0);
        gris.setSelected(true);
        indicadorVisible.setSelected(true);
        
    }
    
    public void gestionSalir(java.awt.event.ActionEvent evt)
    {
        exit();
    }
    
    public void exit()
    {
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Aviso",JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
    }
    
    public void gestionPersonajes(java.awt.event.ItemEvent evt)
    {

        String personaje = (String) personajes.getSelectedItem();
        
        ImageIcon imagenCargada = new ImageIcon("img/"+personaje+".jpg");
        
        double w = imagenCargada.getIconWidth();
        double h = imagenCargada.getIconHeight();
             
        // Redimensionar la imagen
        if(h > 200 ||  w > 200)
        {
                 double r;
                 if( h > w)
                    r = 200f/h;
                 else
                    r = 200f/w;
                 w = w*r;
                 h = h*r;
                 Image imagenOriginal = imagenCargada.getImage();
                 Image imagenRedimensionada = imagenOriginal.getScaledInstance((int)w, (int)h, java.awt.Image.SCALE_SMOOTH);
                 imagenCargada = new ImageIcon(imagenRedimensionada);
                 System.out.println(imagenCargada.getIconWidth()+" "+imagenCargada.getIconHeight());
                 
        } 
        
        imagenPersonaje.setBounds(250,100,imagenCargada.getIconWidth(), imagenCargada.getIconHeight());
        imagenPersonaje.setIcon(imagenCargada);        
    }
    
    public void gestionVisible(java.awt.event.ItemEvent evt)
    {
        imagenPersonaje.setVisible(indicadorVisible.isSelected());
    }
    
    public void gestionColor(java.awt.event.ItemEvent evt)
    {
        Object obj = evt.getSource();
        
        if(obj == blanco) 
        {
            this.getContentPane().setBackground(Color.white);
            indicadorVisible.setBackground(Color.white);
            gris.setBackground(Color.white);
            blanco.setBackground(Color.white);
        }
        if(obj == gris) 
        {
            this.getContentPane().setBackground(Color.lightGray);
            indicadorVisible.setBackground(Color.lightGray);
            gris.setBackground(Color.lightGray);
            blanco.setBackground(Color.lightGray);            
        }         
    }
   
}

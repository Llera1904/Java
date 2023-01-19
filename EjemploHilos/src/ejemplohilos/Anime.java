/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplohilos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



/**
 *
 * @author Macario
 */
public class Anime extends JFrame 
{
	private JMenuBar menuPrincipal   = new JMenuBar();
	private JMenu file               = new JMenu("File");
	private JMenuItem mover          = new JMenuItem("Move");
	private JMenuItem congelar       = new JMenuItem("Pause");
	private JMenuItem exit           = new JMenuItem("Exit");

	private Parametros p = new Parametros();

	// Etiquetas

	private JLabel fantasmaRojo  = new JLabel("Rojo");
        private JLabel fantasmaAzul  = new JLabel("Azul");

	private Animador fantasmaAnimado1, fantasmaAnimado2; // Hilos para manipular los sprites

	public Anime()
	{
		this.setTitle("Threads");

		// Se obtiene un referecia al contenedor del JFrame

		this.setLayout(null);
		JPanel contenedor = (JPanel) this.getContentPane();
		contenedor.setBackground(Color.black);

		// Diseño de menus

		this.setJMenuBar(menuPrincipal);

		menuPrincipal.add(file);
                file.add(congelar);
		file.add(mover);
		file.add(exit);

		// Establece posición y tamaño de componentes

		this.setBounds(0,0,640,480);
		fantasmaRojo.setBounds(20,20,128,128);
                fantasmaAzul.setBounds(400,20,128,128);
		// Se agregan los Componentes visibles al contenedor

		add(fantasmaRojo);
                add(fantasmaAzul);

		// Inicia registro de Listener's
		// El Listenes se encarga de gestionar eventos

                exit.addActionListener(evt -> gestionaSalir(evt));
		mover.addActionListener(evt -> gestionaMover(evt));
                congelar.addActionListener(evt -> gestionaCongelar(evt));
		// Muestra el JFrame

		this.setVisible(true);

		// Codigo para gestionar el evento: "el usuario clickea en la X de la ventana"
		// Uso de una clase interna

		class MyWindowAdapter extends WindowAdapter
		{
			public void windowClosing(WindowEvent eventObject)
			{
				despedida();
			}
		}

		this.addWindowListener(new MyWindowAdapter());	// Se agrega el listener de ventana como instancia del Adaptador
		fantasmaAnimado1 = new Animador(fantasmaRojo, p, new ImageIcon("imagenes/rojo.gif"), contenedor.getWidth(), contenedor.getHeight());
		fantasmaAnimado2 = new Animador(fantasmaAzul, p, new ImageIcon("imagenes/azul.gif"), contenedor.getWidth(), contenedor.getHeight());
		fantasmaAnimado1.start();
                fantasmaAnimado2.start();
	}


        public void gestionaSalir(ActionEvent eventObject)
        {
            despedida();
        }

        public void gestionaMover(ActionEvent eventObject)
        {
            p.startMoving();
        }  
        
        public void gestionaCongelar(ActionEvent eventObject)
        {
            p.stopMoving();
        }  


	public void despedida()
	{
			String mensaje = "Gracias por utilizar este programa... suerte!!!";
			javax.swing.JOptionPane.showConfirmDialog(this,mensaje,"Swing Aplicacion",JOptionPane.DEFAULT_OPTION ,JOptionPane.INFORMATION_MESSAGE );
			System.exit(0);

	}
}

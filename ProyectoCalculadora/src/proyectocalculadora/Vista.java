/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 
 */
public class Vista extends JFrame 
{
        // El objeto calculadora es el que realmente realiza las operaciones
    	private final Calculadora calculator = new Calculadora();
        private final JTextField display = new JTextField();
        
        private final JButton inverso = new JButton("-1");
	private final JButton cuadrado = new JButton("X2");
	private final JButton raizCuadrada = new JButton("R2");
	private final JButton raizCubica = new JButton("R3");
	private final JButton sin = new JButton("sin");
	private final JButton cos = new JButton("cos");
         private final JButton tan = new JButton("tan");
	private final JButton e = new JButton("e");

        private final JButton b0 = new JButton("0");
	private final JButton b1 = new JButton("1");
	private final JButton b2 = new JButton("2");
	private final JButton b3 = new JButton("3");
	private final JButton b4 = new JButton("4");
	private final JButton b5 = new JButton("5");
	private final JButton b6 = new JButton("6");
	private final JButton b7 = new JButton("7");
	private final JButton b8 = new JButton("8");
	private final JButton b9 = new JButton("9");
        
	private final JButton mas = new JButton("+");
	private final JButton menos = new JButton("-");
        private final JButton por = new JButton("*");
        private final JButton entre = new JButton("/");
	private final JButton igual = new JButton("=");
        private final JButton pI = new JButton("TT");
        private final JButton cE = new JButton("CE");
        private final JButton c = new JButton("C");
        
        // Bandera lógica para para indicar el inicio de una nueva cifra
        private boolean nuevo=true;

	public Vista()
	{
		initComponents();
		this.setTitle("Calculadora");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.setBounds(100,100,620,305);

		this.setVisible(true);

	}

	public void initComponents()
	{
            // Diseña el menu
            JMenuBar barraMenus = new JMenuBar();
            JMenu archivo       = new JMenu("Archivo");
            JMenuItem salir     = new JMenuItem("Salir");
            this.setJMenuBar(barraMenus);
            
            barraMenus.add(archivo);
            archivo.add(salir);

		// Al desabilitar el LayoutManager, el programador tiene
		// la responsabilidad de situar los componentes
            this.setLayout(null); // Se deshabilita el Gestor de Distribución
            display.setBounds(10,5,590,40);
            
            //10, 85, 160, 235, 310, 385, 460, 435: Coordenadas X 
            //50, 100, 150, 200: Cordenadas Y
            // 65x40: Tamaño boton
            
            inverso.setBounds(10,50,65,40);
            sin.setBounds(10,100,65,40);
            raizCubica.setBounds(10,150,65,40);
            
            cuadrado.setBounds(85,50,65,40);
            cos.setBounds(85,100,65,40);
            e.setBounds(85,150,65,40);
            
            raizCuadrada.setBounds(160,50,65,40);
            tan.setBounds(160,100,65,40);
            
            b1.setBounds(235,50,65,40);
            b4.setBounds(235,100,65,40);
            b7.setBounds(235,150,65,40);
            
            b2.setBounds(310,50,65,40);
            b5.setBounds(310,100,65,40);
            b8.setBounds(310,150,65,40);
            b0.setBounds(310,200,65,40);
            
            b3.setBounds(385,50,65,40);
            b6.setBounds(385,100,65,40);
            b9.setBounds(385,150,65,40);
            
            cE.setBounds(460,50,65,40);
            por.setBounds(460,100,65,40);
            mas.setBounds(460,150,65,40);
            pI.setBounds(460,200,65,40);
            
            c.setBounds(535,50,65,40);
            entre.setBounds(535,100,65,40);
            menos.setBounds(535,150,65,40);
            igual.setBounds(535,200,65,40);
            
            display.setBackground(Color.black);
            display.setForeground(Color.orange);
            display.setFont(new Font("Consolas",Font.BOLD, 26));
            display.setHorizontalAlignment(JTextField.RIGHT);
            display.setEditable(false);

            // Agrega los elementos al JFrame
            this.add(display);
            
            this.add(b1);
            this.add(b2);
            this.add(b3);
            this.add(b4);
            this.add(b5);
            this.add(b6);
            this.add(b7);
            this.add(b8);
            this.add(b9);
            this.add(b0);
            
            this.add(mas);
            this.add(menos);
            this.add(por);
            this.add(entre);
            this.add(igual);
            this.add(pI);
            this.add(cE);
            this.add(c);
            
            this.add(inverso);
            this.add(cuadrado);
            this.add(raizCuadrada);
            this.add(raizCubica);
            this.add(sin);
            this.add(cos);
            this.add(tan);
            this.add(e);

            // Para la gestión de los eventos de Calculadora
            
            b0.addActionListener(evt -> gestionarBotones(evt));
            b1.addActionListener(evt -> gestionarBotones(evt));
            b2.addActionListener(evt -> gestionarBotones(evt));
            b3.addActionListener(evt -> gestionarBotones(evt));
            b4.addActionListener(evt -> gestionarBotones(evt));         
            b5.addActionListener(evt -> gestionarBotones(evt));
            b6.addActionListener(evt -> gestionarBotones(evt));
            b7.addActionListener(evt -> gestionarBotones(evt));
            b8.addActionListener(evt -> gestionarBotones(evt));
            b9.addActionListener(evt -> gestionarBotones(evt));
            mas.addActionListener(evt -> gestionarBotones(evt));
            menos.addActionListener(evt -> gestionarBotones(evt));
            por.addActionListener(evt -> gestionarBotones(evt));
            entre.addActionListener(evt -> gestionarBotones(evt));
            igual.addActionListener(evt -> gestionarBotones(evt));
            c.addActionListener(evt -> gestionarBotones(evt));
           
            // Al ser una tecla con dos símbolos en la cara le asignamos
            // un Listener diferente
                
            cE.addActionListener(evt -> gestionarCE(evt));
            
            pI.addActionListener(evt -> gestionarConstante(evt));
            e.addActionListener(evt -> gestionarConstante(evt)); 
            
            sin.addActionListener(evt -> gestionarTrigonometricas(evt));
            cos.addActionListener(evt -> gestionarTrigonometricas(evt));
            tan.addActionListener(evt -> gestionarTrigonometricas(evt));
            
            inverso.addActionListener(evt -> gestionarInverso(evt));
             
            cuadrado.addActionListener(evt -> gestionarCuadrado(evt));
              
            raizCuadrada.addActionListener(evt -> gestionarRaiz2(evt));
               
            raizCubica.addActionListener(evt -> gestionarRaiz3(evt));
            
            // Gestión de menú
            salir.addActionListener(evt -> gestionarSalir(evt));
        
            // Salida 
            class MyWindowAdapter extends WindowAdapter
            {
                @Override
                public void windowClosing (WindowEvent e)
		{
                    exit();
		}
            }
            addWindowListener(new MyWindowAdapter());

	}
               
        // Métodos para gestión de eventos
        
        public void gestionarSalir (java.awt.event.ActionEvent evt)
        {
            exit();
        }
        
        public void exit()
        {
            int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Federación deportiva",JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) System.exit(0);
        }

        // Gestión para botones numéricos y símbolos de operación
        public void gestionarBotones (java.awt.event.ActionEvent evt)
        {

            String textoBoton = evt.getActionCommand();

            // Cada botón tiene un simbolo numérico o operador en la cara del botón
            // Se obtiene con charAt
           
            char simbolo = textoBoton.charAt(0);
                
            if ((simbolo >= '0' && simbolo <= '9') || simbolo == '.') // En caso de número
              {
                if (nuevo) display.setText (""); // Si es una nueva cifra se borra el diaplay
                display.setText (display.getText() + simbolo);
		nuevo = false; // Se pone en falso cuando se pone el primer dígito de una cifra
              }  
            else if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/' || simbolo == '=') // En caso de operador
                   {
                     double numero = Double.parseDouble(display.getText());

		     calculator.operacion (numero,simbolo);         // Invoca la funcionalidad de la calculadora
		     display.setText ("" + calculator.getMemoria());  // Obtiene el estado de la memoria de la calculadora
		     nuevo = true;
		
                   }
            else if (simbolo == 'C') 
                   {    
                     calculator.clearMemory();
                     display.setText ("");
                   }
        }
            
        // Gestiona botón CE
        public void gestionarCE (java.awt.event.ActionEvent evt)
        {
            // Codigo para procesar CE
            display.setText ("");
            nuevo=true;
        } 
        
        public void gestionarConstante (java.awt.event.ActionEvent evt)
        {
            String textoBoton = evt.getActionCommand();
            char simbolo = textoBoton.charAt(0);
            
            if (simbolo == 'e') // En caso de número
              {
                if (nuevo) display.setText (""); // Si es una nueva cifra se borra el diaplay
                display.setText (display.getText() + Math.E);
		nuevo = false; // Se pone en falso cuando se pone el primer dígito de una cifra
              }
            else if (simbolo == 'T')
                   {
                     if (nuevo) display.setText (""); // Si es una nueva cifra se borra el diaplay
                     display.setText (display.getText() + Math.PI);
		     nuevo = false; // Se pone en falso cuando se pone el primer dígito de una cifra  
                   }
        } 
        
        public void gestionarTrigonometricas (java.awt.event.ActionEvent evt)
        {
          String textoBoton = evt.getActionCommand();
          char simbolo = textoBoton.charAt(0);  
            
          if (simbolo == 's'||simbolo == 'c'|| simbolo == 't') // En caso de operador
            {
		double numero = Double.parseDouble(display.getText());
                
		calculator.trigonometrica(numero, simbolo);         // Invoca la funcionalidad de la calculadora
		display.setText("" + calculator.getMemoria());  // Obtiene el estado de la memoria de la calculadora
		nuevo = true;
            }
        } 
        
        public void gestionarInverso (java.awt.event.ActionEvent evt)
        {
            double numero = Double.parseDouble(display.getText());
            
	    calculator.inverso(numero);
            display.setText("" + calculator.getMemoria());
            nuevo = true;
        } 
         
        public void gestionarCuadrado (java.awt.event.ActionEvent evt)
        {
            double numero = Double.parseDouble(display.getText());
            
	    calculator.cuadrado(numero);
            display.setText("" + calculator.getMemoria());
            nuevo=true;
        } 
         
        public void gestionarRaiz2 (java.awt.event.ActionEvent evt)
        {
            double numero = Double.parseDouble(display.getText());
            
	    calculator.raiz2(numero);
            display.setText("" + calculator.getMemoria());
            nuevo = true;
        } 
         
        public void gestionarRaiz3 (java.awt.event.ActionEvent evt)
        {
            double numero = Double.parseDouble(display.getText());
            
	    calculator.raiz3(numero);
            display.setText("" + calculator.getMemoria());
            nuevo = true;
        } 
}

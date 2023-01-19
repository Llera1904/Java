/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshop;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import org.json.JSONArray;



/**
 *
 * @author macario
 */
public class MainView extends JFrame
{
        
                            
	private final int puerto; 
	private final String ipServidor; 
        private String usuario;
    
        private final DataTable      dataTable  = new DataTable();
        private final JScrollPane    tablePanel = new JScrollPane(dataTable);
        private final JTabbedPane    panelModulos = new JTabbedPane();
        private final JPanel          panelCatalogo = new JPanel();
        private final JPanel          panelCRUD = new JPanel();
      
	private final JLabel  imagen    = new JLabel();
        
	public MainView(String ipServidor, int puerto, String usuario)
	{
                this.ipServidor = ipServidor;
                this.puerto = puerto;
                this.usuario = usuario;
		initComponents();
		this.setTitle("Librerias de Cristal");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(50,50,1000,350);	
                this.setVisible(true);
                
                
	}

	public void initComponents()
	{   
            // Paneles
            
            this.setLayout(null);
            panelCatalogo.setLayout(null);
            panelCRUD.setLayout(null);
            panelModulos.add("Catalogo de libros",panelCatalogo);
            if(usuario.equals("admin"))panelModulos.add("CRUD",panelCRUD);
            
            // Diseña el menu

            JMenuBar barraMenus = new JMenuBar();
            JMenu menuArchivo 	  = new JMenu("Archivo");
	    JMenuItem opSalir   = new JMenuItem("Salir");
            this.setJMenuBar(barraMenus);

            barraMenus.add(menuArchivo);
            menuArchivo.add(opSalir);
           
            // Componentes

            panelModulos.setBounds(5, 1, 970,250);
            tablePanel.setBounds(10,10,800,200);
	    imagen.setBounds(820,10,145,200);
            
            imagen.setBorder( new TitledBorder( "Portada" ) );
            tablePanel.setBorder(new TitledBorder( "Registros" ));
            dataTable.setFont(new Font("Arial Narrow",Font.PLAIN, 14));
            

            
            panelCatalogo.add(tablePanel);
            panelCatalogo.add(imagen);
            
            this.add(panelModulos);
            
            opSalir.addActionListener(evt -> gestionaSalir(evt));
            
            
            // Eventos de teclado sobre la tabla           
            dataTable.addKeyListener(new KeyAdapter()
            {
                @Override
                public void keyReleased(KeyEvent e) 
                {
                    muestraImagen();
                }      
            });
            
            // Eventos de ratón sobre la tabla
            dataTable.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mousePressed(MouseEvent e) 
                {
                    muestraImagen();
                }   
                
                public void mouseReleased(MouseEvent e) 
                {
                    muestraImagen();
                }   
                
            });
            
            class MyWindowAdapter extends WindowAdapter
            {
		public void windowClosing(WindowEvent e)
		{
			exit();
		}
            }
            addWindowListener(new MyWindowAdapter());
            cargarDatos(); // Carga los datos desde el servidor
            muestraImagen();
            
	}

        // Gestión de eventos
        
        public void gestionaSalir(java.awt.event.ActionEvent evt)
        {
            exit();
        }
    
        public void exit()
        {
            int respuesta = JOptionPane.showConfirmDialog(rootPane, "Seguro que desea cerrar?","Aviso",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
        }
       
        public void gestionaClick()
        {
            muestraImagen();
        }
        
        public void cargarDatos()
        {
                // Recupera propiedades
                
                try
                {
                    
                    Socket skCliente = new Socket( ipServidor , puerto ); // Crea un socket hacia el servidor

                    // Envia solicitud al servidor

                    OutputStream flujoSalida = skCliente.getOutputStream();
                    ObjectOutputStream salida = new ObjectOutputStream( flujoSalida );
                    JSONObject jsonEnviar = new JSONObject();
                    jsonEnviar.put("operacion","consultar");
                    jsonEnviar.put("dato", "nothing");
                    System.out.println(jsonEnviar.toString());
                    salida.writeObject(jsonEnviar.toString());
   
                    // Recupera la respuesta
                    
                    InputStream flujoEntrada = skCliente.getInputStream();
                    ObjectInputStream entrada = new ObjectInputStream( flujoEntrada );
                    String respuesta = (String) entrada.readObject();
                    skCliente.close();
                    JSONObject jsonRecibido = new JSONObject(respuesta);
                    String status = jsonRecibido.getString("status");
                                      
                    if(status.equals("200"))
                    {
                        
                        JSONArray todosLibros = jsonRecibido.getJSONArray("libros");
                        
                        // Investiga cuántos libros recuperó 
                        
                        int numLibros = todosLibros.length(); 
                        
                        if(numLibros > 0)
                        {
                            String[] header = {"ISBN","Título","Autor","Editorial","Precio","Imagen"};
                            String[][] records = new String[numLibros][6];
                            for(int i=0;i<numLibros;i++)    
                            {                                
                                JSONObject libroRecuperado = (JSONObject)todosLibros.get(i);
                                
                                records[i][0] = libroRecuperado.getString("isbn");
                                records[i][1] = libroRecuperado.getString("titulo");
                                records[i][2] = libroRecuperado.getString("autor");
                                records[i][3] = libroRecuperado.getString("editorial");
                                records[i][4] = String.format("$%.2f",libroRecuperado.getDouble("precio"));
                                records[i][5] = libroRecuperado.getString("imagen");    
                            }
                        
                            // Pone los datos en la Tabla
                        
                            DefaultTableModel tableModel = new DefaultTableModel(records, header);
                            dataTable.setModel(tableModel);
                            (dataTable).tableChanged(new TableModelEvent(tableModel));     
                            dataTable.setRowSelectionInterval(0, 0);
                        
                            //personaliza ancho de las columnas
                        
                            dataTable.getColumnModel().getColumn(0).setPreferredWidth(60);
                            dataTable.getColumnModel().getColumn(1).setPreferredWidth(300);
                            dataTable.getColumnModel().getColumn(2).setPreferredWidth(100);
                            dataTable.getColumnModel().getColumn(3).setPreferredWidth(100);
                            dataTable.getColumnModel().getColumn(4).setPreferredWidth(30);
                            dataTable.getColumnModel().getColumn(5).setPreferredWidth(40);
                        
                            // La columna de precio se justifica a la derecha
                            DefaultTableCellRenderer alignmentRight = new DefaultTableCellRenderer();
                            alignmentRight.setHorizontalAlignment(JLabel.RIGHT);
                            dataTable.getColumnModel().getColumn(4).setCellRenderer(alignmentRight);
                        
                            // La columna de imagen se justifica al centro
                            DefaultTableCellRenderer alignmentCenter = new DefaultTableCellRenderer();
                            alignmentCenter.setHorizontalAlignment(JLabel.CENTER);
                            dataTable.getColumnModel().getColumn(5).setCellRenderer(alignmentCenter);
                        }
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Error: " + status);
                    }
                    
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
        }
        
        public void muestraImagen()
        {
            int fila = dataTable.getSelectedRow();
            String nombreArchivoImagen = (String) dataTable.getValueAt(fila, 5);
            
            // Pide el archivo de imagen al servidor
            
            try
            {
                    
                Socket skCliente = new Socket( ipServidor , puerto ); // Crea un socket hacia el servidor

                // Envia solicitud al servidor

                OutputStream flujoSalida = skCliente.getOutputStream();
                ObjectOutputStream salida = new ObjectOutputStream( flujoSalida );
                JSONObject jsonEnviar = new JSONObject();
                jsonEnviar.put("operacion","imagen");
                jsonEnviar.put("dato", nombreArchivoImagen);
                
                System.out.println(jsonEnviar.toString());
                salida.writeObject(jsonEnviar.toString());
   
                // Recupera la respuesta
                    
                InputStream flujoEntrada = skCliente.getInputStream();
                ObjectInputStream entrada = new ObjectInputStream( flujoEntrada );
                ImageIcon respuesta = (ImageIcon) entrada.readObject();
                imagen.setIcon(respuesta);                
                skCliente.close();            
            }
            catch (Exception ex)
            {
                    ex.printStackTrace();
            }
        }
}

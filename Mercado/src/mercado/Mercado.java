/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado;

/**
 *
 * @author 
 */
public class Mercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Canasta bolsa = new Canasta(); // Crea una instancia de la clase Canasta
        
        bolsa.agregarProducto(new Producto("750300147594","Jamón Peñaranda F/Hierbas",127));  // Agrega un objeto creado de forma Anónima
        bolsa.agregarProducto(new Producto("750103047840","Pan Wonder Integral Granos",41));
        bolsa.agregarProducto(new Producto("750100310840","Mole Doña María Poblano ",33));
        bolsa.agregarProducto(new Producto("750043511592","Pasta Dental Oral-B encías",21.50f));
        bolsa.agregarProducto(new Producto("750220990019","Pasta Saboretti Paja Heno",35));
       
        bolsa.listaProductos();
        
        bolsa.muestraProducto("750300147594");
                
        bolsa.eliminarProducto("750300147594");
        bolsa.eliminarProducto("750220990019");
        bolsa.eliminarProducto("750220990019");
        bolsa.muestraProducto("750300147594");
        
        bolsa.listaProductos();
        
        bolsa.vaciarCanasta();
        bolsa.listaProductos();
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author
 */
public class Canasta 
{
    HashMap<String, Producto> productos = new HashMap();
    
    public void agregarProducto(Producto producto)
    {
        productos.put(producto.getSku(), producto);
        System.out.println("Se agregó el producto "+producto.getDescripcion());
    }
    
    public void eliminarProducto(String sku)
    {
        Producto p = productos.get(sku);
        if(p != null)
        {
            productos.remove(sku);
            System.out.println("Se eliminó el producto "+p.getDescripcion());
        }
        else
            System.out.println("Producto NO eliminao! El sku proporcionado no corresponde a un producto de la canasta");
    }
    
    public void muestraProducto(String sku)
    {
        Producto p = productos.get(sku);
        if(p!=null)
            p.mostrarse();
        else
          System.out.println("Producto NO encontrado! El sku proporcionado no corresponde a un producto de la canasta");  
    }
            
    public void listaProductos()
    {
        int n=0;
        float total = 0;
        if(productos.isEmpty())
           System.out.println("\nLa canasta no contiene productos\n\n");
        else
        {
            System.out.println("\nContenido de la canasta");
            System.out.println("==================================================================================");
            System.out.println("Np\tSKU\t        Descripcion\t\t               Precio");
            System.out.println("==================================================================================");
            for(Map.Entry <String, Producto> contenido : productos.entrySet()) // Recorrer 
            {
                Producto producto = contenido.getValue();
                total+=producto.getPrecio();
                n++;
                System.out.format("%d\t%s\t%s\t\t%.2f\n",n,producto.getSku(),producto.getDescripcion(),producto.getPrecio());
            }
            System.out.println("==================================================================================");
            System.out.format("El total es: $%.2f\n",total);
        }
    }
    
    public void vaciarCanasta()
    {
        productos.clear();
    }
}

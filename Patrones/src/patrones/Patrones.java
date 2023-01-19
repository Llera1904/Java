/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patrones;

/**
 *
 * @author macario
 */
public class Patrones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // CajaFuerte caja = new CajaFuerte(); // No se permite llamar al constructor
        
        CajaFuerte caja1 = CajaFuerte.getInstance();
        CajaFuerte caja2 = CajaFuerte.getInstance();
        
        caja1.mostrarContenido();
        caja1.depositar(100);
        caja2.mostrarContenido();
        caja2.retirar(50);
        caja2.mostrarContenido();
        caja1.retirar(100);
    }
    
}

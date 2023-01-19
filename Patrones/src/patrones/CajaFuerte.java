/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones;

/**
 *
 * @author macario
 */
public class CajaFuerte {
    
    private float dinero;
    private static CajaFuerte instancia;
    
    private CajaFuerte()
    {
        this.dinero = 0;
    }
    
    public static CajaFuerte getInstance()
    {
        if(instancia == null) // Se crea le instancia solo si no ha sido creada
        {
            instancia = new CajaFuerte();
        }        
        return instancia;
    }
    
    public void depositar(float monto)
    {
        this.dinero+=monto;
    }
    
    public void retirar(float monto)
    {
        if(monto <= dinero)
        {
            this.dinero-=monto;
        }
        else
           System.out.println("El retiro no procedió");
        
    }
    
    public void mostrarContenido()
    {
        System.out.format("Actualmente la caja contiene $%.2f\n", this.dinero);
    }
}

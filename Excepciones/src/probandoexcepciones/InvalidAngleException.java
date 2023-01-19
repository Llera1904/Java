/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandoexcepciones;

/**
 *
 * @author Macario
 */
public class InvalidAngleException extends Exception
{
    public InvalidAngleException(String message)
    {
    	super(message);
    }

    // La clase Exception tiene un atributo message
    // Al construir nuestra excepción debemos pasar
    // un valor de clase String al constructor de Exception
    // para inicializar el mensaje
}

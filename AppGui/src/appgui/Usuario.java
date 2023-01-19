/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appgui;

/**
 *
 * @author leoll
 */
public class Usuario {
    
    private String name;
    private String email;
    private String number;
    private String photo;
    private String password;
    
    public Usuario (String name, String email, String number, String photo, String password) 
    {
        this.name = name;
        this.email = email;
        this.number = number;
        this.photo = photo;
        this.password = password;
    }
    
    public String getName ()
    {
        return this.name;
    }
    
     public String getEmail ()
    {
        return this.email;
    }
     
    public String getNumber ()
    {
        return this.number;
    }
    
    public String getPhoto ()
    {
        return this.photo;
    }
    
    public String getPassword ()
    {
        return this.password;
    }
    
    
    public void setName (String name)
    {
        this.name = name;
    }
    
    public void setEmail (String email)
    {
        this.email = email;
    }
        
    public void setNumber (String number)
    {
        this.number = number;
    }
    
    public void setPhoto (String photo)
    {
        this.photo = photo;
    }
    
     public void setPassword (String password)
    {
        this.password = password;
    }
     
     
    public String getData()
    {
        String data = "\nDATOS DEL USUARIO\n";
        data = data.concat("\nName : " + this.name);
        data = data.concat("\nEmail: " + this.email);
        data = data.concat("\nNumber : " + this.number);
        data = data.concat("\nPassword : " + this.password);
        return data;
    }
}

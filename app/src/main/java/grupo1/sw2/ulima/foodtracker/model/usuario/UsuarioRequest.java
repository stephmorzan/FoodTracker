/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo1.sw2.ulima.foodtracker.model.usuario;


import java.io.Serializable;

public class UsuarioRequest implements Serializable{

    private String nombre;
    private String email;
    private String usuario;
    private String contraseña;
    
    public UsuarioRequest() {
    
    }

    public UsuarioRequest(String nombre, String email, String usuario, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

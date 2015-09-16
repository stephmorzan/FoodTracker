package grupo1.sw2.ulima.foodtracker.model.usuario;


import java.io.Serializable;

public class UsuarioRequest implements Serializable{

    private String nombre;
    private String email;
    private String usuario;
    private String pass;
    
    public UsuarioRequest() {
    
    }

    public UsuarioRequest(String nombre, String email, String usuario, String pass) {
        this.nombre = nombre;
        this.email = email;
        this.usuario = usuario;
        this.pass = pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

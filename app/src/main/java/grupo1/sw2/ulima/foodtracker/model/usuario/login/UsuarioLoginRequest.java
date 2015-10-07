package grupo1.sw2.ulima.foodtracker.model.usuario.login;

import java.io.Serializable;

/**
 * Created by stmorzan on 03/10/2015.
 */
public class UsuarioLoginRequest implements Serializable{

    private String usuario;
    private String pass;

    public UsuarioLoginRequest() {
    }

    public UsuarioLoginRequest(String usuario, String pass) {
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
}

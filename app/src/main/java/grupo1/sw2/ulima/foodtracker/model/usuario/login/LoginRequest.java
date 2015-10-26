package grupo1.sw2.ulima.foodtracker.model.usuario.login;

import java.io.Serializable;

/**
 * Created by stmorzan on 03/10/2015.
 */
public class LoginRequest implements Serializable{

    private String user;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUsuario() {
        return user;
    }

    public void setUsuario(String user) {
        this.user = user;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }
}

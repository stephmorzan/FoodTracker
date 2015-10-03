package grupo1.sw2.ulima.foodtracker.model.usuario;

/**
 * Created by stmorzan on 03/10/2015.
 */
public class UsuarioLoginRequest {

    private int idUsuario;
    private String usuario;
    private String pass;

    public UsuarioLoginRequest() {
    }

    public UsuarioLoginRequest(int idUsuario, String usuario, String pass) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.pass = pass;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

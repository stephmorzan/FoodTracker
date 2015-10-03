package grupo1.sw2.ulima.foodtracker.model.usuario;

/**
 * Created by stmorzan on 03/10/2015.
 */
public class UsuarioLoginRequest {

    private int idUsuario;
    private String usuario;
    private String password;

    public UsuarioLoginRequest() {
    }

    public UsuarioLoginRequest(int idUsuario, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package grupo1.sw2.ulima.foodtracker.model.usuario;

/**
 * Created by stmorzan on 07/10/2015.
 */
public class GenericResponse {

    private String msgStatus;
    private String msgError;

    public GenericResponse() {
    }

    public GenericResponse(String msgStatus, String msgError) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }
}

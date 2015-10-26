package grupo1.sw2.ulima.foodtracker.retrofit;

import java.util.List;

import grupo1.sw2.ulima.foodtracker.model.ClienteResponse;
import grupo1.sw2.ulima.foodtracker.model.gustos.GustosResponse;
import grupo1.sw2.ulima.foodtracker.model.usuario.login.LoginRequest;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioRequest;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioResponse;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface FoodTrackerService {

    @POST("/usuario/registro")
    Call<UsuarioResponse> registrar(@Body UsuarioRequest usuarioRequest);
    //es el llamado a un servicio. De la url /usuario/registro, se envía un UsuarioRequest para recibir un UsuarioResponse.

    @POST("/usuario/login")
    Call<ClienteResponse>login(@Body LoginRequest loginRequest);
    //es el llamado a un servicio.



    @GET("/usuario/gustos")
    Call<List<GustosResponse>> mostrarGustos();

    @POST("/usuario/sendGustos")
    Call<ClienteResponse> seleccionarGustos(@Body List<GustosResponse> gustosResponse);
}

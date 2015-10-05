package grupo1.sw2.ulima.foodtracker.retrofit;

import grupo1.sw2.ulima.foodtracker.model.foodtruck.FoodtruckRequest;
import grupo1.sw2.ulima.foodtracker.model.foodtruck.FoodtruckResponse;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioLoginRequest;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioRequest;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioResponse;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

public interface FoodTrackerService {

    @POST("/usuario/registro")
    Call<UsuarioResponse> registrar(@Body UsuarioRequest usuarioRequest);
    //es el llamado a un servicio. De la url /usuario/registro, se envía un UsuarioRequest para recibir un UsuarioResponse.

    @POST("/usuario/login")
    Call<UsuarioResponse>login(@Body UsuarioLoginRequest usuarioLoginRequest);
    //es el llamado a un servicio.

    @POST("/foodtruck/login")
    Call<FoodtruckResponse>login(@Body FoodtruckRequest foodtruckRequest);
}

package grupo1.sw2.ulima.foodtracker.retrofit;

import java.util.List;

import grupo1.sw2.ulima.foodtracker.model.ClienteResponse;
import grupo1.sw2.ulima.foodtracker.model.ProductoResponse;
import grupo1.sw2.ulima.foodtracker.model.foodtruck.FoodtruckResponse;
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

    @POST("/login-social")
    Call<ClienteResponse>loginFb();

    @GET("/mostrarGustos")
    Call<List<GustosResponse>> mostrarGustos();

    @POST("/seleccionarGustos")
    Call<UsuarioResponse> seleccionarGustos(@Body UsuarioRequest usuario, List<GustosResponse> gustosResponse);

    @GET("usuario/ranking")
    Call<FoodtruckResponse> listarRanking();

    @GET("usuario/perfil")
    Call<ClienteResponse> mostrarPerfil(@Body int tipo);

    @GET("usuario/productos")
    Call<ProductoResponse> mostrarProductos(@Body int idFoodTruck);
}

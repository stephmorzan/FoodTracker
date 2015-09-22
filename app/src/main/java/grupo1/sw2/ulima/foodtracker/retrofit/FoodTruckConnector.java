package grupo1.sw2.ulima.foodtracker.retrofit;

import com.google.gson.Gson;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


public class FoodTruckConnector {

    public static FoodTruckService getConnector(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://foodtracker-backend.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(FoodTruckService.class);
    }
}

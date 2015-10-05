package grupo1.sw2.ulima.foodtracker.retrofit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


public class FoodTrackerConnector {

    public static FoodTrackerService getConnector(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://foodtracker-backend.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(FoodTrackerService.class);
    }
}

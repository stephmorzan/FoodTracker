package grupo1.sw2.ulima.foodtracker.retrofit;

import retrofit.Retrofit;


public class FoodTruckConnector {

    public static FoodTruckService getConnector(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("localhost")
                .build();

        return retrofit.create(FoodTruckService.class);
    }
}

package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.rey.material.widget.Button;

import butterknife.Bind;
import grupo1.sw2.ulima.foodtracker.model.gustos.GustosResponse;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerConnector;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class SeleccionarGustosActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.lviGustos)ListView lviGustos;
    @Bind(R.id.butGuardarGustos)Button butGuardarGustos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_gustos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Seleccionar gustos");
        toolbar.setTitleTextColor(R.color.colorPrimary);
        setSupportActionBar(toolbar);

        FoodTrackerService connector = FoodTrackerConnector.getConnector();

        Call<GustosResponse> mostrarGustos = connector.mostrarGustos();
        mostrarGustos.enqueue(new Callback<GustosResponse>() {
            @Override
            public void onResponse(Response<GustosResponse> response) {

                /*if (response.body().getMsgError() != null) {

                    Toast.makeText(SeleccionarGustosActivity.this, response.body().getMsgError(), Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.setClass(SeleccionarGustosActivity.this, ContenedorActivity.class);
                    intent.putExtra("usuario", usuarioLoginRequest);
                    startActivity(intent);
                }*/
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        butGuardarGustos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}

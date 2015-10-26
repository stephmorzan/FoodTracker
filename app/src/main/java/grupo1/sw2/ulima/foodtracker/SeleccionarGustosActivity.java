package grupo1.sw2.ulima.foodtracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.rey.material.widget.Button;

import butterknife.Bind;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerConnector;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerService;

public class SeleccionarGustosActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.lviGustos)ListView lviGustos;
    @Bind(R.id.butGuardarGustos)Button butGuardarGustos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_gustos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Seleccionar gustos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.ftc_background));
        setSupportActionBar(toolbar);

        FoodTrackerService connector = FoodTrackerConnector.getConnector();



        butGuardarGustos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}

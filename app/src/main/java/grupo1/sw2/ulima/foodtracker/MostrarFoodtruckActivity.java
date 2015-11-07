package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.dd.processbutton.iml.ActionProcessButton;
import com.rey.material.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MostrarFoodtruckActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.toolbarDetalleFtc)Toolbar toolbar;
    @Bind(R.id.iviFtcFoto)ImageView iviFtcFoto;
    @Bind(R.id.tviFtcTipo)TextView tviFtcTipo;
    @Bind(R.id.tviFtcNombre)TextView tviFtcNombre;
    @Bind(R.id.iviCheckin)ImageView iviCheckin;
    @Bind(R.id.tviFtcDireccion)TextView tviFtcDireccion;
    @Bind(R.id.tviHorario)TextView tviHorario;
    @Bind(R.id.butVerMenu)ActionProcessButton butVerMenu;
    @Bind(R.id.butObtenerRuta)ActionProcessButton butObtenerRuta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_foodtruck);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Foodtruck");

        iviCheckin.setOnClickListener(this);
        butVerMenu.setOnClickListener(this);
        butObtenerRuta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.butVerMenu:
                break;
            case R.id.butObtenerRuta:
                break;
            case R.id.iviCheckin:
                break;
        }
    }

    public void onClickVerMenu(){
        Intent intent = new Intent();
        intent.setClass(MostrarFoodtruckActivity.this, SeleccionarGustosActivity.class);
        startActivity(intent);
    }
}

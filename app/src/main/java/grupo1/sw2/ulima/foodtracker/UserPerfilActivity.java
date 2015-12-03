package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.rey.material.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import grupo1.sw2.ulima.foodtracker.adapters.GustosAdapter;
import grupo1.sw2.ulima.foodtracker.model.ClienteResponse;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerConnector;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class UserPerfilActivity extends AppCompatActivity {

    @Bind(R.id.toolbarUserPerfil)Toolbar toolbar;
    @Bind(R.id.tviNombrePerfil)TextView tviNombrePerfil;
    @Bind(R.id.tviMisGustos)TextView tviMisGustos;
    @Bind(R.id.ciriviFotoUser)CircleImageView ciriviFotoUser;
    @Bind(R.id.lviMisGustos)ListView lviMisGustos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_perfil);
        FoodTrackerService connector = FoodTrackerConnector.getConnector();

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Mi perfil");

        Call<ClienteResponse> mostrarPerfil = connector.mostrarPerfil(0);
        mostrarPerfil.enqueue(new Callback<ClienteResponse>() {
            @Override
            public void onResponse(Response<ClienteResponse> response) {
                if (response != null) {
                    tviNombrePerfil.setText(response.body().getNombres());
                    lviMisGustos.setAdapter(new GustosAdapter(response.body().getGustos(), UserPerfilActivity.this));
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_perfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_config:
                Intent intent = new Intent();
                intent.setClass(UserPerfilActivity.this, ConfigurarPerfilActivity.class);
                intent.putExtra("usuario", tviNombrePerfil.getText());
                startActivity(intent);
        }


        return super.onOptionsItemSelected(item);

    }
}

package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioRequest;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioResponse;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTruckConnector;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTruckService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class UserRegistroActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.eteNombre)com.rey.material.widget.EditText eteNombre;
    @Bind(R.id.eteCorreo)com.rey.material.widget.EditText eteCorreo;
    @Bind(R.id.eteUser)com.rey.material.widget.EditText eteUser;
    @Bind(R.id.etePassword)com.rey.material.widget.EditText etePassword;
    @Bind(R.id.butRegistrar)Button butRegistrar;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registro);



        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        butRegistrar.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String nombre = eteNombre.getText().toString();
        String correo = eteCorreo.getText().toString();
        String user = eteUser.getText().toString();
        String password = etePassword.getText().toString();

        final UsuarioRequest usuarioRequest = new UsuarioRequest(nombre, correo, user, password);

        FoodTruckService connector = FoodTruckConnector.getConnector();

        Call<UsuarioResponse> registrar = connector.registrar(usuarioRequest);

        registrar.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Response<UsuarioResponse> response) {
                if (response.body().getMsgError() != null) {
                    Toast.makeText(UserRegistroActivity.this, response.body().getMsgError(), Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.setClass(UserRegistroActivity.this, InicioActivity.class);
                    intent.putExtra("usuario", usuarioRequest);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(UserRegistroActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioRequest;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioResponse;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerConnector;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class UserRegistroActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.eteNombre)EditText eteNombre;
    @Bind(R.id.eteCorreo)EditText eteCorreo;
    @Bind(R.id.eteUser)EditText eteUser;
    @Bind(R.id.etePassword)EditText etePassword;
    @Bind(R.id.butRegistrar) ActionProcessButton butRegistrar;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registro);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Regístrate");

        butRegistrar.setOnClickListener(this);
        butRegistrar.setMode(ActionProcessButton.Mode.ENDLESS);
        butRegistrar.setProgress(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

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

        FoodTrackerService connector = FoodTrackerConnector.getConnector();

        Call<UsuarioResponse> registrar = connector.registrar(usuarioRequest);
        butRegistrar.setProgress(50);
        registrar.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Response<UsuarioResponse> response) {
                if (response.body().getMsgError() != null) {
                    butRegistrar.setProgress(-1);
                    Toast.makeText(UserRegistroActivity.this, response.body().getMsgError(), Toast.LENGTH_SHORT).show();
                } else {
                    butRegistrar.setProgress(100);
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

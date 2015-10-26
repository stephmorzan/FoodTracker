package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

        try {
            PackageInfo info = getPackageManager().getPackageInfo("grupo1.sw2.ulima.foodtracker", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        String nombre = eteNombre.getText().toString();
        String correo = eteCorreo.getText().toString();
        String user = eteUser.getText().toString();
        String password = etePassword.getText().toString();

        final UsuarioRequest usuarioRequest = new UsuarioRequest(nombre, correo, user, password);

        /*
        Intent intent = new Intent();
        butRegistrar.setProgress(50);
        intent.setClass(UserRegistroActivity.this, LoginActivity.class);
        intent.putExtra("usuario", usuarioRequest);
        startActivity(intent);
        */

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
                    intent.setClass(UserRegistroActivity.this, ContenedorActivity.class);
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

package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.rey.material.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioResponse;
import grupo1.sw2.ulima.foodtracker.model.usuario.login.UsuarioLoginRequest;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerConnector;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.eteUserLogin)EditText eteUserLogin;
    @Bind(R.id.etePasswordLogin)EditText etePasswordLogin;
    @Bind(R.id.butLogin)ActionProcessButton butLogin;
    @Bind(R.id.tviFtc)TextView tviFtc;
    @Bind(R.id.tviRegistrar)TextView tviRegistrar;
    @Bind(R.id.butFbLogin)LoginButton butFbLogin;

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        butFbLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                String usuario = loginResult.getAccessToken().getUserId();
                String pass = loginResult.getAccessToken().getToken();

                final UsuarioLoginRequest usuarioLoginRequest = new UsuarioLoginRequest(usuario, pass);

                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, ContenedorActivity.class);
                intent.putExtra("usuario", usuarioLoginRequest);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }

            });

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        butLogin.setOnClickListener(this);
        butLogin.setMode(ActionProcessButton.Mode.ENDLESS);
        butLogin.setProgress(0);

        tviFtc.setOnClickListener(this);
        tviRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usuario = eteUserLogin.getText().toString();
        String pass = etePasswordLogin.getText().toString();

        FoodTrackerService connector = FoodTrackerConnector.getConnector();

        final UsuarioLoginRequest usuarioLoginRequest = new UsuarioLoginRequest(usuario, pass);

        Call<UsuarioResponse> login = connector.login(usuarioLoginRequest);
        login.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Response<UsuarioResponse> response) {
                if (response.body().getMsgError() != null) {
                    butLogin.setProgress(-1);
                    Toast.makeText(LoginActivity.this, response.body().getMsgError(), Toast.LENGTH_SHORT).show();
                } else {
                    butLogin.setProgress(100);
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, ContenedorActivity.class);
                    intent.putExtra("usuario", usuarioLoginRequest);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(LoginActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }


}

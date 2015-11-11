package grupo1.sw2.ulima.foodtracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ConfigurarPerfilActivity extends AppCompatActivity {

    @Bind(R.id.toolbarConfig)Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_perfil);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


    }

}

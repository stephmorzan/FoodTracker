package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.rey.material.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserPerfilActivity extends AppCompatActivity {

    @Bind(R.id.toolbarUserPerfil)Toolbar toolbar;
    @Bind(R.id.tviNombrePerfil)TextView tviNombrePerfil;
    @Bind(R.id.tviMisGustos)TextView tviMisGustos;
    @Bind(R.id.ciriviFotoUser)CircleImageView ciriviFotoUser;
    @Bind(R.id.lviMisGustos)ListView lviMisGustos;

    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_perfil);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Mi perfil");

        Intent intent = getIntent();

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
                intent.putExtra("usuario", usuario);
                startActivity(intent);
        }


        return super.onOptionsItemSelected(item);

    }
}

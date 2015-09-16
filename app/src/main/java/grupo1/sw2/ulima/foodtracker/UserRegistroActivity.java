package grupo1.sw2.ulima.foodtracker;

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

public class UserRegistroActivity extends AppCompatActivity implements View.OnClickListener{

    EditText eteNombre;
    EditText eteCorreo;
    EditText eteUser;
    EditText etePassword;
    Button butRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eteNombre = (EditText) findViewById(R.id.eteNombre);
        eteCorreo = (EditText)findViewById(R.id.eteCorreo);
        eteUser = (EditText)findViewById(R.id.eteUser);
        etePassword = (EditText) findViewById(R.id.etePassword);
        butRegistrar = (Button)findViewById(R.id.butRegistrar);

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


    }
}

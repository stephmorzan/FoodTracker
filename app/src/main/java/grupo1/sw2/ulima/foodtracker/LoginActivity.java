package grupo1.sw2.ulima.foodtracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.dd.processbutton.iml.ActionProcessButton;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.eteUserLogin)EditText eteUserLogin;
    @Bind(R.id.etePasswordLogin)EditText etePasswordLogin;
    @Bind(R.id.butLogin)ActionProcessButton butLogin;
    @Bind(R.id.toolbar)Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        butLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usuario = eteUserLogin.getText().toString();
        String pass = etePasswordLogin.getText().toString();


    }
}

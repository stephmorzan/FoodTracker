package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dd.processbutton.iml.ActionProcessButton;
import com.rey.material.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginFoodtruckActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.eteFtcLogin)EditText eteFtcLogin;
    @Bind(R.id.etePassFtcLogin)EditText eteFtcPass;
    @Bind(R.id.butLoginFtc)
    ActionProcessButton butLoginFtc;
    @Bind(R.id.tviNoFtc)TextView noFtc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_foodtruck);
        ButterKnife.bind(this);
        noFtc.setOnClickListener(this);
        butLoginFtc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.butLoginFtc:
                String login = eteFtcLogin.getText().toString();
                String pass = eteFtcPass.getText().toString();
                break;
            case R.id.tviNoFtc:
                intent.setClass(LoginFoodtruckActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}

package grupo1.sw2.ulima.foodtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;

public class ContenedorActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.toolbar)Toolbar toolbar;
    @Bind(R.id.claContenedor)CoordinatorLayout claContenedor;
    @Bind(R.id.iviCupones)ImageView iviCupones;
    @Bind(R.id.iviBuscar)ImageView iviBuscar;
    @Bind(R.id.iviRanking)ImageView iviRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);

        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //ft.replace(R.id.flaContenido, )

        iviCupones.setOnClickListener(this);
        iviBuscar.setOnClickListener(this);
        iviRanking.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iviRanking:
                String blah = "blah";
            case R.id.iviBuscar:
        }
    }
}

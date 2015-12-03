package grupo1.sw2.ulima.foodtracker;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.fragments.BuscarFragment;
import grupo1.sw2.ulima.foodtracker.fragments.CuponesFragment;
import grupo1.sw2.ulima.foodtracker.fragments.RankingFragment;

public class ContenedorActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.toolbar)Toolbar toolbar;
    @Bind(R.id.claContenedor)CoordinatorLayout claContenedor;
    @Bind(R.id.iviCupones)ImageView iviCupones;
    @Bind(R.id.iviBuscar)ImageView iviBuscar;
    @Bind(R.id.iviRanking)ImageView iviRanking;

    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);
        ButterKnife.bind(this);
        toolbar.setTitle("FoodTracker");
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        usuario = intent.getStringExtra("usuario");

        onDefaultFragment();

        iviCupones.setOnClickListener(this);
        iviBuscar.setOnClickListener(this);
        iviRanking.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.iviRanking:
                toolbar.setTitle("Ranking Trucks");
                Fragment rankingFragment = RankingFragment.newInstance();
                ft.replace(R.id.flaContenido, rankingFragment);
                ft.commit();
                break;
            case R.id.iviBuscar:
                toolbar.setTitle("FoodTracker");
                Fragment buscarFragment = BuscarFragment.newInstance();
                ft.replace(R.id.flaContenido, buscarFragment);
                ft.commit();
                break;
            case R.id.iviCupones:
                toolbar.setTitle("Cupones de descuento");
                Fragment cuponesFragment = CuponesFragment.newInstance();
                ft.replace(R.id.flaContenido, cuponesFragment);
                ft.commit();
                break;
            default:
                onDefaultFragment();
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.perfil:
                Intent intent = new Intent();
                intent.setClass(ContenedorActivity.this, UserPerfilActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void onDefaultFragment(){
        Fragment buscarFragment = BuscarFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.flaContenido, buscarFragment);
        ft.commit();
    }
}

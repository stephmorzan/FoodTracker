package grupo1.sw2.ulima.foodtracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.adapters.MenuAdapter;

public class VerMenuActivity extends AppCompatActivity {

    @Bind(R.id.toolbarMenu)Toolbar toolbar;
    @Bind(R.id.rviMenu)RecyclerView rviMenu;

    MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_menu);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Menú");
        cargarRecyclerMenu();
    }

    public void cargarRecyclerMenu(){
        menuAdapter = new MenuAdapter(VerMenuActivity.this);
        rviMenu.setAdapter(menuAdapter);
    }

}

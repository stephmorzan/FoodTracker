package grupo1.sw2.ulima.foodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.adapters.GustosAdapter;
import grupo1.sw2.ulima.foodtracker.model.ClienteResponse;
import grupo1.sw2.ulima.foodtracker.model.gustos.GustosResponse;
import grupo1.sw2.ulima.foodtracker.model.usuario.UsuarioRequest;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerConnector;
import grupo1.sw2.ulima.foodtracker.retrofit.FoodTrackerService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class SeleccionarGustosActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @Bind(R.id.lviGustos)ListView lviGustos;
    @Bind(R.id.butGuardarGustos)ActionProcessButton butGuardarGustos;
    @Bind(R.id.toolbarGustos)Toolbar toolbar;
    List<GustosResponse> gusto;
    List<GustosResponse> seleccionados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_gustos);
        ButterKnife.bind(this);
        toolbar.setTitle("Seleccionar gustos");
        toolbar.setTitleTextColor(getResources().getColor(R.color.ftc_background));
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("usuario");
        String correo = intent.getStringExtra("usuario");
        String user = intent.getStringExtra("usuario");
        String password = intent.getStringExtra("usuario");

        final UsuarioRequest usuarioRequest = new UsuarioRequest(nombre, correo, user, password);

        butGuardarGustos.setOnClickListener(this);
        butGuardarGustos.setMode(ActionProcessButton.Mode.ENDLESS);
        butGuardarGustos.setProgress(0);

        FoodTrackerService connector = FoodTrackerConnector.getConnector();

        Call<List<GustosResponse>> mostrarGustos = connector.mostrarGustos();
        mostrarGustos.enqueue(new Callback<List<GustosResponse>>() {
            @Override
            public void onResponse(Response<List<GustosResponse>> response) {
                if(response == null){
                    Toast.makeText(SeleccionarGustosActivity.this, "Lista vacía. Error de conexión con BD.", Toast.LENGTH_SHORT).show();
                }else{
                    for(GustosResponse gustito : response.body()){
                        gusto.add(gustito);
                    }
                    GustosAdapter gustosAdapter = new GustosAdapter(response.body(), SeleccionarGustosActivity.this);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(SeleccionarGustosActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        butGuardarGustos.setOnClickListener(this);
        lviGustos.setOnItemClickListener(this);
    }



    @Override
    public void onClick(View v) {

        /*FoodTrackerService connector = FoodTrackerConnector.getConnector();
        butGuardarGustos.setProgress(50);
        Call<ClienteResponse> seleccionarGustos = connector.seleccionarGustos(seleccionados);
        seleccionarGustos.enqueue(new Callback<ClienteResponse>() {
            @Override
            public void onResponse(Response<ClienteResponse> response) {
                if(response.body()!=null){
                    butGuardarGustos.setProgress(100);
                    Intent intent = new Intent();
                    intent.setClass(SeleccionarGustosActivity.this, ContenedorActivity.class);
                    intent.putExtra("cliente", response.body().getNombres());
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(SeleccionarGustosActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



        GustosResponse gustoSelect = (GustosResponse)parent.getItemAtPosition(position);
        Toast.makeText(SeleccionarGustosActivity.this,
                "Clicked item:\n" +
                        gustoSelect.getId_Categoria() + ": " +
                        gustoSelect.getNombre(),
                Toast.LENGTH_LONG).show();
        seleccionados.add(gustoSelect);
    }
}

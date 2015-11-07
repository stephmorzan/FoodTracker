package grupo1.sw2.ulima.foodtracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import grupo1.sw2.ulima.foodtracker.R;
import grupo1.sw2.ulima.foodtracker.model.ProductoResponse;

/**
 * Created by stmorzan on 07/11/2015.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    private LayoutInflater inflater;
    List<ProductoResponse> productos;

    public MenuAdapter(Context context){
        inflater = LayoutInflater.from(context);
        productos = new ArrayList<>();
    }

    @Override
    public MenuAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MenuAdapter.MenuViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.ciriviProducto)CircleImageView ciriviProducto;
        @Bind(R.id.tviProdNombre)TextView tviNombre;
        @Bind(R.id.tviProdDescrip)TextView tviDescripcion;
        @Bind(R.id.tviPrecio)TextView tviPrecio;

        public MenuViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public CircleImageView getCiriviProducto() {
            return ciriviProducto;
        }

        public void setCiriviProducto(CircleImageView ciriviProducto) {
            this.ciriviProducto = ciriviProducto;
        }

        public TextView getTviNombre() {
            return tviNombre;
        }

        public void setTviNombre(TextView tviNombre) {
            this.tviNombre = tviNombre;
        }

        public TextView getTviDescripcion() {
            return tviDescripcion;
        }

        public void setTviDescripcion(TextView tviDescripcion) {
            this.tviDescripcion = tviDescripcion;
        }

        public TextView getTviPrecio() {
            return tviPrecio;
        }

        public void setTviPrecio(TextView tviPrecio) {
            this.tviPrecio = tviPrecio;
        }
    }
}

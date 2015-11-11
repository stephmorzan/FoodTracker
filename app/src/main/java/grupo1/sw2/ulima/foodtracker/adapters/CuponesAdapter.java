package grupo1.sw2.ulima.foodtracker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rey.material.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import grupo1.sw2.ulima.foodtracker.R;
import grupo1.sw2.ulima.foodtracker.model.CuponResponse;

/**
 * Created by stmorzan on 28/10/2015.
 */
public class CuponesAdapter extends RecyclerView.Adapter<CuponesAdapter.CuponesViewHolder>{

    private LayoutInflater inflater;
    List<CuponResponse> cupones;
    View.OnClickListener listener;

    public CuponesAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        cupones = new ArrayList<>();
    }

    @Override
    public CuponesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CuponesViewHolder holder, int position) {
        holder.itemView.setOnClickListener(listener);
    }



    @Override
    public int getItemCount() {
        return 0;
    }

    class CuponesViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ciriviCupon)CircleImageView ciriviCupon;
        @Bind(R.id.iviQr)ImageView iviQr;
        @Bind(R.id.tviExpiracion)TextView tviExpiracion;
        @Bind(R.id.tviCuponDscto)TextView tviDscto;
        @Bind(R.id.tviCuponNombre)TextView tviNombre;
        @Bind(R.id.tviCuponProd)TextView tviProducto;

        public CuponesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public CircleImageView getCiriviCupon() {
            return ciriviCupon;
        }

        public void setCiriviCupon(CircleImageView ciriviCupon) {
            this.ciriviCupon = ciriviCupon;
        }

        public ImageView getIviQr() {
            return iviQr;
        }

        public void setIviQr(ImageView iviQr) {
            this.iviQr = iviQr;
        }

        public TextView getTviExpiracion() {
            return tviExpiracion;
        }

        public void setTviExpiracion(TextView tviExpiracion) {
            this.tviExpiracion = tviExpiracion;
        }

        public TextView getTviDscto() {
            return tviDscto;
        }

        public void setTviDscto(TextView tviDscto) {
            this.tviDscto = tviDscto;
        }

        public TextView getTviNombre() {
            return tviNombre;
        }

        public void setTviNombre(TextView tviNombre) {
            this.tviNombre = tviNombre;
        }

        public TextView getTviProducto() {
            return tviProducto;
        }

        public void setTviProducto(TextView tviProducto) {
            this.tviProducto = tviProducto;
        }
    }

}

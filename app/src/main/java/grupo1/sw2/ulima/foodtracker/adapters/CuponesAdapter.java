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

    }



    @Override
    public int getItemCount() {
        return 0;
    }

    class CuponesViewHolder extends RecyclerView.ViewHolder {
        //@Bind(R.id.tv)
        TextView tv;

        public CuponesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public TextView getTv() {
            return tv;
        }
    }

}

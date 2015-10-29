package grupo1.sw2.ulima.foodtracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.R;

/**
 * Created by stmorzan on 28/10/2015.
 */
public class CuponesAdapter extends RecyclerView.Adapter<CuponesAdapter.CuponesViewHolder>{
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

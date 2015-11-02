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
import grupo1.sw2.ulima.foodtracker.R;

/**
 * Created by stmorzan on 28/10/2015.
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingViewHolder>{
    private LayoutInflater inflater;
    List<String> lista;
    //View.OnClickListener listener;

    public RankingAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        lista = new ArrayList<>();//lista de objetos ranking
    }

    public void updateData(List<String> nuevaLista) {
        this.lista.clear();
        for (String s: nuevaLista) {
            lista.add(s);
        }
        notifyDataSetChanged();
    }

    @Override
    public RankingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_ranking, parent, false);//obvio que no es item_gusto, es item_ranking
        return new RankingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RankingViewHolder holder, int position) {
        String current = lista.get(position);
        holder.getTviRankingNombre().setText(current);

        //holder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

//    public void setOnItemClickListener(View.OnClickListener listener){
//        this.listener = listener;
//    }

    class RankingViewHolder extends RecyclerView.ViewHolder {
        //@Bind(R.id.tviRankingNombre)
        TextView tviRankingNombre;

        public RankingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public TextView getTviRankingNombre() {
            return tviRankingNombre;
        }
    }

    public void updateRankingList(List<String> ranking){
        this.lista = ranking;
        notifyDataSetChanged();
    }


}

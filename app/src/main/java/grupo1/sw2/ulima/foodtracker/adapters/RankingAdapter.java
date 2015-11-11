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
import grupo1.sw2.ulima.foodtracker.model.RankingResponse;

/**
 * Created by stmorzan on 28/10/2015.
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingViewHolder>{
    private LayoutInflater inflater;
    List<RankingResponse> ranking;
    //View.OnClickListener listener;

    public RankingAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        ranking = new ArrayList<>();//ranking de objetos ranking
    }

    public void updateData(List<RankingResponse> nuevoRanking) {
        this.ranking.clear();
        for (RankingResponse s: nuevoRanking) {
            ranking.add(s);
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
        RankingResponse current = ranking.get(position);
        holder.getTviRankingNombre().setText(current.getNombre().toString());
        holder.getTviRankingTipo().setText(current.getTipo().toString());
        holder.getTviRankingKm().setText(""+current.getKm());
        holder.getTviPuntaje().setText(""+current.getPuntaje());
        //holder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return ranking.size();
    }

//    public void setOnItemClickListener(View.OnClickListener listener){
//        this.listener = listener;
//    }

    public void updateRankingList(List<RankingResponse> ranking){
        this.ranking = ranking;
        notifyDataSetChanged();
    }

    class RankingViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tviPuntaje)
        TextView tviPuntaje;
        @Bind(R.id.ciriviRanking)
        CircleImageView ciriviRanking;
        @Bind(R.id.tviRankingNomb) TextView tviRankingNombre;
        @Bind(R.id.tviRankingTipo) TextView tviRankingTipo;
        @Bind(R.id.tviRankingKm) TextView tviRankingKm;

        public RankingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public TextView getTviPuntaje() {
            return tviPuntaje;
        }

        public void setTviPuntaje(TextView tviPuntaje) {
            this.tviPuntaje = tviPuntaje;
        }

        public CircleImageView getCiriviRanking() {
            return ciriviRanking;
        }

        public void setCiriviRanking(CircleImageView ciriviRanking) {
            this.ciriviRanking = ciriviRanking;
        }

        public TextView getTviRankingNombre() {
            return tviRankingNombre;
        }

        public void setTviRankingNombre(TextView tviRankingNombre) {
            this.tviRankingNombre = tviRankingNombre;
        }

        public TextView getTviRankingTipo() {
            return tviRankingTipo;
        }

        public void setTviRankingTipo(TextView tviRankingTipo) {
            this.tviRankingTipo = tviRankingTipo;
        }

        public TextView getTviRankingKm() {
            return tviRankingKm;
        }

        public void setTviRankingKm(TextView tviRankingKm) {
            this.tviRankingKm = tviRankingKm;
        }
    }

}

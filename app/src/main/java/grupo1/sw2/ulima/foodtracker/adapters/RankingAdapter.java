package grupo1.sw2.ulima.foodtracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.R;
import grupo1.sw2.ulima.foodtracker.model.RankingResponse;

/**
 * Created by EQ on 01/11/2015.
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingViewHolder> {

    private LayoutInflater inflater;
    List<RankingResponse> top10;

    @Override
    public RankingAdapter.RankingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RankingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class RankingViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tviRankingNomb)TextView tviRankingNombre;


        public RankingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

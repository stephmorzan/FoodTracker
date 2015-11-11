package grupo1.sw2.ulima.foodtracker.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.R;
import grupo1.sw2.ulima.foodtracker.adapters.RankingAdapter;

public class RankingFragment extends Fragment {

    @Bind(R.id.rviRanking)RecyclerView rviRanking;
    RankingAdapter rankingAdapter;

    public RankingFragment() {
    }

    public static RankingFragment newInstance() {
        return new RankingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layoutRanking = inflater.inflate(R.layout.fragment_ranking, container, false);
        ButterKnife.bind(this, layoutRanking);
        rankingAdapter = new RankingAdapter(this.getContext());
        rviRanking.setAdapter(rankingAdapter);
        //rankingAdapter.updateData();
        return layoutRanking;
    }



}

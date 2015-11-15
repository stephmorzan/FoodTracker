package grupo1.sw2.ulima.foodtracker.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.R;
import grupo1.sw2.ulima.foodtracker.adapters.CuponesAdapter;
import grupo1.sw2.ulima.foodtracker.model.CuponResponse;

public class CuponesFragment extends Fragment {

    @Bind(R.id.rviCupones)RecyclerView rviCupones;
    CuponesAdapter cuponesAdapter;

    public CuponesFragment() {
    }

    public static CuponesFragment newInstance() {
        return new CuponesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutCupones = inflater.inflate(R.layout.fragment_cupones, container, false);
        ButterKnife.bind(this, layoutCupones);
        cuponesAdapter = new CuponesAdapter(this.getActivity(), new ArrayList<CuponResponse>());
        rviCupones.setAdapter(cuponesAdapter);
        return layoutCupones;
    }

}

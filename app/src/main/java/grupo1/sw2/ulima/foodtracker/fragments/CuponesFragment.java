package grupo1.sw2.ulima.foodtracker.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import grupo1.sw2.ulima.foodtracker.R;

public class CuponesFragment extends Fragment {

    public CuponesFragment() {
    }

    public static CuponesFragment newInstance() {
        CuponesFragment fragment = new CuponesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cupones, container, false);
    }

}

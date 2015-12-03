package grupo1.sw2.ulima.foodtracker.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import grupo1.sw2.ulima.foodtracker.R;


public class PerfilFoodtruckFragment extends Fragment {

    public PerfilFoodtruckFragment() {
        // Required empty public constructor
    }

    public static PerfilFoodtruckFragment newInstance() {
        PerfilFoodtruckFragment fragment = new PerfilFoodtruckFragment();
        ;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil_foodtruck, container, false);
    }


}

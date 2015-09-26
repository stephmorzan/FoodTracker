package grupo1.sw2.ulima.foodtracker;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BotonesFragment extends Fragment {


    public static BotonesFragment newInstance() {
        return new BotonesFragment();

    }

    public BotonesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_botones, container, false);
    }



}

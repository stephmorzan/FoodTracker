package grupo1.sw2.ulima.foodtracker.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.Bind;
import butterknife.ButterKnife;
import grupo1.sw2.ulima.foodtracker.R;

public class BuscarFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener, OnMapReadyCallback {

    private GoogleApiClient apiClient;
    private Location location;
    private LocationRequest locationRequest;
    private GoogleMap googleMap;
    private MapFragment mapFragment;

    @Bind(R.id.rviFoodtrucks)RecyclerView rviFoodtrucks;

    public BuscarFragment() {
    }

    public static BuscarFragment newInstance() {
        BuscarFragment fragment = new BuscarFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map, mapFragment);
        fragmentTransaction.commit();

        googleMap = mapFragment.getMap();

    }

    private void buildGoogleApiClient() {
        /*apiClient = new GoogleApiClient.Builder(this.getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        apiClient.connect();*/
        apiClient = new GoogleApiClient.Builder(this.getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        apiClient.connect();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layoutBuscar = inflater.inflate(R.layout.fragment_buscar, container, false);
        ButterKnife.bind(this,layoutBuscar);
        return layoutBuscar;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        buildGoogleApiClient();
    }

    @Override
    public void onConnected(Bundle bundle) {
        location = LocationServices.FusedLocationApi.getLastLocation(apiClient);

        locationRequest = new LocationRequest();
        locationRequest.setInterval(60000);
        locationRequest.setFastestInterval(30000);
        locationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);

        LocationServices.FusedLocationApi.requestLocationUpdates(
                apiClient, locationRequest, this);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    private void agregarMarcador() {
        if (location != null) {
            LatLng actual = new LatLng(location.getLatitude(), location.getLongitude());
            googleMap.addMarker(new MarkerOptions().position(actual).title("Aquí estoy"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(actual));
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        }else{

            LatLng actual = new LatLng(17.000, 13.000);
            googleMap.addMarker(new MarkerOptions().position(actual).title("Aquí estoy"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(actual));
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MapFragment f = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        if (f != null)
            getFragmentManager().beginTransaction().remove(f).commit();
    }

}
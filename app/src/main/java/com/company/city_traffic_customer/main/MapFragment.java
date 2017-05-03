package com.company.city_traffic_customer.main;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.city_traffic_customer.R;
import com.company.city_traffic_customer.model.RouteTaxi;
import com.company.city_traffic_customer.model.Station;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MapFragment extends Fragment implements IMapFragment {

    MapView mMapView;
    IMapPresenter presenter;

    public MapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_map, container, false);

        mMapView = (MapView) view.findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng sydney = new LatLng(49.550710, 25.591751);
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(13).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
        presenter = new MapPresenter(this);
        presenter.showStations();
        return view;
    }

    @Override
    public void showStations(final List<Station> stations) {
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                for(int i = 0; i < stations.size(); i++){
                    LatLng busStantion = new LatLng(stations.get(i).getLatitude(), stations.get(i).getLongitude());
                    googleMap.addMarker(new MarkerOptions()
                            .position(busStantion)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.busstop)));
                }
            }
        });
    }

    @Override
    public void showRouteTaxis(List<RouteTaxi> routeTaxis) {


    }
}

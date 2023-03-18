package com.vedant.trufitnetwork;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        //19.057715154206214, 72.92318140570518
        //19.066390, 73.005032
        //19.057904712050515, 72.90057154350465
        //19.055688640944563, 72.91370765993562
        //19.04469895695906, 72.86225550958564
        public void onMapReady(GoogleMap googleMap) {



            LatLng sydney = new LatLng(19.066390, 73.005032);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Mr Rajesh Kulkarni"));

            googleMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );

            LatLng mankhurd = new LatLng(19.057715154206214, 72.92318140570518);
            googleMap.addMarker(new MarkerOptions().position(mankhurd).title("Mr Mahesh Desai"));

            LatLng chembur = new LatLng(19.057904712050515, 72.90057154350465);
            googleMap.addMarker(new MarkerOptions().position(chembur).title("Mr Lokesh Shah"));

            LatLng govandi = new LatLng(19.055688640944563, 72.91370765993562);
            googleMap.addMarker(new MarkerOptions().position(govandi).title("Mr Jayant Savarkar"));

            LatLng sion = new LatLng(19.04469895695906, 72.86225550958564);
            googleMap.addMarker(new MarkerOptions().position(sion).title("Mr Sunil Naraine"));

            //19.077345452747654, 73.01410928803153

            LatLng turbhe = new LatLng(19.077345452747654, 73.01410928803153);
            googleMap.addMarker(new MarkerOptions().position(turbhe).title("Mrs Agatha Gomendes"));


            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.getUiSettings().setCompassEnabled(true);
            googleMap.getUiSettings().setZoomGesturesEnabled(true);
            googleMap.getUiSettings().setScrollGesturesEnabled(true);

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}
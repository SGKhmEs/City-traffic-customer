package com.company.city_traffic_customer.main;


import android.graphics.Bitmap;

import com.company.city_traffic_customer.model.RouteTaxi;
import com.company.city_traffic_customer.model.Station;

import java.util.List;

interface IMapFragment {

    void showStations(List<Station> stations);
    void showRouteTaxis(List<RouteTaxi> routeTaxis);
    void showProgresDialog();
    void hideProgresDialog();

}

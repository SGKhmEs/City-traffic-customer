package com.company.city_traffic_customer.main;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;

import com.company.city_traffic_customer.model.DataBase;
import com.company.city_traffic_customer.model.RestResource;
import com.company.city_traffic_customer.model.RouteTaxi;
import com.company.city_traffic_customer.model.Station;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.city_traffic_customer.R;

class MapPresenter implements IMapPresenter {

    private IMapFragment fragment;
    private DataBase dataBase;

    MapPresenter(IMapFragment fragment) {
        this.fragment = fragment;
        dataBase = DataBase.getDataBase();
    }

    @Override
    public void showStations() {
        new AsyncTask<Void, Void, List<Station>>() {
            @Override
            protected List<Station> doInBackground(Void... params) {
                return dataBase.getStation();
            }

            @Override
            protected void onPostExecute(List<Station> stations) {
                super.onPostExecute(stations);
                fragment.showStations(stations);
            }
        }.execute();
    }

    @Override
    public void showStation(String name) {

    }

    @Override
    public void showRouteTaxis(final String name) {
        new AsyncTask<Void, Void, List<RouteTaxi>>() {


            @Override
            protected List<RouteTaxi> doInBackground(Void... params) {
                return RestResource.getRestResource().getTaxis(name);
            }

            @Override
            protected void onPostExecute(List<RouteTaxi> routeTaxis) {
                super.onPostExecute(routeTaxis);
                fragment.showRouteTaxis(routeTaxis);

            }
        }.execute();
    }
}

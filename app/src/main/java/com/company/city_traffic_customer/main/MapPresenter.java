package com.company.city_traffic_customer.main;


import android.os.AsyncTask;

import com.company.city_traffic_customer.model.DataBase;
import com.company.city_traffic_customer.model.Station;

import java.util.List;

class MapPresenter implements IMapPresenter {

    private IMapFragment fragment;
    private DataBase dataBase;

    public MapPresenter(IMapFragment fragment) {
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
    public void showRouteTaxis(String name) {

    }
}

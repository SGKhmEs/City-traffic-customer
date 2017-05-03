package com.company.city_traffic_customer.main;

import android.os.AsyncTask;

import com.company.city_traffic_customer.model.DataBase;
import com.company.city_traffic_customer.model.Station;

import java.util.ArrayList;
import java.util.List;


class MainPresenter implements IMainPresenter {

    private IMainActivity activity;
    private DataBase dataBase;

    MainPresenter(IMainActivity activity) {
        this.activity = activity;
        dataBase = DataBase.getDataBase();
    }

    @Override
    public void setSearchList() {
        new AsyncTask<Void, Void, List<String>>(){

            @Override
            protected List<String> doInBackground(Void... params) {
                List<String> list = new ArrayList<>();
                List<Station> stations = dataBase.getStation();
                for(int i = 0; i < stations.size(); i++){
                    list.add(stations.get(i).getName());
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<String> stations) {
                super.onPostExecute(stations);
                activity.setSearchList(stations);
            }
        }.execute();
    }

    @Override
    public void startActivityTraffic(String station) {
        activity.startActivityTraffic(station);
    }
}

package com.company.city_traffic_customer.model;


import android.util.Log;

import com.activeandroid.query.Select;

import java.util.List;

public class DataBase {

    private static final String TAG = "log";
    private static DataBase dataBase;

    private DataBase(){
        Log.w(TAG, "DataBase: ");
    }

    public static DataBase getDataBase() {
        if(dataBase == null){
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public List<Station> getStation(){
        return new Select()
                .from(Station.class)
                .execute();
    }

    private void addToDB(){
        new Station("Карпенка до центру", 49.541851, 25.579770).save();
        new Station("Руська", 49.550512, 25.587627).save();
    }
}

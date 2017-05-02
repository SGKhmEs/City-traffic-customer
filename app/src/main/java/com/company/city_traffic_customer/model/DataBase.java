package com.company.city_traffic_customer.model;


import com.activeandroid.query.Select;

import java.util.List;

public class DataBase {

    private static DataBase dataBase;

    private DataBase(){
        addToDB();
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
        new Station("Карпенка з центру", 49.542352, 25.581641).save();
    }
}

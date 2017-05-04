package com.company.city_traffic_customer.model;


import java.util.ArrayList;
import java.util.List;

public class RestResource {

    private static RestResource restResource;

    private RestResource(){

    }

    public static RestResource getRestResource() {
        if(restResource == null){
            restResource = new RestResource();
        }
        return restResource;
    }

    public List<Station> getStations(int versionDataBase){
        List<Station> stations = new ArrayList<>();
        return stations;
    }

    public List<RouteTaxi> getTaxis(String stationName){
        List<RouteTaxi> taxis = new ArrayList<>();
        taxis.add(new RouteTaxi("ВО 2030 АР", "16", 60, 49.541441, 25.577651));
        taxis.add(new RouteTaxi("ВО 2010 АР", "16", 120, 49.545426, 25.580390));
        return taxis;
    }

}

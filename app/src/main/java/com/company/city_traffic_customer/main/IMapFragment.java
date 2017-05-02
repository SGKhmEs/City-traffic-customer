package com.company.city_traffic_customer.main;


import com.company.city_traffic_customer.model.RouteTaxi;
import com.company.city_traffic_customer.model.Station;

import java.util.List;

interface IMapFragment {

    void showStations(List<Station> stations);
    void showRouteTaxis(List<RouteTaxi> routeTaxis);

}

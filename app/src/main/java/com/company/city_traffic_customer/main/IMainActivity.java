package com.company.city_traffic_customer.main;


import com.company.city_traffic_customer.model.Station;

import java.util.List;

interface IMainActivity {
    void setSearchList(List<String> stations);
    void startActivityTraffic(String station);
}

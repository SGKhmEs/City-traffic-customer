package com.company.city_traffic_customer.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "RouteTaxis")
public class RouteTaxi extends Model {

    @Column(name = "registrationMark")
    private String registrationMark;
    @Column(name = "routeNumber")
    private String routeNumber;
    @Column(name = "way")
    private int way;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    public RouteTaxi() {
        super();
    }

    public RouteTaxi(String registrationMark, String routeNumber, int way, double latitude, double longitude) {
        this.registrationMark = registrationMark;
        this.routeNumber = routeNumber;
        this.way = way;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getRegistrationMark() {
        return registrationMark;
    }

    public void setRegistrationMark(String registrationMark) {
        this.registrationMark = registrationMark;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public int getWay() {
        return way;
    }

    public void setWay(int way) {
        this.way = way;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}

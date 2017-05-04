package com.company.city_traffic_customer.model;


public class RouteTaxi {

    private String registrationMark;
    private String routeNumber;
    private int way;
    private double latitude;
    private double longitude;


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

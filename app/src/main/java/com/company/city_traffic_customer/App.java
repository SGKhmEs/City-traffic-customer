package com.company.city_traffic_customer;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

}

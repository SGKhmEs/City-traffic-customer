package com.company.city_traffic_customer.main;

import com.company.city_traffic_customer.model.DataBase;



class MainPresenter implements IMainPresenter {

    private IMainActivity activity;
    private DataBase dataBase;

    public MainPresenter(IMainActivity activity) {
        this.activity = activity;
        dataBase = DataBase.getDataBase();
    }
}

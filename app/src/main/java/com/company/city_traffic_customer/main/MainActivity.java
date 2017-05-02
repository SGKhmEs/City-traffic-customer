package com.company.city_traffic_customer.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TabHost;

import com.company.city_traffic_customer.R;
import com.company.city_traffic_customer.model.RouteTaxi;
import com.company.city_traffic_customer.model.Station;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    TabHost tabHost;
    IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createTabHost();

        createMapFragment();

        presenter = new MainPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    private void createTabHost() {
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tabSpec;
        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("",getResources().getDrawable(R.drawable.map));
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("",getResources().getDrawable(R.drawable.list));
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);
    }

    private void createMapFragment() {
        MapFragment fragment = new MapFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
}

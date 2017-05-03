package com.company.city_traffic_customer.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.SearchAutoComplete;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

import com.company.city_traffic_customer.R;
import com.company.city_traffic_customer.main.adapter.SearchAdapter;
import com.company.city_traffic_customer.model.Station;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements IMainActivity{

    private static final String TAG = "log";
    TabHost tabHost;
    IMainPresenter presenter;
    Toolbar toolbar;
    SearchView searchView;
    SearchAdapter searchAdapter;
    SearchAutoComplete searchAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createTabHost();

        createMapFragment();

        presenter = new MainPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);

        searchView = (SearchView) item.getActionView();

        searchAutoComplete = (SearchAutoComplete) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionClick(int position) {
                Log.w(TAG, "onSuggestionClick: ");
                return true;
            }

            @Override
            public boolean onSuggestionSelect(int position) {
                return true;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setSearchList();
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

    private void creteListFragment(){

    }

    @Override
    public void setSearchList(List<String> stations) {
        searchAdapter = new SearchAdapter(this, stations);
        searchAutoComplete.setAdapter(searchAdapter);
        Log.w(TAG, "setSearchList: ");
    }
}

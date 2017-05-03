package com.company.city_traffic_customer.traffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.company.city_traffic_customer.R;

public class TrafficActivity extends AppCompatActivity {

    private static final String TAG = "log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);

        Log.w(TAG, "onCreate: " + getIntent().getStringExtra("Station") );
    }
}

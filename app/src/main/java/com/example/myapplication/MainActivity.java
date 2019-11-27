package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String http="http://opendata.epa.gov.tw/ws/Data/ATM00625/?$format=json";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.idListView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new PmTask(MainActivity.this,listView).execute(new String[]{http});
        String sBranch1="wsx";
    }


}

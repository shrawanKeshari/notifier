package com.example.sonu.bietapp;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void aggregate_button(View view) {
        Intent intent = new Intent(MainActivity.this, AggrateActivity.class);
        startActivity(intent);
    }

    public void notices_button(View view) {
        Intent intent = new Intent(MainActivity.this, NoticeActivity.class);
        startActivity(intent);
    }
}

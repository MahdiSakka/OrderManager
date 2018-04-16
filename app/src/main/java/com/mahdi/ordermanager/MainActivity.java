package com.mahdi.ordermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mahdi.ordermanager.dbmanager.DataBaseHandler;

public class MainActivity extends AppCompatActivity {
    DataBaseHandler dataBaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            dataBaseHandler = new DataBaseHandler(this);
        }
        catch (Exception e) {
            // TODO: do not proceed and STOP (FATAL ERROR)
        }
    }
}

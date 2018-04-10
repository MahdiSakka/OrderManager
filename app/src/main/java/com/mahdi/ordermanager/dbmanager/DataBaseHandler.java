package com.mahdi.ordermanager.dbmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mahdi.ordermanager.dbmanager.dao.UserDAO;

public class DataBaseHandler extends SQLiteOpenHelper {
    // database name
    public static final String DATABASE_NAME = "ORDER_MANAGER";
    // database current version
    public static final int DATABASE_VERSION = 1;

    private UserDAO userDAO;

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // create the database tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        CreateTables();
    }

    // upgrade tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        DropTables();
        CreateTables();
    }

    private void CreateTables() {

    }

    private void DropTables() {

    }
}

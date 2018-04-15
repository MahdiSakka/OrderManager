package com.mahdi.ordermanager.dbmanager.dao;

import android.database.sqlite.SQLiteDatabase;

public class CustomerDAO {
    private SQLiteDatabase database;
    public static final String KEY = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String PHONE_NUMBER = "phone";
    public static final String FIRST_DATE = "firstDate";
    public static final String LAST_VISIT = "lastVisit";
    public static final String FACEBOOK_PROFILE = "facebook";
    public static final String LOYALTY_POINTS = "loyalty";
    public static final String TABLE_NAME = "CUSTOMER";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FIRST_NAME + " VARCHAR(20) NOT NULL, " +
            LAST_NAME + " VARCHAR(20), " +
            PHONE_NUMBER + " VARCHAR(20), " +
            FIRST_DATE + " DATETIME NOT NULL, " +
            LAST_VISIT + " DATETIME NOT NULL, " +
            FACEBOOK_PROFILE + " TEXT, " +
            LOYALTY_POINTS + " INTEGER);";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public CustomerDAO(SQLiteDatabase database) {
        this.database = database;
    }

    public void createTable() {
        this.database.execSQL(CREATE_TABLE);
    }

    public void removeTable() {
        this.database.execSQL(DROP_TABLE);
    }
}

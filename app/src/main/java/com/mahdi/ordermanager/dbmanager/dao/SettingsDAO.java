package com.mahdi.ordermanager.dbmanager.dao;

import android.database.sqlite.SQLiteDatabase;

public class SettingsDAO {
    private SQLiteDatabase database;

    public static final String TABLE_NAME = "SETTINGS";
    private static final String NAME = "name";
    private static final String VALUE = "value";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            NAME + " VARCHAR(30) PRIMARY KEY NOT NULL, " +
            VALUE + "VARCHAR(30) " +
            ");";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public SettingsDAO(SQLiteDatabase database) {
        this.database = database;
    }

    public void createTable () {
        database.execSQL(CREATE_TABLE);
    }

    public void removeTable () {
        database.execSQL(DROP_TABLE);
    }
}

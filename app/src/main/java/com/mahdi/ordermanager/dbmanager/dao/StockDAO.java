package com.mahdi.ordermanager.dbmanager.dao;

import android.database.sqlite.SQLiteDatabase;

public class StockDAO {
    private SQLiteDatabase database;

    private static final String TABLE_NAME = "STOCK";
    private static final String KEY = "id";
    private static final String TYPE = "type";
    private static final String SUBTYPE = "subtype";
    private static final String QUANTITY = "quantity";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TYPE + " INTEGER NOT NULL, " +
                    SUBTYPE + " INTEGER, " +
                    QUANTITY + " INTEGER" +
                    ");";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public StockDAO(SQLiteDatabase database) {
        this.database = database;
    }

    public void createTable() {
        database.execSQL(CREATE_TABLE);
    }

    public void removeTable() {
        database.execSQL(DROP_TABLE);
    }
}

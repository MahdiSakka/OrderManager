package com.mahdi.ordermanager.dbmanager.dao;

import android.database.sqlite.SQLiteDatabase;

import com.mahdi.ordermanager.dbmanager.model.Product;

public class ProductDAO {
    private SQLiteDatabase database;

    public static final String KEY = "id";
    public static final String TYPE = "type";
    public static final String SUB_TYPE = "subType";
    public static final String DESCRIPTION = "description";

    private static final String TABLE_NAME = "PRODUCTS";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TYPE + " INTEGER NOT NULL, " +
            SUB_TYPE + " INTEGER, " +
            DESCRIPTION + " TEXT);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public ProductDAO(SQLiteDatabase database) {
        this.database = database;
    }

    public void createTable () {
        this.database.execSQL(CREATE_TABLE);
    }

    public void removeTable() {
        this.database.execSQL(DROP_TABLE);
    }

    public void addProduct (Product product) {

    }
}

package com.mahdi.ordermanager.dbmanager.dao;

import android.database.sqlite.SQLiteDatabase;

import com.mahdi.ordermanager.dbmanager.model.Product;

public class ProductDAO {
    private SQLiteDatabase database;

    public static final String KEY = "id";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String SUB_TYPE = "subtype";
    public static final String DESCRIPTION = "description";
    public static final String TASTE = "taste";
    public static final String SIZE = "size";
    public static final String STOCK = "stock";
    public static final String UNIT_PRICE = "unitprice";

    public static final String TABLE_NAME = "PRODUCTS";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " VARCAHR(30) NOT NULL UNIQUE, " +
            TYPE + " INTEGER NOT NULL, " +
            SUB_TYPE + " INTEGER, " +
            TASTE + " INTEGER, " +
            SIZE + " INTEGER, " +
            STOCK + " INTEGER CHECK (" + STOCK + " >= 0), " +
            UNIT_PRICE + " INTEGER NOT NULL, " +
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

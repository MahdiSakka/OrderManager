package com.mahdi.ordermanager.dbmanager.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.mahdi.ordermanager.dbmanager.model.Command;
import com.mahdi.ordermanager.dbmanager.model.Product;

import javafx.scene.control.Tab;

public class CommandLinesDAO {
    private SQLiteDatabase database;

    public static final String TABLE_NAME = "COMMAND_LINES";
    public static final String KEY = "id";
    public static final String COMMAND_ID = "commandID";
    public static final String PRODUCT_ID = "productID";
    public static final String QUANTITY = "quantity";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " +
                    KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COMMAND_ID + " INTEGER NOT NULL, " +
                    PRODUCT_ID + " INTEGER NOT NULL, " +
                    QUANTITY + " INTEGER, " +
            "CONSTRAINT FK1 FOREIGN KEY " + COMMAND_ID + " REFERENCES " + CommandDAO.TABLE_NAME + "(" + CommandDAO.KEY + "), " +
            "CONSTRAINT FK2 FOREIGN KEY " + PRODUCT_ID + " REFERENCES " + ProductDAO.TABLE_NAME + "(" + ProductDAO.KEY + ")," +
            "PRIMARY KEY (" + COMMAND_ID + ", " + PRODUCT_ID + "));";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public CommandLinesDAO (SQLiteDatabase database) {
        this.database = database;
    }

    public void createTable () {
        this.database.execSQL(CREATE_TABLE);
    }

    public void removeTable() {
        this.database.execSQL(DROP_TABLE);
    }

    public void addCommandLine (Product product, int quantity, Command command) {
        ContentValues values = new ContentValues();
        values.putNull(KEY);
        values.put(COMMAND_ID, command.getId());
        values.put(PRODUCT_ID, product.getId());
        values.put(QUANTITY, quantity);
        database.insert(TABLE_NAME, null, values);
    }
}

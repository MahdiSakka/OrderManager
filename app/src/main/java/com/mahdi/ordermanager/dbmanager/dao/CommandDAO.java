package com.mahdi.ordermanager.dbmanager.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.mahdi.ordermanager.dbmanager.model.Command;

public class CommandDAO {
    public static final String TABLE_NAME = "COMMAND";
    public static final String KEY = "id";
    public static final String CUSTOMER_ID = "customer";
    public static final String TOTAL_AMOUNT = "totalAmount";
    public static final String REMAINING_AMOUNT = "remainingAmount";
    public static final String DEPOSIT_AMOUNT = "depositAmount";
    public static final String ORDER_DATE = "orderDate";
    public static final String DELIVERY_DATE = "deliveryDate";
    public static final String NOTES = "notes";
    public static final String PICTURE = "picture";
    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
            KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CUSTOMER_ID + " INTEGER, " +
            TOTAL_AMOUNT + " INTEGER CHECK (" + TOTAL_AMOUNT + "  > 0), " +
            REMAINING_AMOUNT + " INTEGER CHECK (" + REMAINING_AMOUNT + " > 0), " +
            DEPOSIT_AMOUNT + " INTEGER CHECK (" + DEPOSIT_AMOUNT + " > 0), " +
            ORDER_DATE + " DATETIME NOT NULL, " +
            DELIVERY_DATE + " DATETIME NOT NULL, " +
            NOTES + " TEXT, " +
            PICTURE + " TEXT, " +
            "FOREIGN KEY (" + CUSTOMER_ID + ") REFERENCES CUSTOMER(id)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    private SQLiteDatabase database;

    public CommandDAO (SQLiteDatabase database) {
        this.database = database;
    }

    public void createTable() {
        this.database.execSQL(TABLE_CREATE);
    }

    public void removeTable() {
        this.database.execSQL(DROP_TABLE);
    }

    public void add(Command command) {
        ContentValues values = new ContentValues();
        values.putNull(KEY); // auto-incremented
        values.put(CUSTOMER_ID, command.getCustomer().getId()); // foreign key
        values.put(TOTAL_AMOUNT, command.getTotalAmount());
        values.put(REMAINING_AMOUNT, command.getRemainingAmount());
        values.put(DEPOSIT_AMOUNT, command.getDepositAmount());
        values.put(ORDER_DATE, command.getOrderDate().toString());
        values.put(DELIVERY_DATE, command.getDeliveryDate().toString());
        values.put(NOTES, command.getNotes());
        values.put(PICTURE, command.getPicture());

        // insert the record
        this.database.insert(TABLE_NAME, null, values);
    }
}

package com.mahdi.ordermanager.dbmanager.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mahdi.ordermanager.dbmanager.model.Settings;

public class SettingsDAO {
    private SQLiteDatabase database;

    public static final String TABLE_NAME = "SETTINGS";
    private static final String NAME = "name";
    private static final String VALUE = "value";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            NAME + " VARCHAR(30) PRIMARY KEY NOT NULL, " +
            VALUE + " VARCHAR(30) " +
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

    // returns the number of settings
    public int load(Settings settings) {
        int count = 0;
        Cursor cursor = database.rawQuery("SELECT " + NAME + ", " + VALUE + " FROM " + TABLE_NAME, null);
        count = cursor.getCount();
        settings.clear(); // clear the settings elements
        while (cursor.moveToNext()) {
            settings.add(cursor.getString(0), cursor.getString(1));
        }
        return count;
    }

    public void save(String name, String value) {
        database.rawQuery("UPDATE " + TABLE_NAME + " SET " + VALUE + " = ? WHERE " + NAME + " = ?",
                new String[]{name, value});
    }
}

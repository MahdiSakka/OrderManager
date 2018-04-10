package com.mahdi.ordermanager.dbmanager.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.mahdi.ordermanager.dbmanager.model.User;

public class UserDAO {
    public static final String TABLE_NAME = "USER";
    public static final String KEY = "id";
    public static final String NAME = "name";
    public static final String ROLE = "role";
    public static final String PASSWORD = "password";
    public static final String LAST_ACCESS = "lastAccess";
    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" +
                                                KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                NAME + " VARCHAR(20) NOT NULL, " +
                                                ROLE + " INTEGER, " +
                                                PASSWORD + " VARCHAR(12) NOT NULL, " +
                                                LAST_ACCESS + " DATETIME);";
    public static final String TABLE_REMOVE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    private SQLiteDatabase database;

    public UserDAO (SQLiteDatabase database) {
        this.database = database;
    }

    public void createTable() {
        database.execSQL(TABLE_CREATE);
    }

    public void removeTable () {
        database.execSQL(TABLE_REMOVE);
    }

    public void addUser (User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserDAO.NAME, user.getName());
        contentValues.put(UserDAO.ROLE, user.getRole().ordinal());
        contentValues.put(UserDAO.PASSWORD, user.getPassword());
        contentValues.putNull(UserDAO.KEY); // AUTOINCREMENT, should be null
        contentValues.putNull(UserDAO.LAST_ACCESS); // suppose no last access

        database.insert(TABLE_NAME, null, contentValues);
    }

    public void removeUser(User user) {
        database.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(user.getId())});
    }
}

package com.mahdi.ordermanager.dbmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mahdi.ordermanager.dbmanager.dao.CommandDAO;
import com.mahdi.ordermanager.dbmanager.dao.CommandLinesDAO;
import com.mahdi.ordermanager.dbmanager.dao.CustomerDAO;
import com.mahdi.ordermanager.dbmanager.dao.ProductDAO;
import com.mahdi.ordermanager.dbmanager.dao.SettingsDAO;
import com.mahdi.ordermanager.dbmanager.dao.StockDAO;
import com.mahdi.ordermanager.dbmanager.dao.UserDAO;
import com.mahdi.ordermanager.dbmanager.model.Settings;

public class DataBaseHandler extends SQLiteOpenHelper {
    // database name
    public static final String DATABASE_NAME = "ORDER_MANAGER";
    // database current version
    public static final int DATABASE_VERSION = 1;

    private UserDAO userDAO;
    private CommandDAO commandDAO;
    private CustomerDAO customerDAO;
    private ProductDAO productDAO;
    private CommandLinesDAO commandLinesDAO;
    private SettingsDAO settingsDAO;
    private StockDAO stockDAO;

    private SQLiteDatabase database;

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        try {
            database = this.getWritableDatabase();
            initHandlers();
        }
        catch (Exception e) {
            database = null;
        }
    }

    // create the database tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.database = db;
        initHandlers();
        createTables();
    }

    // upgrade tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.database = db;
        initHandlers();
        dropTables();
        createTables();
    }

    private void initHandlers() {
        userDAO = new UserDAO(database);
        productDAO = new ProductDAO(database);
        customerDAO = new CustomerDAO(database);
        commandDAO = new CommandDAO(database);
        commandLinesDAO = new CommandLinesDAO(database);
        settingsDAO = new SettingsDAO(database);
        stockDAO = new StockDAO(database);
    }

    private void createTables() {
        userDAO.createTable();
        productDAO.createTable();
        customerDAO.createTable();
        commandDAO.createTable();
        commandLinesDAO.createTable();
        settingsDAO.createTable();
        stockDAO.createTable();
    }

    private void dropTables() {
        userDAO.removeTable();
        productDAO.removeTable();
        customerDAO.removeTable();
        commandDAO.removeTable();
        commandLinesDAO.removeTable();
        settingsDAO.removeTable();
        stockDAO.removeTable();
    }
}

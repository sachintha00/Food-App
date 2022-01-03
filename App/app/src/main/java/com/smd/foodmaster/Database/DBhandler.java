package com.smd.foodmaster.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FoodMasterDataBase.db";

    public DBhandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FoodMasterDB.Users.TABLE_NAME + " (" +
                    FoodMasterDB.Users._ID + " INTEGER PRIMARY KEY," +
                    FoodMasterDB.Users.COLUMN_FIRST_NAME + " TEXT," +
                    FoodMasterDB.Users.COLUMN_LAST_NAME + " TEXT," +
                    FoodMasterDB.Users.COLUMN_USER_ADDRESS + " TEXT," +
                    FoodMasterDB.Users.COLUMN_USER_GMAIL + " TEXT," +
                    FoodMasterDB.Users.COLUMN_USER_MOBILE + " TEXT," +
                    FoodMasterDB.Users.COLUMN_GENDER + " TEXT," +
                    FoodMasterDB.Users.COLUMN_NIC + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FoodMasterDB.Users.TABLE_NAME;
}

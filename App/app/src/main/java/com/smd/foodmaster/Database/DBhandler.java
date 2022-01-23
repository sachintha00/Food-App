package com.smd.foodmaster.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.List;

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

    public long addUserDetails(String rollName, String firstName, String lastName, String address,
                               String gmail, String mobile, String gender, String nic){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FoodMasterDB.Users.COLUMN_ROLL_NAME, rollName);
        values.put(FoodMasterDB.Users.COLUMN_FIRST_NAME, firstName);
        values.put(FoodMasterDB.Users.COLUMN_LAST_NAME, lastName);
        values.put(FoodMasterDB.Users.COLUMN_USER_ADDRESS, address);
        values.put(FoodMasterDB.Users.COLUMN_USER_GMAIL, gmail);
        values.put(FoodMasterDB.Users.COLUMN_USER_MOBILE, mobile);
        values.put(FoodMasterDB.Users.COLUMN_GENDER, gender);
        values.put(FoodMasterDB.Users.COLUMN_NIC, nic);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FoodMasterDB.Users.TABLE_NAME, null, values);

        return newRowId;
    }

    public long addLoginAuthen(String rollId, String rollName, String username, String password){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FoodMasterDB.LoginAuhten.COLUMN_ROLLID, rollId);
        values.put(FoodMasterDB.LoginAuhten.COLUMN_ROLLNAME, rollName);
        values.put(FoodMasterDB.LoginAuhten.COLUMN_USERNAME, username);
        values.put(FoodMasterDB.LoginAuhten.COLUMN_PASSWORD, password);

        // Insert the new row, returning the primary key value of the new row
        return db.insert(FoodMasterDB.LoginAuhten.TABLE_NAME, null, values);
    }

    public List readInfo(){
        SQLiteDatabase dbObj = getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                FoodMasterDB.Users.COLUMN_FIRST_NAME,
                FoodMasterDB.Users.COLUMN_LAST_NAME,
                FoodMasterDB.Users.COLUMN_GENDER,
                FoodMasterDB.Users.COLUMN_NIC,
                FoodMasterDB.Users.COLUMN_USER_ADDRESS,
                FoodMasterDB.Users.COLUMN_USER_GMAIL,
                FoodMasterDB.Users.COLUMN_USER_MOBILE,
        };

        // Filter results WHERE "title" = 'My Title'
//        String selection = FoodMasterDB.Users. + " = ?";
//        String[] selectionArgs = { "My Title" };

        return null;
    }

    public String readInfo(String username, String password){
        SQLiteDatabase dbObj = getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                FoodMasterDB.LoginAuhten.COLUMN_ROLLID,
                FoodMasterDB.LoginAuhten.COLUMN_ROLLNAME,
                FoodMasterDB.LoginAuhten.COLUMN_USERNAME,
                FoodMasterDB.LoginAuhten.COLUMN_PASSWORD
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = FoodMasterDB.LoginAuhten.COLUMN_USERNAME + " = ? AND"
                + FoodMasterDB.LoginAuhten.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = { username, password};

        Cursor cursor = dbObj.query(
                FoodMasterDB.LoginAuhten.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        
        return cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.LoginAuhten.COLUMN_ROLLID));
    }
}

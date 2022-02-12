package com.smd.foodmaster.Database;

//public class DBhandler extends SQLiteOpenHelper
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBhandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "userdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // creating a constructor for our database handler.
    public DBhandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + FoodMasterDB.Users.TABLE_NAME + " ("
                + FoodMasterDB.Users.COLUMN_ROLL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FoodMasterDB.Users.COLUMN_ROLL_NAME + " TEXT,"
                + FoodMasterDB.Users.COLUMN_FIRST_NAME + " TEXT,"
                + FoodMasterDB.Users.COLUMN_LAST_NAME + " TEXT,"
                + FoodMasterDB.Users.COLUMN_USER_ADDRESS + " TEXT,"
                + FoodMasterDB.Users.COLUMN_USER_GMAIL + " TEXT,"
                + FoodMasterDB.Users.COLUMN_USER_MOBILE + " TEXT,"
                + FoodMasterDB.Users.COLUMN_GENDER + " TEXT,"
                + FoodMasterDB.Users.COLUMN_NIC + " TEXT, "
                + FoodMasterDB.Users.COLUMN_USERNAME + " TEXT, "
                + FoodMasterDB.Users.COLUMN_PASSWORD + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public long addUserDetails(String rollName, String firstName, String lastName, String address,
                               String gmail, String mobile, String gender, String nic,String username, String password) throws SQLException {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(FoodMasterDB.Users.COLUMN_ROLL_NAME, rollName);
        values.put(FoodMasterDB.Users.COLUMN_FIRST_NAME, firstName);
        values.put(FoodMasterDB.Users.COLUMN_LAST_NAME, lastName);
        values.put(FoodMasterDB.Users.COLUMN_USER_ADDRESS, address);
        values.put(FoodMasterDB.Users.COLUMN_USER_GMAIL, gmail);
        values.put(FoodMasterDB.Users.COLUMN_USER_MOBILE, mobile);
        values.put(FoodMasterDB.Users.COLUMN_GENDER, gender);
        values.put(FoodMasterDB.Users.COLUMN_NIC, nic);
        values.put(FoodMasterDB.Users.COLUMN_USERNAME, username);
        values.put(FoodMasterDB.Users.COLUMN_PASSWORD, password);

        // after adding all values we are passing
        // content values to our table.
        long id  = db.insert(FoodMasterDB.Users.TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();

        return id;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + FoodMasterDB.Users.TABLE_NAME);
        onCreate(db);
    }

//    you can using one method of bellow methods for reading one raw using sqlite data base

    public String readLogin(String username, String password) {
        // array of columns to fetch
        String[] columns = {
                FoodMasterDB.Users.COLUMN_ROLL_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = FoodMasterDB.Users.COLUMN_USERNAME + " = ?" + " AND " + FoodMasterDB.Users.COLUMN_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {username, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(FoodMasterDB.Users.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();
        String val = null;
        if (cursor.moveToFirst()) {
            do {
                val = cursor.getString(cursor.getColumnIndexOrThrow("RollID"));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return val;
    }

//    public String readLogin(String username, String password) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from "+FoodMasterDB.Users.TABLE_NAME+" WHERE "+FoodMasterDB.Users.COLUMN_USERNAME +" = '" + username + "'",null);
//        String val = null;
//        if (res != null && res.moveToFirst()) {
//            do {
//                //Call Your Function
//                val = res.getString(res.getColumnIndexOrThrow("NIC"));
//            }
//            while (res.moveToNext());
//        }
//        return val;
//    }

    public List<String> readUser(String rollId) {
        // array of columns to fetch
        String[] columns = {
                FoodMasterDB.Users.COLUMN_FIRST_NAME,
                FoodMasterDB.Users.COLUMN_LAST_NAME,
                FoodMasterDB.Users.COLUMN_USER_ADDRESS,
                FoodMasterDB.Users.COLUMN_USER_GMAIL,
                FoodMasterDB.Users.COLUMN_USER_MOBILE,
                FoodMasterDB.Users.COLUMN_GENDER,
                FoodMasterDB.Users.COLUMN_NIC,
                FoodMasterDB.Users.COLUMN_USERNAME,
                FoodMasterDB.Users.COLUMN_PASSWORD,
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = FoodMasterDB.Users.COLUMN_ROLL_ID + " = ?";

        // selection arguments
        String[] selectionArgs = {rollId};


        Cursor cursor = db.query(FoodMasterDB.Users.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();
        List<String> User = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                User.add(cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.Users.COLUMN_FIRST_NAME)));     //0
                User.add(cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.Users.COLUMN_LAST_NAME)));      //1
                User.add(cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.Users.COLUMN_USER_ADDRESS)));   //2
                User.add(cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.Users.COLUMN_USER_GMAIL)));     //3
                User.add(cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.Users.COLUMN_USER_MOBILE)));    //4
                User.add(cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.Users.COLUMN_GENDER)));         //5
                User.add(cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.Users.COLUMN_NIC)));            //6
                User.add(cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.Users.COLUMN_USERNAME)));       //7
                User.add(cursor.getString(cursor.getColumnIndexOrThrow(FoodMasterDB.Users.COLUMN_PASSWORD)));       //8
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return User;
    }

    public boolean updateUserDetails(String rollId, String firstName, String lastName, String address,
                               String gmail, String mobile, String gender, String nic) throws SQLException {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(FoodMasterDB.Users.COLUMN_FIRST_NAME, firstName);
        values.put(FoodMasterDB.Users.COLUMN_LAST_NAME, lastName);
        values.put(FoodMasterDB.Users.COLUMN_USER_ADDRESS, address);
        values.put(FoodMasterDB.Users.COLUMN_USER_GMAIL, gmail);
        values.put(FoodMasterDB.Users.COLUMN_USER_MOBILE, mobile);
        values.put(FoodMasterDB.Users.COLUMN_GENDER, gender);
        values.put(FoodMasterDB.Users.COLUMN_NIC, nic);

        String selection = FoodMasterDB.Users.COLUMN_ROLL_ID + " LIKE ?";
        String[] selectionArgs = { rollId };

        int count = db.update(
                FoodMasterDB.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        db.close();

        if(count>0){
            return true;
        }

        return false;
    }
    public boolean updateAuthDetails(String rollId, String username, String password) throws SQLException {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(FoodMasterDB.Users.COLUMN_USERNAME, username);
        values.put(FoodMasterDB.Users.COLUMN_PASSWORD, password);

        String selection = FoodMasterDB.Users.COLUMN_ROLL_ID + " LIKE ?";
        String[] selectionArgs = { rollId };

        int count = db.update(
                FoodMasterDB.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        db.close();

        if(count>0){
            return true;
        }

        return false;
    }
}

//one raw data reading methods end line
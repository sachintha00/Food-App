package com.smd.foodmaster.Database;

//public class DBhandler extends SQLiteOpenHelper
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

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

    public String readLogin(String username, String password) {
            SQLiteDatabase db = this.getReadableDatabase();

            // on below line we are creating a cursor with query to read data from database.
            Cursor cursorCourses = db.rawQuery("SELECT * FROM "+FoodMasterDB.Users.TABLE_NAME+" WHERE "+FoodMasterDB.Users.COLUMN_USERNAME +" ='"+username+"' AND "+FoodMasterDB.Users.COLUMN_PASSWORD+" ='"+password+"'", null);
//        +" WHERE "+FoodMasterDB.Users.COLUMN_USERNAME +" ='"+username+"' AND "+FoodMasterDB.Users.COLUMN_PASSWORD+" ='"+password+"'"

            // on below line we are creating a new array list.
            String uname= cursorCourses.getString(cursorCourses.getColumnIndexOrThrow("Username"));

            // moving our cursor to first position.
//            if (cursorCourses.moveToFirst()) {
//                do {
//                    // on below line we are adding the data from cursor to our array list.
////                    courseModalArrayList.add(new CourseModal(cursorCourses.getString(1),
////                            cursorCourses.getString(4),
////                            cursorCourses.getString(2),
////                            cursorCourses.getString(3)));
//                    if(username == cursorCourses.getString(cursorCourses.getColumnIndexOrThrow("Username"))
//                            && password == cursorCourses.getString(cursorCourses.getColumnIndexOrThrow("Password"))){
//                        uname = "find it";
//                    }
//                } while (cursorCourses.moveToNext());
//                // moving our cursor to next.
//            }
            // at last closing our cursor
            // and returning our array list.
            cursorCourses.close();
            return uname;
    }
}

package com.smd.foodmaster.Database;

import android.provider.BaseColumns;

public final class FoodMasterDB {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FoodMasterDB() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "UserDetails";
        public static final String COLUMN_ROLL_ID = "RollID";
        public static final String COLUMN_ROLL_NAME = "RollName";
        public static final String COLUMN_FIRST_NAME = "FirstName";
        public static final String COLUMN_LAST_NAME = "LastName";
        public static final String COLUMN_USER_ADDRESS = "Address";
        public static final String COLUMN_USER_GMAIL = "Gmail";
        public static final String COLUMN_USER_MOBILE = "MobileNumber";
        public static final String COLUMN_GENDER = "Gender";
        public static final String COLUMN_NIC = "NIC";
        public static final String COLUMN_USERNAME = "Username";
        public static final String COLUMN_PASSWORD = "Password";
    }
}

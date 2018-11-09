package com.example.myapplication;

import android.provider.BaseColumns;

/**
 * Created by Asus on 1/21/2018.
 */

public final class Tableinfo {

    private Tableinfo(){}

    public static final class spending1detail implements BaseColumns{

        public static final String COL0 = "ID";
        public static final String COL1 = "Spendings";
        public static final String COL2 = "Amount";
        public static final String TABLE_NAME = "Essentials";
    }

    public static final class spending2detail implements BaseColumns{

        public static final String COL0 = "ID";
        public static final String COL1 = "Spendings";
        public static final String COL2 = "Amount";
        public static final String TABLE_NAME = "Travel";
    }

    public static final class spending3detail implements BaseColumns{

        public static final String COL0 = "ID";
        public static final String COL1 = "Spendings";
        public static final String COL2 = "Amount";
        public static final String TABLE_NAME = "Entertainment";
    }

    public static final class spending4detail implements BaseColumns{

        public static final String COL0 = "ID";
        public static final String COL1 = "Spendings";
        public static final String COL2 = "Amount";
        public static final String TABLE_NAME = "Miscellaneous";
    }

}

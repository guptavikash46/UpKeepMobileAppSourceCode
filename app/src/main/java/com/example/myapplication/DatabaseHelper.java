package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Asus on 1/21/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "INFO.db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_QUERY_TABLE1 = "CREATE TABLE " + Tableinfo.spending1detail.TABLE_NAME + " (" + Tableinfo.spending1detail.COL0 +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + Tableinfo.spending1detail.COL1 + " TEXT," + Tableinfo.spending1detail.COL2 + " INTEGER);";

    public static final String CREATE_QUERY_TABLE2 = "CREATE TABLE " + Tableinfo.spending2detail.TABLE_NAME + " (" + Tableinfo.spending2detail.COL0 +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + Tableinfo.spending2detail.COL1 + " TEXT," + Tableinfo.spending2detail.COL2 + " INTEGER);";

    public static final String CREATE_QUERY_TABLE3 = "CREATE TABLE " + Tableinfo.spending3detail.TABLE_NAME + " (" + Tableinfo.spending3detail.COL0 +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + Tableinfo.spending3detail.COL1 + " TEXT," + Tableinfo.spending3detail.COL2 + " INTEGER);";

    public static final String CREATE_QUERY_TABLE4 = "CREATE TABLE " + Tableinfo.spending4detail.TABLE_NAME + " (" + Tableinfo.spending4detail.COL0 +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + Tableinfo.spending4detail.COL1 + " TEXT," + Tableinfo.spending4detail.COL2 + " INTEGER);";


    ContentValues contentValues = new ContentValues();
    SQLiteDatabase db, dbreadDesc;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY_TABLE1);
        Log.d("Table operations", "Table 1 created succesfully");
        sqLiteDatabase.execSQL(CREATE_QUERY_TABLE2);
        Log.d("Table operations", "Table 2 created succesfully");
        sqLiteDatabase.execSQL(CREATE_QUERY_TABLE3);
        Log.d("Table operations", "Table 3 created succesfully");
        sqLiteDatabase.execSQL(CREATE_QUERY_TABLE4);
        Log.d("Table operations", "Table 4 created succesfully");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operations", "DATABASE created successfully.");
    }

    public void AddDataTable1(String desc, Double amt) {
        db = this.getWritableDatabase();
        contentValues.put(Tableinfo.spending1detail.COL1, desc);
        contentValues.put(Tableinfo.spending1detail.COL2, amt);
        db.insert(Tableinfo.spending1detail.TABLE_NAME, null, contentValues);
        Log.d("Database operations", "Data inserted in Table1 succesfully.");
    }


    public void AddDataTable2(String desc, double amt) {
        db = this.getWritableDatabase();
        contentValues.put(Tableinfo.spending2detail.COL1, desc);
        contentValues.put(Tableinfo.spending2detail.COL2, amt);
        db.insert(Tableinfo.spending2detail.TABLE_NAME, null, contentValues);
        Log.d("Database operations", "Data inserted in Table2 succesfully.");
    }

    public void AddDataTable3(String desc, double amt) {
        db = this.getWritableDatabase();
        contentValues.put(Tableinfo.spending3detail.COL1, desc);
        contentValues.put(Tableinfo.spending3detail.COL2, amt);
        db.insert(Tableinfo.spending3detail.TABLE_NAME, null, contentValues);
        Log.d("Database operations", "Data inserted in Table3 succesfully.");
    }

    public void AddDataTable4(String desc, double amt) {
        db = this.getWritableDatabase();
        contentValues.put(Tableinfo.spending4detail.COL1, desc);
        contentValues.put(Tableinfo.spending4detail.COL2, amt);
        db.insert(Tableinfo.spending4detail.TABLE_NAME, null, contentValues);
        Log.d("Database operations", "Data inserted in Table4 succesfully.");
    }

    public Cursor ShowDataTable1() {
        SQLiteDatabase db2 = this.getReadableDatabase();
        String[] columns = {Tableinfo.spending1detail.COL0, Tableinfo.spending1detail.COL1, Tableinfo.spending1detail.COL2};
        Cursor cr = db2.query(Tableinfo.spending1detail.TABLE_NAME, columns, null, null, null, null, null);
        return cr;
    }

    public Cursor ShowDataTable2() {
        SQLiteDatabase db3 = this.getReadableDatabase();
        String[] col = {Tableinfo.spending2detail.COL0, Tableinfo.spending2detail.COL1, Tableinfo.spending2detail.COL2};
        Cursor cr = db3.query(Tableinfo.spending2detail.TABLE_NAME, col, null, null, null, null, null);
        return cr;
    }

    public Cursor ShowDataTable3() {
        SQLiteDatabase db4 = this.getReadableDatabase();
        String[] col = {Tableinfo.spending3detail.COL0, Tableinfo.spending3detail.COL1, Tableinfo.spending3detail.COL2};
        Cursor cr = db4.query(Tableinfo.spending3detail.TABLE_NAME,col, null, null, null, null, null);
        return cr;
    }

    public Cursor ShowDataTable4() {
        SQLiteDatabase db5 = this.getReadableDatabase();
        String[] col = {Tableinfo.spending4detail.COL0, Tableinfo.spending4detail.COL1, Tableinfo.spending4detail.COL2};
        Cursor cr = db5.query(Tableinfo.spending4detail.TABLE_NAME, col, null, null, null, null, null);
        return cr;
    }

    public Cursor ShowsumTable1() {
        SQLiteDatabase db6 = this.getReadableDatabase();
        Cursor cr6 = db6.rawQuery("SELECT SUM(Amount) " + Tableinfo.spending1detail.COL2 + " FROM " + Tableinfo.spending1detail.TABLE_NAME + " ;", null);
        return cr6;
    }

    public Cursor ShowsumTable2() {
        SQLiteDatabase db7 = this.getReadableDatabase();
        Cursor cr6 = db7.rawQuery("SELECT SUM(Amount) " + Tableinfo.spending2detail.COL2 + " FROM " + Tableinfo.spending2detail.TABLE_NAME + " ;", null);
        return cr6;
    }

    public Cursor ShowsumTable3() {
        SQLiteDatabase db8 = this.getReadableDatabase();
        Cursor cr7 = db8.rawQuery("SELECT SUM(Amount) " + Tableinfo.spending3detail.COL2 + " FROM " + Tableinfo.spending3detail.TABLE_NAME + " ;", null);
        return cr7;

    }

    public Cursor ShowsumTable4() {
        SQLiteDatabase db9 = this.getReadableDatabase();
        Cursor cr8 = db9.rawQuery("SELECT SUM(Amount) " + Tableinfo.spending4detail.COL2 + " FROM " + Tableinfo.spending4detail.TABLE_NAME + " ;", null);
        return cr8;

    }

    public void deleteData1(int id) {
        db = this.getWritableDatabase();
        db.delete(Tableinfo.spending1detail.TABLE_NAME, Tableinfo.spending1detail.COL0+ " = "+ id,null);
    }
    public void deleteData2(int id) {
        db = this.getWritableDatabase();
        db.delete(Tableinfo.spending2detail.TABLE_NAME, Tableinfo.spending2detail.COL0+ " = "+ id,null);
    }
    public void deleteData3(int id) {
        db = this.getWritableDatabase();
        db.delete(Tableinfo.spending3detail.TABLE_NAME, Tableinfo.spending3detail.COL0+ " = "+ id,null);
    }
    public void deleteData4(int id) {
        db = this.getWritableDatabase();
        db.delete(Tableinfo.spending4detail.TABLE_NAME, Tableinfo.spending4detail.COL0+ " = "+ id,null);
    }

    public void updateData1(int ID,String descnew, Double amtnew){
      SQLiteDatabase  dbwriteDesc = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Tableinfo.spending1detail.COL1, descnew);
        cv.put(Tableinfo.spending1detail.COL2, amtnew);
        dbwriteDesc.update(Tableinfo.spending1detail.TABLE_NAME, cv, Tableinfo.spending1detail.COL0+"="+ID, null);

    }
    public void updateData2(int ID,String descnew, Double amtnew){
        SQLiteDatabase  dbwriteDesc = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Tableinfo.spending2detail.COL1, descnew);
        cv.put(Tableinfo.spending2detail.COL2, amtnew);
        dbwriteDesc.update(Tableinfo.spending2detail.TABLE_NAME, cv, Tableinfo.spending2detail.COL0+"="+ID, null);

    }
    public void updateData3(int ID,String descnew, Double amtnew){
        SQLiteDatabase  dbwriteDesc = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Tableinfo.spending3detail.COL1, descnew);
        cv.put(Tableinfo.spending3detail.COL2, amtnew);
        dbwriteDesc.update(Tableinfo.spending3detail.TABLE_NAME, cv, Tableinfo.spending3detail.COL0+"="+ID, null);

    }
    public void updateData4(int ID,String descnew, Double amtnew){
        SQLiteDatabase  dbwriteDesc = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Tableinfo.spending4detail.COL1, descnew);
        cv.put(Tableinfo.spending4detail.COL2, amtnew);
        dbwriteDesc.update(Tableinfo.spending4detail.TABLE_NAME, cv, Tableinfo.spending4detail.COL0+"="+ID, null);

    }
    public Cursor ShowArowtable1(String condition){
            dbreadDesc = this.getReadableDatabase();
            String[] col = {Tableinfo.spending1detail.COL1, Tableinfo.spending1detail.COL2};
          return   dbreadDesc.query(Tableinfo.spending1detail.TABLE_NAME, col,Tableinfo.spending1detail.COL1+ " = ? ", new String[]{condition},null,null,null );

    }
    public Cursor ShowArowtable2(String condition){
        dbreadDesc = this.getReadableDatabase();
        String[] col = {Tableinfo.spending2detail.COL1, Tableinfo.spending2detail.COL2};
        return   dbreadDesc.query(Tableinfo.spending2detail.TABLE_NAME, col,Tableinfo.spending2detail.COL1+ " = ? ", new String[]{condition},null,null,null );

    }
    public Cursor ShowArowtable3(String condition){
        dbreadDesc = this.getReadableDatabase();
        String[] col = {Tableinfo.spending3detail.COL1, Tableinfo.spending3detail.COL2};
        return   dbreadDesc.query(Tableinfo.spending3detail.TABLE_NAME, col,Tableinfo.spending3detail.COL1+ " = ? ", new String[]{condition},null,null,null );

    }
    public Cursor ShowArowtable4(String condition){
        dbreadDesc = this.getReadableDatabase();
        String[] col = {Tableinfo.spending4detail.COL1, Tableinfo.spending4detail.COL2};
        return   dbreadDesc.query(Tableinfo.spending4detail.TABLE_NAME, col,Tableinfo.spending4detail.COL1+ " = ? ", new String[]{condition},null,null,null );

    }
    public Cursor SupplyID(String desc_cond){
        dbreadDesc = this.getReadableDatabase();
        String[] col = {Tableinfo.spending1detail.COL0};
        return  dbreadDesc.query(Tableinfo.spending1detail.TABLE_NAME, col, Tableinfo.spending1detail.COL1+ "= ? ", new String[] {desc_cond},null,null,null,null);
    }

    public Cursor SupplyID2(String desc_cond){
        dbreadDesc = this.getReadableDatabase();
        String[] col = {Tableinfo.spending2detail.COL0};
        return  dbreadDesc.query(Tableinfo.spending2detail.TABLE_NAME, col, Tableinfo.spending2detail.COL1+ "= ? ", new String[] {desc_cond},null,null,null,null);
    }
    public Cursor SupplyID3(String desc_cond){
        dbreadDesc = this.getReadableDatabase();
        String[] col = {Tableinfo.spending3detail.COL0};
        return  dbreadDesc.query(Tableinfo.spending3detail.TABLE_NAME, col, Tableinfo.spending3detail.COL1+ "= ? ", new String[] {desc_cond},null,null,null,null);
    }
    public Cursor SupplyID4(String desc_cond){
        dbreadDesc = this.getReadableDatabase();
        String[] col = {Tableinfo.spending4detail.COL0};
        return  dbreadDesc.query(Tableinfo.spending4detail.TABLE_NAME, col, Tableinfo.spending4detail.COL1+ "= ? ", new String[] {desc_cond},null,null,null,null);
    }

}

package com.example.myapplication;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Asus on 1/31/2018.
 */

public class ManageSpendings extends AppCompatActivity {
    Cursor cursor;
     DatabaseHelper dbhelper;
     ListView ls;
    MyCustomAdapter adapter;
    ListItems listItems;
    int id, id2,id3,id4;
    String tb1, tb2, tb3, tb4;
    Double parseAmt, parseAmt2, parseAmt3, parseAmt4, gross;
    @Override
    protected  void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.manage_spendings);
        init();
        mainAction();
    }

    public void init(){
      ls = findViewById(R.id.custom_listview);
      dbhelper = new DatabaseHelper(getApplicationContext());
      adapter = new MyCustomAdapter(getApplicationContext(),R.layout.listview_item_layout);
      ls.setAdapter(adapter);

    }



    public void mainAction(){
        String amt_value1, amt_value2, amt_value3, amt_value4;

        try {
            cursor = dbhelper.ShowsumTable1();
            id = cursor.getColumnIndex(Tableinfo.spending1detail.COL2);

            while (cursor.moveToNext()) {
                amt_value1 = cursor.getString(id);
                parseAmt = Double.parseDouble(amt_value1);
                tb1 = Tableinfo.spending1detail.TABLE_NAME;
                listItems = new ListItems(parseAmt, tb1);
                adapter.add(listItems);
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Spendings_1 details are not found.", Toast.LENGTH_SHORT).show();
        }
        try {
            cursor = dbhelper.ShowsumTable2();
            id2 = cursor.getColumnIndex(Tableinfo.spending2detail.COL2);
            while (cursor.moveToNext()) {
                amt_value2 = cursor.getString(id2);
                parseAmt2 = Double.parseDouble(amt_value2);
                tb2 = Tableinfo.spending2detail.TABLE_NAME;
                listItems = new ListItems(parseAmt2, tb2);
                adapter.add(listItems);
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Spendings_2 details are not found.", Toast.LENGTH_SHORT).show();
        }

        try {
            cursor = dbhelper.ShowsumTable3();
            id3 = cursor.getColumnIndex(Tableinfo.spending3detail.COL2);
            while (cursor.moveToNext()) {
                amt_value3 = cursor.getString(id3);
                parseAmt3 = Double.parseDouble(amt_value3);
                tb3 = Tableinfo.spending3detail.TABLE_NAME;
                listItems = new ListItems(parseAmt3, tb3);
                adapter.add(listItems);
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Spendings_3 details are not found.", Toast.LENGTH_SHORT).show();
        }
        try {
            cursor = dbhelper.ShowsumTable4();
            id4 = cursor.getColumnIndex(Tableinfo.spending4detail.COL2);
            while (cursor.moveToNext()) {
                amt_value4 = cursor.getString(id4);
                parseAmt4 = Double.parseDouble(amt_value4);
                tb4 = Tableinfo.spending4detail.TABLE_NAME;
                listItems = new ListItems(parseAmt4, tb4);
                adapter.add(listItems);
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Spendings_4 details are not found.", Toast.LENGTH_SHORT).show();
        }
    }





}

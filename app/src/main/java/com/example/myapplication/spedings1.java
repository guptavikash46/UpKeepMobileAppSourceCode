package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Asus on 1/23/2018.
 */

public class spedings1 extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> mylist;
    Cursor cr;
    int column_desc, col_amt, ID;

    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.spendings_1);
        init();
        outputfunctionality();
    }

    public void init(){
        listView = findViewById(R.id.listview_spendings1);
    }

    public void outputfunctionality(){

        databaseHelper = new DatabaseHelper(this);
        cr = databaseHelper.ShowDataTable1();
        mylist = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mylist);
        listView.setAdapter(arrayAdapter);
        ID = cr.getColumnIndex(Tableinfo.spending1detail.COL0);
        column_desc = cr.getColumnIndex(Tableinfo.spending1detail.COL1);
        col_amt = cr.getColumnIndex(Tableinfo.spending1detail.COL2);


        while (cr.moveToNext()){
            mylist.add(cr.getString(ID)+",  "+cr.getString(column_desc)+ ",  | Amount "+ cr.getString(col_amt));

        }

        if (arrayAdapter.getCount()==0){
            View emptyView = getLayoutInflater().inflate(R.layout.emptyview, null);
            addContentView(emptyView, listView.getLayoutParams());
            listView.setEmptyView(emptyView);
        }
    }
}

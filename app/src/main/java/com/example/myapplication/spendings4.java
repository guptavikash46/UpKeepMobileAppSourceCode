package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Asus on 1/26/2018.
 */

public class spendings4 extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> list;
    DatabaseHelper dbhelper;
    Cursor c4;
    int id_desc, id_amt;

    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.spendings_4xml);
        init();
        mainAction();
    }
    public void init(){
        listView = findViewById(R.id.listview_spendings4);
        list = new ArrayList<>();

    }

    public void mainAction(){
        dbhelper = new DatabaseHelper(this);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
        c4 = dbhelper.ShowDataTable4();
        id_desc = c4.getColumnIndex(Tableinfo.spending4detail.COL1);
        id_amt = c4.getColumnIndex(Tableinfo.spending4detail.COL2);
        int id = c4.getColumnIndex(Tableinfo.spending4detail.COL0);
        while (c4.moveToNext()){
            list.add(c4.getString(id)+ ",  "+c4.getString(id_desc)+ "    | Amount "+c4.getString(id_amt));
        }

        if (arrayAdapter.getCount()==0){
            View emptyView = getLayoutInflater().inflate(R.layout.emptyview, null);
            addContentView(emptyView, listView.getLayoutParams());
            listView.setEmptyView(emptyView);

        }
    }
}

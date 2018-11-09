package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Asus on 1/25/2018.
 */

public class spendings2 extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> list;
    DatabaseHelper dbhelper;
    Cursor c2;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.spendings_2);
        init();
        mainAction();
    }

    public void init(){
        listView = findViewById(R.id.listview_spendings2);
        list = new ArrayList<>();
    }

    public void mainAction(){
     dbhelper = new DatabaseHelper(this);
     arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
     listView.setAdapter(arrayAdapter);
      c2= dbhelper.ShowDataTable2();
     int id_desc = c2.getColumnIndex(Tableinfo.spending2detail.COL1);
     int amt = c2.getColumnIndex(Tableinfo.spending2detail.COL2);
     int id = c2.getColumnIndex(Tableinfo.spending2detail.COL0);
     while (c2.moveToNext()){

         list.add(c2.getString(id)+ ",  "+c2.getString(id_desc)+ "    | Amount "+ c2.getString(amt));
     }

     if (arrayAdapter.getCount()==0){
         View emptyView = getLayoutInflater().inflate(R.layout.emptyview, null);
         addContentView(emptyView, listView.getLayoutParams());
         listView.setEmptyView(emptyView);
     }

    }
}

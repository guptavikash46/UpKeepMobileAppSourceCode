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

public class spendings3 extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> list;
    DatabaseHelper dbhelper;
    Cursor c3;
    int id_desc, id_amt;

    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.spendings_3xml);
        init();
        mainAction();
    }
    public void init(){
        listView = findViewById(R.id.listview_spendings3);
        list = new ArrayList<>();

    }

    public void mainAction(){
           dbhelper = new DatabaseHelper(this);
           arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
           listView.setAdapter(arrayAdapter);
           c3 = dbhelper.ShowDataTable3();
            id_desc = c3.getColumnIndex(Tableinfo.spending3detail.COL1);
            id_amt = c3.getColumnIndex(Tableinfo.spending3detail.COL2);
        int id = c3.getColumnIndex(Tableinfo.spending3detail.COL0);
           while (c3.moveToNext()){
               list.add(c3.getString(id)+",  "+c3.getString(id_desc)+ "    | Amount "+c3.getString(id_amt));
           }

           if (arrayAdapter.getCount()==0){
               View emptyView = getLayoutInflater().inflate(R.layout.emptyview, null);
               addContentView(emptyView, listView.getLayoutParams());
               listView.setEmptyView(emptyView);
           }
    }
}

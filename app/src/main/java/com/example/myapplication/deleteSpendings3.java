package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Asus on 3/22/2018.
 */

public class deleteSpendings3 extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> arrayList;
    DatabaseHelper dbhelper;
    Cursor cursor;
    int id1, itempos;
    String pos, RealID;
@Override
    protected void onCreate(Bundle savedInstancestate){
    super.onCreate(savedInstancestate);
    setContentView(R.layout.deletelayout3);
    init();
    mainAction();
}

public void init(){
listView = findViewById(R.id.listview_deleteSpend3);
dbhelper = new DatabaseHelper(getApplicationContext());
}

public void mainAction(){
    arrayList = new ArrayList<>();
    arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
    listView.setAdapter(arrayAdapter);
    cursor = dbhelper.ShowDataTable3();
    id1 = cursor.getColumnIndex(Tableinfo.spending3detail.COL1);
    while (cursor.moveToNext()){
        arrayList.add(cursor.getString(id1));
    }


    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            pos = parent.getItemAtPosition(position).toString();
            itempos = position;
            cursor = dbhelper.SupplyID3(pos);
            id1 = cursor.getColumnIndex(Tableinfo.spending3detail.COL0);
            while (cursor.moveToNext()){
                RealID = cursor.getString(id1);
            }


            dialogactivity();
        }
    });

    if (arrayAdapter.getCount()==0){
       setContentView(R.layout.emptyview);
    }
}

    public void dialogactivity(){
        final AlertDialog.Builder dialg = new AlertDialog.Builder(this);
        dialg.setTitle("Delete confirmation");
        dialg.setIcon(android.R.drawable.ic_menu_delete);
        dialg.setMessage("Are you sure you want to delete this spend ?");
        dialg.setCancelable(false);
        dialg.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dbhelper.deleteData3(Integer.parseInt(RealID));
                Toast.makeText(getApplicationContext(), "Spending Deleted ", Toast.LENGTH_SHORT).show();
                arrayAdapter.notifyDataSetChanged();
                arrayList.remove(arrayAdapter.getItem(itempos));
            }
        });

        dialg.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialg.show();
    }
}

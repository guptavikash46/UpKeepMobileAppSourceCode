package com.example.myapplication;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Asus on 2/11/2018.
 */

public class deleteSpendings extends AppCompatActivity {


ListView lsdelete;
Cursor cr, cursor2;
DatabaseHelper dbhelper;
ArrayList<String> arrayList;
ArrayAdapter arrayAdapter;
String item, value, msg;
int id_item, col_id, pos;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_layout);
        init();
        mainAction();

    }
    public void init(){
     lsdelete = findViewById(R.id.listview_delete);

    }

    public void mainAction() {
        dbhelper = new DatabaseHelper(getApplicationContext());
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lsdelete.setAdapter(arrayAdapter);
        cr = dbhelper.ShowDataTable1();
        int id = cr.getColumnIndex(Tableinfo.spending1detail.COL1);
        while (cr.moveToNext()) {
            arrayList.add(cr.getString(id));
        }

        lsdelete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
                pos = i;
                cursor2 = dbhelper.SupplyID(item);
                col_id = cursor2.getColumnIndex(Tableinfo.spending1detail.COL0);
                while (cursor2.moveToNext()){
                           value = cursor2.getString(col_id);
                }
                         dialogactivity();
            }
        });

        if (arrayAdapter.getCount() == 0) {
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

            dbhelper.deleteData1(Integer.parseInt(value));
                      Toast.makeText(getApplicationContext(), "Spending Deleted ", Toast.LENGTH_SHORT).show();
                      arrayAdapter.notifyDataSetChanged();
                      arrayList.remove(arrayAdapter.getItem(pos));

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

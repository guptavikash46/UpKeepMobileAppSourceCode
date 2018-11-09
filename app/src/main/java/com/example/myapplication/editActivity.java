package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.awt.font.TextAttribute;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by Asus on 2/16/2018.
 */

public class editActivity extends AppCompatActivity {


    String pos,pos_listview, store_desc, store_amt, ID_fetch, getID;
    Spinner spinner;
    ArrayAdapter<CharSequence> arrayAdapter;
    ArrayAdapter adapter;
    Cursor cursor;
    int id_col, parse_ID;
    ListView listViewedit;
    DatabaseHelper dbhelper;
    ArrayList<String> mylist;
    Double parsing_amt;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        init();
        mainAction();
    }

    public void init(){
     spinner = findViewById(R.id.spinner_edit_activity);
     listViewedit = findViewById(R.id.editSpendings_listview);
    }

    public void mainAction(){
        dbhelper = new DatabaseHelper(getApplicationContext());

           arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.tablelist, android.R.layout.simple_spinner_item);
           arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner.setAdapter(arrayAdapter);


           spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
               @Override
               public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              pos = adapterView.getItemAtPosition(i).toString();

                   mylist = new ArrayList<>();
                   adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, mylist);
                   listViewedit.setAdapter(adapter);
              if (pos.equals(Tableinfo.spending1detail.TABLE_NAME)) {
                  cursor = dbhelper.ShowDataTable1();
                  id_col = cursor.getColumnIndex(Tableinfo.spending1detail.COL1);
                  while (cursor.moveToNext()) {
                      mylist.add(cursor.getString(id_col));
                  }
              }
              //second
                   if (pos.equals(Tableinfo.spending2detail.TABLE_NAME)) {
                       cursor = dbhelper.ShowDataTable2();
                       id_col = cursor.getColumnIndex(Tableinfo.spending2detail.COL1);
                       while (cursor.moveToNext()) {
                           mylist.add(cursor.getString(id_col));
                       }
                   }
                   //third
                   if (pos.equals(Tableinfo.spending3detail.TABLE_NAME)) {
                       cursor = dbhelper.ShowDataTable3();
                       id_col = cursor.getColumnIndex(Tableinfo.spending3detail.COL1);
                       while (cursor.moveToNext()) {
                           mylist.add(cursor.getString(id_col));
                       }
                   }
                   //fourth
                   if (pos.equals(Tableinfo.spending4detail.TABLE_NAME)) {
                       cursor = dbhelper.ShowDataTable4();
                       id_col = cursor.getColumnIndex(Tableinfo.spending4detail.COL1);
                       while (cursor.moveToNext()) {
                           mylist.add(cursor.getString(id_col));
                       }
                   }

               }

               @Override
               public void onNothingSelected(AdapterView<?> adapterView) {

               }
           });

           listViewedit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    pos_listview = adapterView.getItemAtPosition(i).toString();

                    if (spinner.getSelectedItem().toString().equals(Tableinfo.spending1detail.TABLE_NAME)) {
                        cursor = dbhelper.ShowArowtable1(pos_listview);
                        int id1 = cursor.getColumnIndex(Tableinfo.spending1detail.COL1);
                        int id2 = cursor.getColumnIndex(Tableinfo.spending1detail.COL2);
                        while (cursor.moveToNext()) {
                            store_desc = cursor.getString(id1);
                            store_amt = cursor.getString(id2);
                        }

                        Intent intent = new Intent(getApplicationContext(), updateclass.class);
                        intent.putExtra("first_msg", pos_listview);
                        intent.putExtra("second_msg", pos);
                        intent.putExtra("third_msg", store_desc);
                        intent.putExtra("fourth_msg", store_amt);
                        startActivity(intent);
                    }
                   if (spinner.getSelectedItem().toString().equals(Tableinfo.spending2detail.TABLE_NAME)) {
                       cursor = dbhelper.ShowArowtable2(pos_listview);
                       int id1 = cursor.getColumnIndex(Tableinfo.spending2detail.COL1);
                       int id2 = cursor.getColumnIndex(Tableinfo.spending2detail.COL2);
                       while (cursor.moveToNext()) {
                           store_desc = cursor.getString(id1);
                           store_amt = cursor.getString(id2);
                       }

                       Intent intent = new Intent(getApplicationContext(), updateclass.class);
                       intent.putExtra("first_msg", pos_listview);
                       intent.putExtra("second_msg", pos);
                       intent.putExtra("third_msg", store_desc);
                       intent.putExtra("fourth_msg", store_amt);
                       startActivity(intent);
                   }
                   if (spinner.getSelectedItem().toString().equals(Tableinfo.spending3detail.TABLE_NAME)) {
                       cursor = dbhelper.ShowArowtable3(pos_listview);
                       int id1 = cursor.getColumnIndex(Tableinfo.spending3detail.COL1);
                       int id2 = cursor.getColumnIndex(Tableinfo.spending3detail.COL2);
                       while (cursor.moveToNext()) {
                           store_desc = cursor.getString(id1);
                           store_amt = cursor.getString(id2);
                       }

                       Intent intent = new Intent(getApplicationContext(), updateclass.class);
                       intent.putExtra("first_msg", pos_listview);
                       intent.putExtra("second_msg", pos);
                       intent.putExtra("third_msg", store_desc);
                       intent.putExtra("fourth_msg", store_amt);
                       startActivity(intent);
                   }
                   if (spinner.getSelectedItem().toString().equals(Tableinfo.spending4detail.TABLE_NAME)) {
                       cursor = dbhelper.ShowArowtable4(pos_listview);
                       int id1 = cursor.getColumnIndex(Tableinfo.spending4detail.COL1);
                       int id2 = cursor.getColumnIndex(Tableinfo.spending4detail.COL2);
                       while (cursor.moveToNext()) {
                           store_desc = cursor.getString(id1);
                           store_amt = cursor.getString(id2);
                       }

                       Intent intent = new Intent(getApplicationContext(), updateclass.class);
                       intent.putExtra("first_msg", pos_listview);
                       intent.putExtra("second_msg", pos);
                       intent.putExtra("third_msg", store_desc);
                       intent.putExtra("fourth_msg", store_amt);
                       startActivity(intent);
                   }




               }
           });

    }

    }



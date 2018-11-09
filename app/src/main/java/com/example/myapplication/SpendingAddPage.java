package com.example.myapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * Created by Asus on 1/21/2018.
 */

public class SpendingAddPage extends AppCompatActivity {

    limitSetDialogClass a = new limitSetDialogClass();
    Spinner spinner;
    ArrayAdapter<CharSequence> arrayAdapter;
    EditText desc_edittext;
    EditText amt_edittext;
    double amt_parse;
    String desc, amt, table_select;
    DatabaseHelper dbHelper;


    protected void onCreate(Bundle a) {
        super.onCreate(a);
        setContentView(R.layout.spending_add_page);
        init();
        spinnerfunctionality();
    }

    public void init() {

        spinner = findViewById(R.id.spinner_list);
        desc_edittext = findViewById(R.id.spending_input_edittext);
        amt_edittext = findViewById(R.id.amount_add_edittext);

    }


    public void spinnerfunctionality() {

        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.tablelist, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                table_select = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void putData(View view) {

        try {

            desc = desc_edittext.getText().toString();
            amt = amt_edittext.getText().toString();
            amt_parse = Double.parseDouble(amt);
            dbHelper = new DatabaseHelper(this);


            //first list
            class Snackbarclick implements View.OnClickListener {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), spedings1.class);
                    startActivity(intent);
                }
            }
            if (desc_edittext.length() != 0 && amt_edittext.length() != 0 && table_select.equals(Tableinfo.spending1detail.TABLE_NAME)) {
                dbHelper.AddDataTable1(desc, amt_parse);
                Snackbar.make(view, "Data Added in " + Tableinfo.spending1detail.TABLE_NAME, Snackbar.LENGTH_LONG).setAction("VIEW LOG", new Snackbarclick()).show();
            }


            // second list

            class Snackbarclick2 implements View.OnClickListener {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), spendings2.class);
                    startActivity(intent);
                }
            }
            if (table_select.equals(Tableinfo.spending2detail.TABLE_NAME) && desc_edittext.length() != 0) {
                dbHelper.AddDataTable2(desc, amt_parse);
                Snackbar.make(view, "Data Added in " + Tableinfo.spending2detail.TABLE_NAME, Snackbar.LENGTH_LONG).setAction("VIEW LOG", new Snackbarclick2()).show();

            }


            //third list
            class Snackbarclick3 implements View.OnClickListener {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), spendings3.class);
                    startActivity(intent);
                }
            }
            if (table_select.equals(Tableinfo.spending3detail.TABLE_NAME) && desc_edittext.length() != 0) {
                dbHelper.AddDataTable3(desc, amt_parse);
                Snackbar.make(view, "Data Added in " + Tableinfo.spending3detail.TABLE_NAME, Snackbar.LENGTH_LONG).setAction("VIEW LOG", new Snackbarclick3()).show();
            }


            //fourth list
            class Snackbarclick4 implements View.OnClickListener {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), spendings4.class);
                    startActivity(intent);
                }
            }
            if (table_select.equals(Tableinfo.spending4detail.TABLE_NAME) && desc_edittext.length() != 0) {
                dbHelper.AddDataTable4(desc, amt_parse);
                Snackbar.make(view, "Data Added in " + Tableinfo.spending4detail.TABLE_NAME, Snackbar.LENGTH_LONG).setAction("VIEW LOG", new Snackbarclick4()).show();

            }
            if (desc_edittext.length() == 0 || amt_edittext.length() == 0 || table_select.equals("Select any list here")) {
                Snackbar.make(view, "Please fill in all the details.", Snackbar.LENGTH_SHORT).setAction("xyz", null).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Some fields are left empty", Toast.LENGTH_SHORT).show();
        }

    }

}

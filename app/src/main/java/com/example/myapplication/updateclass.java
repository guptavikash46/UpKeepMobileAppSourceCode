package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Asus on 3/8/2018.
 */

public class updateclass extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    ArrayAdapter<CharSequence> arrayAdapter;
    String get_desc, fetch_id, Table_name, desc_name, amt_name;
    int get_id;
    double get_amt;
    DatabaseHelper dbhelp;
    Cursor cr;
    editActivity edA = new editActivity();

    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.update_layout);
        inite();
        mainAction();
    }

    public void inite(){
       ed1 = findViewById(R.id.update_ID_editext);
       ed2 = findViewById(R.id.update_Desc_editext);
       ed3 = findViewById(R.id.update_Amt_editext);
       dbhelp = new DatabaseHelper(getApplicationContext());
    }

    public void mainAction() {


        Intent intent = getIntent();
        String id_msg = intent.getStringExtra("first_msg");
        Table_name = intent.getStringExtra("second_msg");
        desc_name = intent.getStringExtra("third_msg");
        amt_name = intent.getStringExtra("fourth_msg");

        if (Table_name.equals(Tableinfo.spending1detail.TABLE_NAME)) {
            cr = dbhelp.SupplyID(id_msg);
            int coPos = cr.getColumnIndex(Tableinfo.spending1detail.COL0);
            while (cr.moveToNext()) {
                fetch_id = cr.getString(coPos);
            }
            ed1.setText(fetch_id);
            ed2.setText(desc_name);
            ed3.setText(amt_name);
        }
        if (Table_name.equals(Tableinfo.spending2detail.TABLE_NAME)){
            cr = dbhelp.SupplyID2(id_msg);
            int coPos = cr.getColumnIndex(Tableinfo.spending2detail.COL0);
            while (cr.moveToNext()) {
                fetch_id = cr.getString(coPos);
            }
            ed1.setText(fetch_id);
            ed2.setText(desc_name);
            ed3.setText(amt_name);
        }
        if (Table_name.equals(Tableinfo.spending3detail.TABLE_NAME)){
            cr = dbhelp.SupplyID3(id_msg);
            int coPos = cr.getColumnIndex(Tableinfo.spending3detail.COL0);
            while (cr.moveToNext()) {
                fetch_id = cr.getString(coPos);
            }
            ed1.setText(fetch_id);
            ed2.setText(desc_name);
            ed3.setText(amt_name);
        }
        if (Table_name.equals(Tableinfo.spending4detail.TABLE_NAME)){
            cr = dbhelp.SupplyID4(id_msg);
            int coPos = cr.getColumnIndex(Tableinfo.spending4detail.COL0);
            while (cr.moveToNext()) {
                fetch_id = cr.getString(coPos);
            }
            ed1.setText(fetch_id);
            ed2.setText(desc_name);
            ed3.setText(amt_name);
        }

    }

    public class viewupdatedlog1 implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), spedings1.class);
            startActivity(i);
        }
    }
    class viewupdatedlog2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), spendings2.class);
            startActivity(i);
        }
    }
    class viewupdatedlog3 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), spendings3.class);
            startActivity(i);
        }
    }
    class viewupdatedlog4 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), spendings4.class);
            startActivity(i);
        }
    }
    public void updateprocessit(View view){


        try {
            get_id = Integer.parseInt(ed1.getText().toString());
            get_desc = ed2.getText().toString();
            get_amt = Double.parseDouble(ed3.getText().toString());

            if (Table_name.equals(Tableinfo.spending1detail.TABLE_NAME)) {
                dbhelp.updateData1(get_id, get_desc, get_amt);
                Snackbar.make(view, "Updation done !", Snackbar.LENGTH_LONG).setAction("VIEW LOG", new viewupdatedlog1()).show();
            }
            if(Table_name.equals(Tableinfo.spending2detail.TABLE_NAME)){
                dbhelp.updateData2(get_id, get_desc, get_amt);
                Snackbar.make(view, "Updation done !", Snackbar.LENGTH_LONG).setAction("VIEW LOG", new viewupdatedlog2()).show();
            }
            if(Table_name.equals(Tableinfo.spending3detail.TABLE_NAME)){
                dbhelp.updateData3(get_id, get_desc, get_amt);
                Snackbar.make(view, "Updation done !", Snackbar.LENGTH_LONG).setAction("VIEW LOG", new viewupdatedlog3()).show();
            }
            if(Table_name.equals(Tableinfo.spending4detail.TABLE_NAME)){
                dbhelp.updateData4(get_id, get_desc, get_amt);
                Snackbar.make(view, "Updation done !", Snackbar.LENGTH_LONG).setAction("VIEW LOG", new viewupdatedlog4()).show();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Please fill all the details.", Toast.LENGTH_SHORT).show();
        }


    }
}

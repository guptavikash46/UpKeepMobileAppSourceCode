package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileOutputStream;

/**
 * Created by Asus on 1/27/2018.
 */

public class limitSetDialogClass extends AppCompatActivity {
Spinner spinner;
EditText editText;
Button button;
ArrayAdapter arrayAdapter;
String item;
    String filename1 = "spending1_file";
    String filename2 = "spending2_file";
    String filename3 = "spending3_file";
    String filename4 = "spending4_file";
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.limit_set_dialog);
        init();
        mainAction();
    }

    public void init(){
   spinner = findViewById(R.id.dialog_spinner);
   editText = findViewById(R.id.dialog_edittext_maxValue);
   button = findViewById(R.id.dialog_button);
    }



    public void mainAction() {
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.tablelist, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(item.equals("Select one list")){
                    Toast.makeText(getApplicationContext(), "please select one list.", Toast.LENGTH_SHORT).show();
                }
                //first
            if (item.equals(Tableinfo.spending1detail.TABLE_NAME) && editText.length()!=0) {
                String input = editText.getText().toString();
                FileOutputStream fileOutputStream;

                try {
                    fileOutputStream = openFileOutput(filename1, Context.MODE_PRIVATE);
                    fileOutputStream.write(input.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(),"Limit added in "+ Tableinfo.spending1detail.TABLE_NAME, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "File could not be written.", Toast.LENGTH_SHORT).show();
                }
            }
            //second
            if (item.equals(Tableinfo.spending2detail.TABLE_NAME) && editText.length()!=0){
                String input2 = editText.getText().toString();
                FileOutputStream fileOutputStream2;
                try{
                    fileOutputStream2 = openFileOutput(filename2, Context.MODE_PRIVATE);
                    fileOutputStream2.write(input2.getBytes());
                    fileOutputStream2.close();
                    Toast.makeText(getApplicationContext(),"Limit added in "+ Tableinfo.spending2detail.TABLE_NAME, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "File could not be written.", Toast.LENGTH_SHORT).show();
                }
            }
            //third
                if (item.equals(Tableinfo.spending3detail.TABLE_NAME) && editText.length()!=0){
                    String input3 = editText.getText().toString();
                    FileOutputStream fileOutputStream3;
                    try{
                        fileOutputStream3 = openFileOutput(filename3, Context.MODE_PRIVATE);
                        fileOutputStream3.write(input3.getBytes());
                        fileOutputStream3.close();
                        Toast.makeText(getApplicationContext(),"Limit added in "+ Tableinfo.spending3detail.TABLE_NAME, Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "File could not be written.", Toast.LENGTH_SHORT).show();
                    }
                }
                //fourth
                if (item.equals(Tableinfo.spending4detail.TABLE_NAME) && editText.length()!=0){
                    String input4 = editText.getText().toString();
                    FileOutputStream fileOutputStream4;
                    try{
                        fileOutputStream4 = openFileOutput(filename4, Context.MODE_PRIVATE);
                        fileOutputStream4.write(input4.getBytes());
                        fileOutputStream4.close();
                        Toast.makeText(getApplicationContext(),"Limit added in "+ Tableinfo.spending4detail.TABLE_NAME, Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "File could not be written.", Toast.LENGTH_SHORT).show();
                    }
                }
                if (editText.length()==0){
                    Toast.makeText(getApplicationContext(), "Please enter the amount.", Toast.LENGTH_SHORT).show();
                }

            }


        });


    }
}

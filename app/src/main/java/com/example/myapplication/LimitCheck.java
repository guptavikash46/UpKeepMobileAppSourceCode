package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Asus on 1/27/2018.
 */

public class LimitCheck extends AppCompatActivity {

limitSetDialogClass a = new limitSetDialogClass();
ListView ls;
ArrayAdapter arrayAdapter;
ArrayList<String> arrayList;
FileInputStream fileInputStream;
InputStreamReader inputStreamReader;
BufferedReader bufferedReader;
StringBuffer stringBuffer;

@Override
    protected void onCreate(Bundle bundle){
    super.onCreate(bundle);
    setContentView(R.layout.limitcheck);
    init();
    mainAction();
}

public void init(){
        ls = findViewById(R.id.listview_limit_check);
        arrayList = new ArrayList<>();
}

public void mainAction(){
         arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
         ls.setAdapter(arrayAdapter);
         String message, msg2, msg3, msg4;
         try {
             fileInputStream = openFileInput(a.filename1);
             inputStreamReader = new InputStreamReader(fileInputStream);
             bufferedReader = new BufferedReader(inputStreamReader);
             StringBuffer stringBuffer = new StringBuffer();
             while ((message = bufferedReader.readLine()) != null) {
                 stringBuffer.append(message);
             }
             if (stringBuffer.toString().equals("")) {
                 arrayList.add("No spending limit found in " + Tableinfo.spending1detail.TABLE_NAME);
             } else {
                 arrayList.add("Max spending limit in " + Tableinfo.spending1detail.TABLE_NAME + " is :" + stringBuffer.toString());
             }
         }
         catch (Exception e){
             Toast.makeText(getApplicationContext(), "File could not be retrieved.", Toast.LENGTH_SHORT).show();
         }
         //second one

    try {
        fileInputStream = openFileInput(a.filename2);
        inputStreamReader = new InputStreamReader(fileInputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        stringBuffer = new StringBuffer();

        while ((msg2 = bufferedReader.readLine()) != null) {
            stringBuffer.append(msg2);
        }
        if (stringBuffer.toString().equals("")) {
            arrayList.add("No spending limit found in "+Tableinfo.spending2detail.TABLE_NAME);
        } else {
            arrayList.add("Max spending limit in " + Tableinfo.spending2detail.TABLE_NAME + " is :" + stringBuffer.toString());
        }
    }
         catch (Exception e){
             Toast.makeText(getApplicationContext(), "File could not be retrieved.", Toast.LENGTH_SHORT).show();
         }
         //third one

    try{
        fileInputStream = openFileInput(a.filename3);
        inputStreamReader = new InputStreamReader(fileInputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        stringBuffer = new StringBuffer();

        while ((msg3=bufferedReader.readLine())!=null){
            stringBuffer.append(msg3);
        }
        if (stringBuffer.toString().equals("")){
            arrayList.add("No spending limit found in "+Tableinfo.spending3detail.TABLE_NAME);
        }
        else {
            arrayList.add("Max spending limit in " + Tableinfo.spending3detail.TABLE_NAME + " is :" + stringBuffer.toString());
        }
    }
    catch (Exception e){
        Toast.makeText(getApplicationContext(), "File could not be retrieved.", Toast.LENGTH_SHORT).show();
    }

    //fourth one
    try {
        fileInputStream = openFileInput(a.filename4);
        inputStreamReader = new InputStreamReader(fileInputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        stringBuffer = new StringBuffer();

        while ((msg4 = bufferedReader.readLine()) != null) {
            stringBuffer.append(msg4);
        }
        if (stringBuffer.toString().equals("")) {
            arrayList.add("No spending limit found in " + Tableinfo.spending3detail.TABLE_NAME);
        } else {
            arrayList.add("Max spending limit in " + Tableinfo.spending4detail.TABLE_NAME + " is :" + stringBuffer.toString());
        }
    }
    catch (Exception e){
        Toast.makeText(getApplicationContext(), "File could not be retrieved.", Toast.LENGTH_SHORT).show();
    }


}
}

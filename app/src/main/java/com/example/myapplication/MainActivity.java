package com.example.myapplication;


import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static com.example.myapplication.R.array.tablelist;

public class MainActivity extends AppCompatActivity {
    Button b;
    NavigationView navigationView;
    DrawerLayout dl;
    ActionBarDrawerToggle mtoggle;
    Intent i;
     String Channel_ID="main";
     int notify_ID=1, id1,id2,id3,id4;
    limitSetDialogClass a = new limitSetDialogClass();
    StringBuffer st1, st2, st3, st4;
    String message, msg2, msg3, msg4,amt1,amt2,amt3,amt4;
    Cursor cursor;
    DatabaseHelper dbhelper;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        dl = findViewById(R.id.drawer_layout);
        mtoggle = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);

        dl.addDrawerListener(mtoggle);
        mtoggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
        navigationclickmethod();
        notificationHandler();
    }

    public void init() {
        navigationView = findViewById(R.id.navigation_layout);
        dbhelper = new DatabaseHelper(getApplicationContext());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mtoggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Intentlogin(View view) {
        b = findViewById(R.id.button_enter_spending);

        Intent intent = new Intent(this, SpendingAddPage.class);
        startActivity(intent);

    }

    public void navigationclickmethod(){


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.limit_register:
                     Intent e = new Intent(getApplicationContext(), limitSetDialogClass.class);
                     dl.closeDrawer(Gravity.LEFT);
                     startActivity(e);
                        break;

                    case R.id.limit_reset_item:
                        Intent f = new Intent(getApplicationContext(), LimitCheck.class);
                        dl.closeDrawer(Gravity.LEFT);
                        startActivity(f);
                        break;

                    case R.id.spending_1_item:

                        i = new Intent(getApplicationContext(), spedings1.class);
                        dl.closeDrawer(Gravity.LEFT);
                        startActivity(i);
                        break;

                    case R.id.spending_2_item:
                        Intent b = new Intent(getApplicationContext(), spendings2.class);
                        dl.closeDrawer(Gravity.LEFT);
                        startActivity(b);
                        break;

                    case R.id.spending_3_item:
                        Intent c = new Intent(getApplicationContext(), spendings3.class);
                        dl.closeDrawer(Gravity.LEFT);
                        startActivity(c);
                        break;

                    case R.id.spending_4_item:
                        Intent d = new Intent(getApplicationContext(),spendings4.class);
                        dl.closeDrawer(Gravity.LEFT);
                        startActivity(d);
                        break;

                    case  R.id.delete_process:
                        Toast.makeText(getApplicationContext(), "Press again !", Toast.LENGTH_SHORT).show();
                        final Spinner spn = (Spinner)navigationView.getMenu().findItem(R.id.delete_process).getActionView();
                        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.tablelist, android.R.layout.simple_spinner_item);
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spn.setAdapter(arrayAdapter);
                        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    String tablname = adapterView.getItemAtPosition(i).toString();
                                if (spn.getSelectedItem().toString().equals(Tableinfo.spending1detail.TABLE_NAME)){
                                    Intent d = new Intent(getApplicationContext(), deleteSpendings.class);
                                    d.putExtra("table_name", tablname);
                                    dl.closeDrawer(Gravity.LEFT);
                                    startActivity(d);
                                }
                                //second list
                                if(spn.getSelectedItem().toString().equals(Tableinfo.spending2detail.TABLE_NAME)){
                                 Intent x = new Intent(getApplicationContext(), deleteSpendings2.class);
                                 dl.closeDrawer(Gravity.LEFT);
                                 startActivity(x);
                                }
                                //third list
                                if(spn.getSelectedItem().toString().equals(Tableinfo.spending3detail.TABLE_NAME)){
                                    Intent x = new Intent(getApplicationContext(), deleteSpendings3.class);
                                    dl.closeDrawer(Gravity.LEFT);
                                    startActivity(x);
                                }
                                //fourth list
                                if (spn.getSelectedItem().toString().equals(Tableinfo.spending4detail.TABLE_NAME)){
                                    Intent x = new Intent(getApplicationContext(), deleteSpendings4.class);
                                    dl.closeDrawer(Gravity.LEFT);
                                    startActivity(x);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        break;

                    case  R.id.edit_process:
                         Intent intent = new Intent(getApplicationContext(), editActivity.class);
                                 dl.closeDrawer(Gravity.LEFT);
                         startActivity(intent);
                        break;
                }

                return false;
            }
        });
    }
public void openManagePage(View view){
        Intent x = new Intent(getApplicationContext(), ManageSpendings.class);
        startActivity(x);

}

public void notificationHandler(){

    try {
        FileInputStream fileInputStream = openFileInput(a.filename1);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        st1 = new StringBuffer();
        while ((message=bufferedReader.readLine())!=null){
           st1.append(message);
        }
        message = st1.toString();
    }
    catch (Exception e){

    }
    //second file
    try {
        FileInputStream fileInputStream = openFileInput(a.filename2);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        st2 = new StringBuffer();
        while ((msg2=bufferedReader.readLine())!=null){
            st2.append(msg2);
        }
        msg2 = st2.toString();
    }
    catch (Exception e){

    }
    //third file

    try {
        FileInputStream fileInputStream = openFileInput(a.filename3);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        st3 = new StringBuffer();
        while ((msg3=bufferedReader.readLine())!=null){
          st3.append(msg3);
        }
        msg3 = st3.toString();
    }
    catch (Exception e){

    }
    //fourth file

    try {
        FileInputStream fileInputStream = openFileInput(a.filename4);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        st4 = new StringBuffer();
        while ((msg4=bufferedReader.readLine())!=null){
           st4.append(msg4);
        }
        msg4 = st4.toString();
    }
    catch (Exception e){

    }

    cursor = dbhelper.ShowsumTable1();
    id1 = cursor.getColumnIndex(Tableinfo.spending1detail.COL2);
    while (cursor.moveToNext()){
       amt1 = cursor.getString(id1);
    }
    //second
    cursor = dbhelper.ShowsumTable2();
    id2 = cursor.getColumnIndex(Tableinfo.spending2detail.COL2);
    while (cursor.moveToNext()){
        amt2 = cursor.getString(id2);
    }
    //third
    cursor = dbhelper.ShowsumTable3();
    id3 = cursor.getColumnIndex(Tableinfo.spending3detail.COL2);
    while (cursor.moveToNext()){
        amt3 = cursor.getString(id3);
    }
    //fourth
    cursor = dbhelper.ShowsumTable4();
    id4 = cursor.getColumnIndex(Tableinfo.spending4detail.COL2);
    while (cursor.moveToNext()){
        amt4 = cursor.getString(id4);
    }

    try {
        if (Double.parseDouble(amt1) > Double.parseDouble(message) || Double.parseDouble(amt2) > Double.parseDouble(msg2)
                || Double.parseDouble(amt3) > Double.parseDouble(msg3) || Double.parseDouble(amt4) > Double.parseDouble(msg4)) {


            String msg = "You have exceeded the set spending limit in your spending list.";
            Intent intent = new Intent(getApplicationContext(), LimitCheck.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder notify = new NotificationCompat.Builder(this, Channel_ID)
                    .setSmallIcon(R.drawable.app_icon)
                    .setContentTitle("Excess spending alert.")
                    .setContentText(msg)
                    .setAutoCancel(true)
                    .setVibrate(new long[]{200, 200})
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                    .setContentIntent(pendingIntent)
                    .setColor(ContextCompat.getColor(getApplicationContext(), R.color.Snackbar));


            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(notify_ID, notify.build());


        }

    }
    catch (NullPointerException e){
        e.printStackTrace();
    }

}

@Override
    protected void onRestart(){
     super.onRestart();
    try {
        FileInputStream fileInputStream = openFileInput(a.filename1);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        st1 = new StringBuffer();
        while ((message=bufferedReader.readLine())!=null){
            st1.append(message);
        }
        message = st1.toString();
    }
    catch (Exception e){

    }
    //second file
    try {
        FileInputStream fileInputStream = openFileInput(a.filename2);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        st2 = new StringBuffer();
        while ((msg2=bufferedReader.readLine())!=null){
            st2.append(msg2);
        }
        msg2 = st2.toString();
    }
    catch (Exception e){

    }
    //third file

    try {
        FileInputStream fileInputStream = openFileInput(a.filename3);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        st3 = new StringBuffer();
        while ((msg3=bufferedReader.readLine())!=null){
            st3.append(msg3);
        }
        msg3 = st3.toString();
    }
    catch (Exception e){

    }
    //fourth file

    try {
        FileInputStream fileInputStream = openFileInput(a.filename4);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        st4 = new StringBuffer();
        while ((msg4=bufferedReader.readLine())!=null){
            st4.append(msg4);
        }
        msg4 = st4.toString();
    }
    catch (Exception e){

    }

    cursor = dbhelper.ShowsumTable1();
    id1 = cursor.getColumnIndex(Tableinfo.spending1detail.COL2);
    while (cursor.moveToNext()){
        amt1 = cursor.getString(id1);
    }
    //second
    cursor = dbhelper.ShowsumTable2();
    id2 = cursor.getColumnIndex(Tableinfo.spending2detail.COL2);
    while (cursor.moveToNext()){
        amt2 = cursor.getString(id2);
    }
    //third
    cursor = dbhelper.ShowsumTable3();
    id3 = cursor.getColumnIndex(Tableinfo.spending3detail.COL2);
    while (cursor.moveToNext()){
        amt3 = cursor.getString(id3);
    }
    //fourth
    cursor = dbhelper.ShowsumTable4();
    id4 = cursor.getColumnIndex(Tableinfo.spending4detail.COL2);
    while (cursor.moveToNext()){
        amt4 = cursor.getString(id4);
    }

    try {
        if (Double.parseDouble(amt1) > Double.parseDouble(message) || Double.parseDouble(amt2) > Double.parseDouble(msg2)
                || Double.parseDouble(amt3) > Double.parseDouble(msg3) || Double.parseDouble(amt4) > Double.parseDouble(msg4)) {


            String msg = "You have exceeded the set spending limit in your spending list.";
            Intent intent = new Intent(getApplicationContext(), LimitCheck.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder notify = new NotificationCompat.Builder(this, Channel_ID)
                    .setSmallIcon(R.drawable.app_icon)
                    .setContentTitle("Excess spending alert.")
                    .setContentText(msg)
                    .setAutoCancel(true)
                    .setVibrate(new long[]{200, 200})
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                    .setContentIntent(pendingIntent)
                    .setColor(ContextCompat.getColor(getApplicationContext(), R.color.Snackbar));


            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(notify_ID, notify.build());


        }

    }
    catch (NullPointerException e){
        e.printStackTrace();
    }
}
}

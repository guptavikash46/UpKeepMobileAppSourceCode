package com.example.myapplication;

/**
 * Created by Asus on 2/2/2018.
 */

public class ListItems {

  Double amt;
   String tablename;
    public ListItems( Double amt, String tblname) {
        this.amt = amt;
        this.tablename = tblname;
    }


    public Double getAmt() {
        return amt;
    }

    public String getTablename(){
        return tablename;
    }


}

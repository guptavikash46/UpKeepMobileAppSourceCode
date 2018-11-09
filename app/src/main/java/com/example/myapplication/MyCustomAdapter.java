package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2/2/2018.
 */

public class MyCustomAdapter extends ArrayAdapter<ListItems> {

List list = new ArrayList();
    public MyCustomAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
            TextView showAmount;
            TextView showTablename;
    }

    @Override
    public int getPosition(@Nullable ListItems item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void add(@Nullable ListItems object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public ListItems getItem(int position) {
        return (ListItems) list.get(position);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         View row = convertView;
        LayoutHandler layoutHandler = new LayoutHandler();

        if (row==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row= layoutInflater.inflate(R.layout.listview_item_layout, parent,false);

            layoutHandler.showAmount = row.findViewById(R.id.Amount_item_layout);
            layoutHandler.showTablename = row.findViewById(R.id.tablename_item_layout);
            row.setTag(layoutHandler);
        }
        else {
            layoutHandler = (LayoutHandler)row.getTag();
        }
              ListItems listItems = this.getItem(position);
             layoutHandler.showTablename.setText(listItems.getTablename());
             layoutHandler.showAmount.setText(String.valueOf(listItems.getAmt()));

        return row;
    }
}

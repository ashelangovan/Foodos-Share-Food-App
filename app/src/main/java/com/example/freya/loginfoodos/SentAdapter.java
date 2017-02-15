package com.example.freya.loginfoodos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Modules.Notify;


public class SentAdapter extends BaseAdapter {

    Context context;
    ArrayList<Notify> arraylist=new ArrayList<Notify>();
    private static LayoutInflater inflater=null;
    public SentAdapter(Context context, ArrayList arraylist) {
        this.context=context;
        this.arraylist=arraylist;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return arraylist==null?0:arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return arraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.sentcode, null);
        holder.home=(TextView) rowView.findViewById(R.id.textView20);
        holder.name=(TextView) rowView.findViewById(R.id.textView21);
        holder.message=(TextView) rowView.findViewById(R.id.textView22);
        holder.quantity=(TextView)rowView.findViewById(R.id.textView23);
        holder.uinfo=(TextView)rowView.findViewById(R.id.textView24);

        holder.home.setText(arraylist.get(i).getHome());
        holder.name.setText(arraylist.get(i).getName());
        holder.message.setText(arraylist.get(i).getMessage());
        holder.quantity.setText(arraylist.get(i).getQuantity());
        holder.uinfo.setText(arraylist.get(i).getUinfo());


        return rowView;
    }

    public class Holder
    {
        TextView home,name,message,quantity,uinfo;
    }


}
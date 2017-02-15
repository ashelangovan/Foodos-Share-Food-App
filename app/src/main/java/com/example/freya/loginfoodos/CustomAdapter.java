package com.example.freya.loginfoodos;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Modules.Notify;

public class CustomAdapter extends BaseAdapter  {

    Context context;
    ArrayList <Notify>arrayList=new ArrayList<Notify>();
    private static LayoutInflater inflater=null;
    public CustomAdapter(Context context, ArrayList arrayList) {
        this.context=context;
        this.arrayList=arrayList;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
      return arrayList==null?0:arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return arrayList.get(position);
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
        rowView = inflater.inflate(R.layout.content_notifycode, null);
        holder.home=(TextView) rowView.findViewById(R.id.textView20);
        holder.name=(TextView) rowView.findViewById(R.id.textView21);
        holder.message=(TextView) rowView.findViewById(R.id.textView22);
        holder.quantity=(TextView)rowView.findViewById(R.id.textView23);
        holder.uinfo=(TextView)rowView.findViewById(R.id.textView24);

        holder.home.setText(arrayList.get(i).getHome());
        holder.name.setText(arrayList.get(i).getName());
        holder.message.setText(arrayList.get(i).getMessage());
        holder.quantity.setText(arrayList.get(i).getQuantity());
        holder.uinfo.setText(arrayList.get(i).getUinfo());


        return rowView;
    }

    public class Holder
    {
        TextView home,name,message,quantity,uinfo;
    }


}
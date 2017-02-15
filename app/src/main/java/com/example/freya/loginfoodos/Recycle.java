package com.example.freya.loginfoodos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

import java.util.ArrayList;

import co.moonmonkeylabs.realmsearchview.RealmSearchView;

public class Recycle extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    int[] image_id={R.drawable.a,R.drawable.b,R.drawable.c};
    String[] name,loc;
    ArrayList<contact>list=new ArrayList<contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        name=getResources().getStringArray(R.array.homename);
        loc=getResources().getStringArray(R.array.location);
        int count=0;
        for(String Name : name)
        {
            contact contact=new contact(image_id[count],Name,loc[count]);
            count++;
            list.add(contact);
        }
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager );
        recyclerView.setHasFixedSize(true);
        adapter=new ContactAdapter(list,this);
        recyclerView.setAdapter(adapter);

    }
    public void back(View v)
    {
        Intent i=new Intent(this,Navigation.class);
        startActivity(i);
    }

}

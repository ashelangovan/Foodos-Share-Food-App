package com.example.freya.loginfoodos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Homemap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homemap);
    }
    public void allhome(View v)
    {
        Intent i=new Intent(this,Allhome.class);
        startActivity(i);
    }
    public void shome(View v)
    {
        Intent i=new Intent(this,Shome.class);
        startActivity(i);
    }
    public void map(View v)
    {
        Intent i=new Intent(this,MapsActivity.class);
        startActivity(i);
    }
    public void back(View v)
    {
        Intent i=new Intent(this,Navigation.class);
        startActivity(i);
    }
}

package com.example.freya.loginfoodos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Modules.Notify;

public class Notifyhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifyhome);

    }
    public void mess(View v)
    {
        Intent i=new Intent(Notifyhome.this,message.class);
        startActivity(i);
    }
    public void sent(View v)
    {Intent i=new Intent(Notifyhome.this,sent.class);
        startActivity(i);

    }
    public void onaccept(View v)
    {
        Intent i=new Intent(Notifyhome.this,Acceptedhome.class);
        startActivity(i);
    }

}

package com.example.freya.loginfoodos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


    }
    public void onClick(View view)
    {
        Intent intent=new Intent(UserAreaActivity.this,Recycle.class);
        startActivity(intent);
    }
}

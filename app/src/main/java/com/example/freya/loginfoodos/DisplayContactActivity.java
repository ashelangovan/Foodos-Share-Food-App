package com.example.freya.loginfoodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);
        Bundle b = getIntent().getExtras();
        TextView add = (TextView) findViewById(R.id.addValue);
        TextView num = (TextView) findViewById(R.id.numValue);
        TextView web = (TextView) findViewById(R.id.webValue);

        add.setText(b.getCharSequence("Address"));
        num.setText(b.getCharSequence("Number"));
        web.setText(b.getCharSequence("Website"));
    }
}

package com.example.freya.loginfoodos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Comm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm);
        Bundle b = getIntent().getExtras();
        TextView add = (TextView) findViewById(R.id.textView8);
        TextView num = (TextView) findViewById(R.id.textView9);
        TextView cb = (TextView) findViewById(R.id.textView10);
        TextView ash = (TextView) findViewById(R.id.textView11);
        TextView adhi = (TextView) findViewById(R.id.textView12);
        TextView cs = (TextView) findViewById(R.id.textView13);

        add.setText(b.getCharSequence("ab"));
        num.setText(b.getCharSequence("about"));
        cb.setText(b.getCharSequence("Createdby"));
        ash.setText(b.getCharSequence("Ashwin"));
        adhi.setText(b.getCharSequence("Athieswar"));
        cs.setText(b.getCharSequence("Chandrasekar"));

    }
}

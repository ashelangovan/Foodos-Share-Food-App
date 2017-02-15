package com.example.freya.loginfoodos;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ProgressDialog progressBar;
        int progressBarStatus = 0;
        Handler progressBarbHandler = new Handler();
        long fileSize = 0;
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               boolean valid = true;

                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final String age = etAge.getText().toString();
                //Boolean n=false;
                //                final int num=Integer.parseInt(age);
                final String password = etPassword.getText().toString();
                if (username.isEmpty() || username.length() < 3) {
                    etUsername.setError("at least 3 characters");
                    valid = false;
                } else {
                    etUsername.setError(null);
                }

                if (name.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(name).matches()) {
                    etName.setError("enter a valid email address");
                    valid = false;
                } else {
                    etName.setError(null);
                }

                if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
                    etPassword.setError("between 4 and 10 alphanumeric characters");
                    valid = false;
                } else {
                    etPassword.setError(null);
                }
                if(age.isEmpty())
                {
                    etAge.setError("Empty");
                }

if(valid)
            {
                final int num=Integer.parseInt(age);
                Response.Listener<String> responseListener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success)
                            {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };

               RegisterRequest registerRequest = new RegisterRequest(name, username, num, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
    }

        });
    }}


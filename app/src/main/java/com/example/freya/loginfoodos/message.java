package com.example.freya.loginfoodos;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class message extends AppCompatActivity {
EditText editText,editText2,editText3,editText4;
    String username,message,home,quantity,uinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        editText=(EditText)findViewById(R.id.textView17);
        editText2=(EditText)findViewById(R.id.textView14);
        editText3=(EditText)findViewById(R.id.textView15);
        editText4=(EditText)findViewById(R.id.textView16);
    }
    public void send(View v)
    {Boolean valid=true;
        message=editText.getText().toString();
        home=editText2.getText().toString();
        uinfo=editText3.getText().toString();
        quantity=editText4.getText().toString();
        username=LoginActivity.username;
        if(message.isEmpty())
        {editText.setError("This field is Empty");
            valid=false;
        }
        if(home.isEmpty())
        {
            editText2.setError("This field is Empty");
            valid=false;
        }
        if(uinfo.isEmpty())
        {
            editText3.setError("This field is Empty");
            valid=false;
        }
        if(quantity.isEmpty())
        {
            editText4.setError("This field is Empty ");
            valid=false;
        }

        if(valid)
        {
        getData();}
    }
    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, Boolean> {
            String res;

            @Override
            protected void onPreExecute() {
                res="";
            }

            @Override
            protected Boolean doInBackground(String... params) {
                try {
                    URL url = new URL("http://10.0.2.2/notifynsert.php");
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String data= URLEncoder.encode("home","UTF-8")+"="+URLEncoder.encode(home,"UTF-8")+"&"
                            +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                            +URLEncoder.encode("message","UTF-8")+"="+URLEncoder.encode(message,"UTF-8")+"&"
                            +URLEncoder.encode("quantity","UTF-8")+"="+URLEncoder.encode(quantity,"UTF-8")+
                            "&"+URLEncoder.encode("uinfo","UTF-8")+"="+URLEncoder.encode(uinfo,"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream=httpURLConnection.getInputStream();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    String line="";
                    Integer i=1;
                    Boolean result=false;
                    while((line=bufferedReader.readLine())!=null)
                    {
                        if(line.equalsIgnoreCase("Success")) {
                            result = true;
                            break;
                        }
                        else
                            result=false;
                        res=res+line;
                        Log.d("res",line);
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
            @Override
            protected void onPostExecute(Boolean te){
//                myJSON=te;
//                //t1.setText(myJSON);
//                res="";
                Log.d("resulttt",te+"");
                Toast.makeText(getApplicationContext(),"return"+te,Toast.LENGTH_LONG).show();
                res=res.substring(0,res.indexOf('<'));
                if(res.equals("success")) {
                    //Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();

                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    //   startActivity(new Intent(LoginActivity.this, RequestBlood.class));
                }
//                la=showList();
//                if (te != null) return te;
//                // t1.setText(te);
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();


    }
}

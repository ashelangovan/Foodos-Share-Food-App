package com.example.freya.loginfoodos;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import Modules.Notify;
import Modules.UserNotifify;

public class Acceptedhome extends AppCompatActivity {
    ArrayList<UserNotifify> arrayList;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptedhome);
         t1=(TextView)findViewById(R.id.textView27);
        t2=(TextView)findViewById(R.id.textView28);
        getData();
    }
    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, Boolean> {
            String res,data1;

            @Override
            protected void onPreExecute() {
                res="";data1="";
            }

            @Override
            protected Boolean doInBackground(String... params) {
                try {
                    URL url = new URL("http://10.0.2.2/acceptuser.php");
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    data1= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(LoginActivity.username,"UTF-8");
                    bufferedWriter.write(data1);
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
                        Log.d("res",line+data1);
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
            protected void onPostExecute(Boolean te) {
//                myJSON=te;
//                //t1.setText(myJSON);
//                res="";
                Log.d("resulttt", res + "");
                Toast.makeText(getApplicationContext(), "return" + te, Toast.LENGTH_LONG).show();
                res = res.substring(0, res.indexOf('<'));
                try {
                    Gson gson = new Gson();

                    Type type = new TypeToken<ArrayList<UserNotifify>>() {
                    }.getType();


                    arrayList = gson.fromJson(res, type);
                    System.out.println(gson.fromJson(res, type)+arrayList.get(0).getSuccess());

                    if (arrayList.get(0).getSuccess().equalsIgnoreCase("true")) {
                        //Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                        t1.setText("   Your request has been accepted   "+arrayList.get(0).getHome());
                        t2.setText("   The username   "+arrayList.get(0).getName());
                        //finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();
                        //   startActivity(new Intent(LoginActivity.this, RequestBlood.class));
                    }
//                la=showList();
//                if (te != null) return te;
//                // t1.setText(te);
                }catch (Exception e){e.printStackTrace();}
            }

        }
        GetDataJSON g = new GetDataJSON();
        g.execute();

    }
}

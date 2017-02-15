package com.example.freya.loginfoodos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import Modules.Notify;

public class receive extends AppCompatActivity  {
TextView textView,textView2;
    ArrayList<Notify> arrayList;
     ListView listview;
    int mSelectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        listview=(ListView)findViewById(R.id.list);
        getData();
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Toast.makeText(receive.this,
                        "Item in position " + position + " clicked",
                        Toast.LENGTH_LONG).show();
                // Return true to consume the click event. In this case the
                // onListItemClick listener is not called anymore.
                mSelectedItem=position;
                return true;
            }
        });


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
                    URL url = new URL("http://foodos.netai.net/notifyret.php");
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String data= URLEncoder.encode("home","UTF-8")+"="+URLEncoder.encode(HomeLogin.home,"UTF-8");
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
            protected void onPostExecute(Boolean te) {
//                myJSON=te;
//                //t1.setText(myJSON);
//                res="";
                Log.d("resulttt", res + "");
               // Toast.makeText(getApplicationContext(), "return" + te, Toast.LENGTH_LONG).show();
                res = res.substring(0, res.indexOf('<'));
                try {
                    Gson gson = new Gson();

                    Type type = new TypeToken<ArrayList<Notify>>() {
                    }.getType();


                    arrayList = gson.fromJson(res, type);
                    System.out.println(gson.fromJson(res, type)+arrayList.get(0).getSuccess());

                    if (arrayList.get(0).getSuccess().equalsIgnoreCase("true")) {
                        //Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();

                        listview.setAdapter(new CustomAdapter(getApplicationContext(),arrayList));
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
public void accept(View v)
{

    class GetDataJSON extends AsyncTask<String, Void, Boolean> {
        String res;

        @Override
        protected void onPreExecute() {
            res="";
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                URL url = new URL("http://10.0.2.2/accept.php");
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data= URLEncoder.encode("home","UTF-8")+"="+URLEncoder.encode(HomeLogin.home,"UTF-8")+"&"+URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(arrayList.get(mSelectedItem).getMessage(),"UTF-8");
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
                    Log.d("res",data+line);
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

                Type type = new TypeToken<ArrayList<Notify>>() {
                }.getType();


                arrayList = gson.fromJson(res, type);
                System.out.println(gson.fromJson(res, type)+arrayList.get(0).getSuccess());

                if (arrayList.get(0).getSuccess().equalsIgnoreCase("true")) {
                    //Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();

                    listview.setAdapter(new CustomAdapter(getApplicationContext(),arrayList));
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
   public void back(View v)
   {
       Intent i=new Intent(receive.this,DummyActivity.class);
       startActivity(i);
   }
}



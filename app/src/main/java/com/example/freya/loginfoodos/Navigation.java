package com.example.freya.loginfoodos;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        //Bundle bundle = getIntent().getExtras();

        //Extract the data…
        //String venName = bundle.getString("uname");

       // Intent intent = getIntent();
      // String s= intent.getStringExtra("username");
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//       setSupportActionBar(toolbar);
       // EditText t=(EditText) findViewById(R.id.tada);

//        t.setText(venName);
      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent=new Intent(this,Recycle.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent inte=new Intent(Navigation.this,Homemap.class);
            startActivity(inte);

        } else if (id == R.id.nav_slideshow) {
            Intent i=new Intent(this,Notifyhome.class);
            startActivity(i);

        } else if (id == R.id.nav_manage) {
          /*  ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netinfo = cm.getActiveNetworkInfo();*/
            final ProgressDialog dialog=new ProgressDialog(Navigation.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Logging out...");
            dialog.setMax(3);
            dialog.show();
            Intent i=new Intent(this,LoginActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_share) {
            String ab="ABOUT";
            String about="The main aim of this app is to provide details about social homes to the users hence fecilitating the way to donate foods which will be of a greater help to these people";
            String Createdby="Createdby";
            String Ashwin="Ashwin";
            String Athieswar="Athieswar";
            String Chandrasekar="Chandrasekar";
            Bundle b=new Bundle();
            b.putString("ab",ab);
            b.putString("about",about);
            b.putString("Createdby",Createdby);
            b.putString("Ashwin",Ashwin);
            b.putString("Athieswar",Athieswar);
            b.putString("Chandrasekar",Chandrasekar);

            Intent i=new Intent(this,Comm.class);
            i.putExtras(b);
            startActivity(i);

        } else if (id == R.id.nav_send) {
            String Address="223,Sardar patel road,Anna univ road,Guindy";
            String Number="9629479484";
            String Website="www.facebook/foodos";
            Bundle b=new Bundle();
            b.putString("Address",Address);
            b.putString("Number",Number);
            b.putString("Website",Website);
            Intent i=new Intent(this,DisplayContactActivity.class);
            i.putExtras(b);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to go to the start?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        final ProgressDialog dialog=new ProgressDialog(Navigation.this);
                        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        dialog.setMessage("Logging out...");
                        dialog.setMax(3);
                        dialog.show();
Intent i=new Intent(Navigation.this,LoginActivity.class);
                        startActivity(i);


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();

    }

}

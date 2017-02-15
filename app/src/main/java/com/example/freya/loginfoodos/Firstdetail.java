package com.example.freya.loginfoodos;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Firstdetail extends Activity {
    FloatingActionButton fab_plus, fab_msg, fab_call, fab_wassup;
    Animation Fabopen, Fabclose, Fabrclockwise, Fabranticlockwise;
    ExpandableRelativeLayout expandableLayout1, expandableLayout2;
    int mFlipping = 0; // Initially flipping is off
    Button mButton; // Reference to button available in the layout to start and stop the flipper
    Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstdetail);
        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_call = (FloatingActionButton) findViewById(R.id.fab_call);
        fab_msg = (FloatingActionButton) findViewById(R.id.fab_msg);
        fab_wassup = (FloatingActionButton) findViewById(R.id.fab_wassup);
        Fabopen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        Fabclose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        Fabrclockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        Fabranticlockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    fab_wassup.startAnimation(Fabclose);
                    fab_msg.startAnimation(Fabclose);
                    fab_call.startAnimation(Fabclose);
                    fab_plus.startAnimation(Fabranticlockwise);
                    fab_call.setClickable(false);
                    fab_msg.setClickable(false);
                    fab_wassup.setClickable(false);
                    isOpen = false;

                } else {
                    fab_wassup.startAnimation(Fabopen);
                    fab_msg.startAnimation(Fabopen);
                    fab_call.startAnimation(Fabopen);
                    fab_plus.startAnimation(Fabrclockwise);
                    fab_call.setClickable(true);
                    fab_msg.setClickable(true);
                    fab_wassup.setClickable(true);
                    isOpen = true;
                }
            }
        });
        fab_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+917867089900"));
                startActivity(callIntent);
            }
        });

        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.flipper1);

        if (mFlipping == 0) {
            /** Start Flipping */
            flipper.startFlipping();
            mFlipping = 1;
//                    mButton.setText(R.string.str_btn_stop);
        } else {
            /** Stop Flipping */
            flipper.stopFlipping();
            mFlipping = 0;
            //  mButton.setText(R.string.str_btn_start);
        }
    }

    /*fab_call.setOnClickListener(new view.onClickListener(){  public void Call(View view) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:+917867089900"));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callIntent);}});*/
    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void msg(View view) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+919444809525", null, "Im CEO BITCH", null, null);

    }
    public void newchat(View view) {
        Uri mUri = Uri.parse("smsto:+9629479484");
        Intent mIntent = new Intent(Intent.ACTION_SENDTO, mUri);
        mIntent.setPackage("com.whatsapp");
        mIntent.putExtra("sms_body", "The text goes here");
        mIntent.putExtra("chat", true);
        startActivity(mIntent);
    }
    public void loc(View view){

   // final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
        LocationManager loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // String provider = locationManager.getBestProvider(new Criteria(), true);

        if(!loc.isProviderEnabled(LocationManager.GPS_PROVIDER))
  //  if (!manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
        {    buildAlertMessageNoGps();
    }
    else{
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=13.082132,80.181295"));
        startActivity(intent);
    }}
    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();}



    public void details(View view)
    {
        String address="3/MC2, Veeramamunivar Street, Mogappair East, Chennai, Tamil Nadu 600050, India";
        String number=" +91 44 6569 2634";
        String website="www.annaiillamtrust.org";
        Intent intent=new Intent(this,DisplayContactActivity.class);
        Bundle b=new Bundle();
        b.putString("Address",address);
        b.putString("Number",number);
        b.putString("Website",website);
        intent.putExtras(b);
        startActivity(intent);

    }

}


//    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

//}


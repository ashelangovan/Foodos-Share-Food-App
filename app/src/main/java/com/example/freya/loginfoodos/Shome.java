package com.example.freya.loginfoodos;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Shome extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public double latitude;
    public double longitude;
    Context context;
    public LocationManager locationManager;
    public Criteria criteria;
    public String bestProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shome);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public static boolean isLocationEnabled(Context context)
    {
        //...............
        return true;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);        // Add a marker in Sydney and move the camera
       /* LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        LocationManager loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // String provider = locationManager.getBestProvider(new Criteria(), true);

        if(!loc.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
            buildAlertMessageNoGps();
           }
        else
        {
                locationManager = (LocationManager)  this.getSystemService(Context.LOCATION_SERVICE);
                criteria = new Criteria();
                bestProvider = String.valueOf(locationManager.getBestProvider(criteria, true)).toString();

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
          //  Location location = loc.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location location = loc.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if(location!=null) {
                    location.setLatitude(location.getLatitude());
                    location.setLongitude(location.getLongitude());

                    Toast.makeText(getApplicationContext(), "SocialHomes within 5 kms", Toast.LENGTH_SHORT).show();
                    CircleOptions circle = new CircleOptions();
                    circle.center(new LatLng(location.getLatitude(), location.getLongitude()));
                    circle.radius(10000);
                    circle.strokeColor(Color.RED);
                    circle.fillColor(Color.RED);
                    Location location2 = new Location("locationB");

                    location2.setLatitude(13.082017);
                    location2.setLongitude(80.181145);
                    //locarray.add(location2);
                    float distance = location.distanceTo(location2) / 1000;
                    if (distance < 10) {
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(13.082017, 80.181145))
                                .title("Annai Illam,Mogappair"));
                    }
                    Location location3 = new Location("locationC");
                    location3.setLatitude(13.007964);
                    location3.setLongitude(80.262356);
                    //locarray.add(location3);
                    distance = location.distanceTo(location3) / 1000;
                    if (distance < 10) {
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(13.007964, 80.262356))
                                .title("Avvai Ashram Besant Nagar"));
                    }
                    Location location4 = new Location("locationD");
                    location4.setLatitude(13.140635);
                    location4.setLongitude(80.168559);
                    // locarray.add(location4);
                    distance = location.distanceTo(location4) / 1000;
                    if (distance < 10) {
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(13.140635, 80.168559))
                                .title("BalaGurukulam,Ambattur"));
                    }
                    Location location5 = new Location("locationE");
                    location5.setLatitude(55.777893);
                    location5.setLongitude(38.167767);
                    // locarray.add(location5);
                    distance = location.distanceTo(location5) / 1000;
                    if (distance < 10) {
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(24.770562, 77.340317))
                                .title("Mahaveer Gurukul"));
                    }
                    mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

                        @Override
                        public boolean onMarkerClick(Marker arg0) {
                            if (arg0.getTitle().equals("Annai Illam,Mogappair")) // if marker source is clicked
                            {
                                firstdetail();
                            }
                            if (arg0.getTitle().equals("Avvai Ashram Besant Nagar")) // if marker source is clicked
                            {
                                seconddetail();
                            }
                            if (arg0.getTitle().equals("BalaGurukulam,Ambattur")) // if marker source is clicked
                            {
                                thirddetail();
                            }
                            return true;
                        }

                    });



       // mMap.setMyLocationEnabled(true);
    }}}

    private void buildAlertMessageNoGps() {
        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
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
        final android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    public void refresh(View view)
    {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
    public void firstdetail()
    {
        Intent i=new Intent(this,Firstdetail.class);
        startActivity(i);
    }
    public void seconddetail()
    {
        Intent i=new Intent(this,Seconddetail.class);
        startActivity(i);
    }
    public void thirddetail()
    {
        Intent i=new Intent(this,Thirddetail.class);
        startActivity(i);
    }
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(context, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }}
package com.example.rpo_lab7;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
public class MainActivity extends Activity {
    private static final int PERMISSION_REQUEST = 1;
    private TextView tvEnabledGPS;
    private TextView tvStatusGPS;
    private TextView tvLocationGPS;

    private Button aboutBut, saveBut;

    MySQLConnector sqlCon;
    private LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutBut = (Button) findViewById(R.id.about);
        saveBut = (Button) findViewById(R.id.save);

        tvEnabledGPS = (TextView) findViewById(R.id.tvEnabledGPS);
        tvStatusGPS = (TextView) findViewById(R.id.tvStatusGPS);
        tvLocationGPS = (TextView) findViewById(R.id.tvLocationGPS);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        sqlCon = new MySQLConnector();

        aboutBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { aboutButtonHandler(); }
        });

        saveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlCon.saveData("location");
                Toast.makeText(getApplicationContext(), "The data has been successfully saved in the database!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void aboutButtonHandler(){
        AlertDialog.Builder alertbox = new AlertDialog.Builder(MainActivity.this);
        alertbox.setTitle("About");
        alertbox.setMessage("This application is developed by Marina Yuskovets, " +
                "a student of the PO-6 group. " +
                "It allows you to get the coordinates " +
                "of the device and track their changes." +
                "If you want to save your geolocation data, click save.");
        alertbox.setCancelable(true);

        alertbox.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}
        });

        AlertDialog alertbox2 = alertbox.create();
        alertbox2.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new
                    String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000 * 10, 10, locationListener);
        checkEnabled();
    }
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(locationListener);
    }
    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            showLocation(location);
        }
        @Override
        public void onProviderDisabled(String provider) {
            checkEnabled();
        }
        @Override
        public void onProviderEnabled(String provider) {
            checkEnabled();
            if (ActivityCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new
                        String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST);
            }
            showLocation(locationManager.getLastKnownLocation(provider));
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            if (provider.equals(LocationManager.GPS_PROVIDER)) {
                tvStatusGPS.setText("Status: " + String.valueOf(status));
            }
        }
    };
    private void showLocation(Location location) {

        if (location == null)
            return;
        if (location.getProvider().equals(LocationManager.GPS_PROVIDER)) {
            tvLocationGPS.setText(formatLocation(location));

        }
    }
    @SuppressLint("DefaultLocale")
    private String formatLocation(Location location) {
        if (location == null)
            return "";
        return String.format(
                "Coordinates: lat = %1$.4f, lon = %2$.4f",
                location.getLatitude(), location.getLongitude());
    }
    @SuppressLint("SetTextI18n")
    private void checkEnabled() {
        tvEnabledGPS.setText("Enabled: "
                + locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER));
    }
    public void onClickLocationSettings(View view) {
        startActivity(new Intent(
                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
    };
}
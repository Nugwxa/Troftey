package com.havorstudios.troftey;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import android.location.Address;
import android.location.Geocoder;
import android.view.View;


public class MainActivity extends AppCompatActivity implements LocationListener {

    // UI components
    ImageView btnGetCountry;
    TextView txtCountry;

    ImageView btnGetFacts;
    TextView txtGetFacts;

    // Location manager to get the device's current location
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        // Initialize UI components
        btnGetCountry = findViewById(R.id.btnGetCountry);
        txtCountry = findViewById(R.id.txtCountry);

        // Initialize location manager
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Set on click listener for the button
        btnGetCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCountry.setText("Finding Location...");
                // Check if the app has the necessary permissions to access the device's location
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                }
                // Request location updates through GPS
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, MainActivity.this);
            }
        });
    }

    // Callback method that is called whenever the device's location is updated
    @Override
    public void onLocationChanged(Location location) {
        // Get the updated latitude and longitude
        double lat = location.getLatitude();
        double lng = location.getLongitude();

        // Stop listening for location updates
        locationManager.removeUpdates(this);

        // Get the country name using the updated latitude and longitude
        String country = getCountryName(lat, lng);

        // Update the text view with the country name
        txtCountry.setText(country);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) { }

    @Override
    public void onProviderEnabled(String provider) { }

    @Override
    public void onProviderDisabled(String provider) { }


    // Function to get the country name based on latitude and longitude
    public String getCountryName(double lat, double lng) {
        // Check if there is internet connectivity
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (!isConnected) {
            // Return a message indicating there is no internet connection
            return "No internet connection";
        }

        // Get the country name using the Geocoder API
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            // Get the first address from the list of addresses returned by the Geocoder API
            addresses = geocoder.getFromLocation(lat, lng, 1);

            // Return the country name from the address
            return addresses.get(0).getCountryName();
        } catch (IOException e) {
            // Return a message indicating there was an error getting the country name
            return "Error getting country name";
        }
    }



}
package com.ualr.androidcontacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewContact extends AppCompatActivity {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String homeAddress;
    private String webAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_view);

        // Get The Intent
        Intent intent = getIntent();

        // Set The Contact Values Based On What Was Added To The Intent And Set Them To TextViews
        TextView fName = findViewById(R.id.contact_full_name);
        firstName = intent.getStringExtra(MainActivity.EXTRA_FIRST_NAME);
        lastName = intent.getStringExtra(MainActivity.EXTRA_LAST_NAME);
        String fullName = firstName + " " + lastName;
        fName.setText(fullName);

        TextView phone = findViewById(R.id.contact_phone);
        phoneNumber = intent.getStringExtra(MainActivity.EXTRA_PHONE);
        phone.setText(phoneNumber);

        TextView email = findViewById(R.id.contact_email);
        emailAddress = intent.getStringExtra(MainActivity.EXTRA_EMAIL);
        email.setText(emailAddress);

        TextView address = findViewById(R.id.contact_address);
        homeAddress = intent.getStringExtra(MainActivity.EXTRA_ADDRESS);
        address.setText(homeAddress);

        TextView web = findViewById(R.id.contact_web);
        webAddress = intent.getStringExtra(MainActivity.EXTRA_WEB);
        web.setText(webAddress);
    }

    public void onCallButtonClicked(View view) {
        Uri number = Uri.parse("tel:" + phoneNumber);
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void onTextButtonClicked(View view) {
        Uri number = Uri.parse("smsto:" + phoneNumber);
        Intent textIntent = new Intent(Intent.ACTION_SENDTO, number);
        startActivity(textIntent);
    }

    public void onEmailButtonClicked(View view) {
        Uri email = Uri.parse("mailto:" + emailAddress);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, email);
        startActivity(emailIntent);
    }

    public void onMapButtonClicked(View view) {
        Uri location = Uri.parse(String.format("geo:0,0?q=(%s)", homeAddress));
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(intent);
    }

    public void onWebButtonClicked(View view) {
        Uri address = Uri.parse(webAddress);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(intent);
    }
}

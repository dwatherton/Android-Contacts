package com.ualr.androidcontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_FIRST_NAME = "FIRST NAME";
    public static final String EXTRA_LAST_NAME = "LAST NAME";
    public static final String EXTRA_PHONE = "PHONE";
    public static final String EXTRA_EMAIL = "EMAIL";
    public static final String EXTRA_ADDRESS = "ADDRESS";
    public static final String EXTRA_WEB = "WEB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSaveButtonClicked(View view)
    {
        // Create The ViewContact Intent
        Intent intent = new Intent(this, ViewContact.class);

        // Pass Contact Data To ViewContact Activity
        TextInputEditText fName = findViewById(R.id.first_name);
        Editable firstName = fName.getText();
        intent.putExtra(EXTRA_FIRST_NAME, firstName.toString());

        TextInputEditText lName = findViewById(R.id.last_name);
        Editable lastName = lName.getText();
        intent.putExtra(EXTRA_LAST_NAME, lastName.toString());

        TextInputEditText phone = findViewById(R.id.phone);
        Editable phoneNumber = phone.getText();
        intent.putExtra(EXTRA_PHONE, phoneNumber.toString());

        TextInputEditText email = findViewById(R.id.email);
        Editable emailAddress = email.getText();
        intent.putExtra(EXTRA_EMAIL, emailAddress.toString());

        TextInputEditText address = findViewById(R.id.address);
        Editable homeAddress = address.getText();
        intent.putExtra(EXTRA_ADDRESS, homeAddress.toString());

        TextInputEditText web = findViewById(R.id.web);
        Editable webAddress = web.getText();
        intent.putExtra(EXTRA_WEB, webAddress.toString());


        // Start The Contact View Activity With The Current Intent
        startActivity(intent);
    }
}

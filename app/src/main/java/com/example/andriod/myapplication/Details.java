package com.example.andriod.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView id, name, email, home, gender, office, mobile;
    Button contact;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        office = findViewById(R.id.office);
        mobile = findViewById(R.id.mobile);
        office = findViewById(R.id.office);
        home = findViewById(R.id.home);

        contact = findViewById(R.id.contact);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                office.setText(intent.getExtras().getString("office"));
                home.setText(intent.getExtras().getString("home").toString());
                mobile.setText(intent.getExtras().getString("mobile"));
            }
        });

        intent = getIntent();
        id.setText(intent.getExtras().getString("id").toString());
        name.setText(intent.getExtras().getString("name").toString());
        gender.setText(intent.getExtras().getString("gender"));
        email.setText(intent.getExtras().getString("email"));
    }
}

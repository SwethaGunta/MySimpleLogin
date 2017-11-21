package com.example.mysimplelogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;



public class Welcome extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Intent intent = getIntent();
        Log.d("CHECKING INTENT",intent.getExtras().toString());
        TextView labl = findViewById(R.id.label);
        labl.setText("Welcome " + intent.getStringExtra("first_name") + " " +intent.getStringExtra("last_name"));
        labl.setTextColor(getResources().getColor(R.color.colorAccent));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

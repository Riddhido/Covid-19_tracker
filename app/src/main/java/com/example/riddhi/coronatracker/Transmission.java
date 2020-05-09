package com.example.riddhi.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Transmission extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmission);
        back=findViewById(R.id.back_arrow_transmission);
        back.setOnClickListener(v -> onBackPressed());
    }
}

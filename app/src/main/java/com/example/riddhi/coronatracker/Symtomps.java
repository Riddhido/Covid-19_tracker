package com.example.riddhi.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Symtomps extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symtomps);
        back=findViewById(R.id.back_arrow_symptoms);
        back.setOnClickListener(v -> onBackPressed());
    }
}

package com.example.riddhi.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class faq extends AppCompatActivity {
TextView pdf;
ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        pdf=findViewById(R.id.pdfLink);
        back=findViewById(R.id.back_arrow_faq);
        back.setOnClickListener(v -> onBackPressed());

        pdf.setOnClickListener(v -> {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
            try {
                intent.setData(Uri.parse("https://www.mohfw.gov.in/pdf/FAQ.pdf"));
                startActivity(intent);
            } catch (ActivityNotFoundException exception) {
                Toast.makeText(faq.this, "Error text", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

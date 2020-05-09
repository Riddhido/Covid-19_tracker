package com.example.riddhi.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class allAboutCovidActivity extends AppCompatActivity {
    ImageView back;
    LinearLayout symptoms,prevention,frequently,tramission;
    TextView click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_about_covid);

        click=findViewById(R.id.click);
        symptoms=findViewById(R.id.lSymptoms);
        prevention=findViewById(R.id.lPrevention);
        frequently=findViewById(R.id.lfaq);
        tramission=findViewById(R.id.ltransmission);
        back=findViewById(R.id.back_arrow_all_about);
        back.setOnClickListener(v -> onBackPressed());
        symptoms.setOnClickListener(v -> startActivity(new Intent(allAboutCovidActivity.this,Symtomps.class)));
        prevention.setOnClickListener(v -> startActivity(new Intent(allAboutCovidActivity.this,DoActivity.class)));
        tramission.setOnClickListener(v -> startActivity(new Intent(allAboutCovidActivity.this,Transmission.class)));
        frequently.setOnClickListener(v -> startActivity(new Intent(allAboutCovidActivity.this,faq.class)));
        click.setOnClickListener(v -> {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
            try {
                intent.setData(Uri.parse("https://www.mohfw.gov.in/pdf/PreventionandManagementofCOVID19FLWEnglish.pdf"));
                startActivity(intent);
            } catch (ActivityNotFoundException exception) {
                Toast.makeText(allAboutCovidActivity.this, "Error text", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

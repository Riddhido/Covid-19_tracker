package com.example.riddhi.coronatracker;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout allAbout,pmCares,worldCases,indiaCases,cope,helplineNo,whatsappMygov,whatsappWho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allAbout=findViewById(R.id.lAllAbout);
        pmCares=findViewById(R.id.lPmCares);
        worldCases=findViewById(R.id.lTrackWorld);
        indiaCases=findViewById(R.id.lTrackIndia);
        cope=findViewById(R.id.lCope);
        helplineNo=findViewById(R.id.lHelpline);
        whatsappMygov=findViewById(R.id.lConnectGov);
        whatsappWho=findViewById(R.id.lConnectWho);

        allAbout.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,allAboutCovidActivity.class)));
        pmCares.setOnClickListener(v ->{
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
            try {
                intent.setData(Uri.parse("http://pmnrf.gov.in/en/online-donation"));
                startActivity(intent);
            } catch (ActivityNotFoundException exception) {
                Toast.makeText(MainActivity.this, "Error text", Toast.LENGTH_SHORT).show();
            }
        });
        worldCases.setOnClickListener(v-> startActivity(new Intent(MainActivity.this,Dashboard.class)));
        indiaCases.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,IndiaDashboard.class)));
        cope.setOnClickListener(v->startActivity(new Intent(MainActivity.this,CopeUp.class)));
        helplineNo.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,Helpline.class)));
        whatsappMygov.setOnClickListener(v ->{
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
            try {
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=919013151515"));
                startActivity(intent);
            } catch (ActivityNotFoundException exception) {
                Toast.makeText(MainActivity.this, "Error text", Toast.LENGTH_SHORT).show();
            }
        });
        whatsappWho.setOnClickListener(v ->{
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
            try {
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=+41798931892"));
                startActivity(intent);
            } catch (ActivityNotFoundException exception) {
                Toast.makeText(MainActivity.this, "Error text", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

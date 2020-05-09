package com.example.riddhi.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WorldDetail extends AppCompatActivity {
    private int positionCountry;
    ImageView back;
    TextView tvcountry,tvCases,tvTodayCases,tvDeaths,tvTotalDeaths,tvRecovered,tvActive,tvCritical,tvContinent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_detail);

        Intent intent=getIntent();
        positionCountry=intent.getIntExtra("position",0);

        back=findViewById(R.id.back_arrow_details);
        back.setOnClickListener(v -> onBackPressed());
        tvcountry=findViewById(R.id.tvCountry);
        tvCases=findViewById(R.id.tvCases);
        tvTodayCases=findViewById(R.id.tvTodayCases);
        tvDeaths=findViewById(R.id.tvTotalDeaths);
        tvTotalDeaths=findViewById(R.id.tvTodayDeaths);
        tvRecovered=findViewById(R.id.tvRecovered);
        tvActive=findViewById(R.id.tvActive);
        tvCritical=findViewById(R.id.tvCritical);
        tvContinent=findViewById(R.id.tvContinent);

        tvcountry.setText(World.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(World.countryModelList.get(positionCountry).getCases());
        tvRecovered.setText(World.countryModelList.get(positionCountry).getRecovered());
        tvCritical.setText(World.countryModelList.get(positionCountry).getCritical());
        tvDeaths.setText(World.countryModelList.get(positionCountry).getDeaths());
        tvTodayCases.setText(World.countryModelList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(World.countryModelList.get(positionCountry).getDeaths());
        tvContinent.setText(World.countryModelList.get(positionCountry).getContinent());
        tvActive.setText(World.countryModelList.get(positionCountry).getActive());

    }
}

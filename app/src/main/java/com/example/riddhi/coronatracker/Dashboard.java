package com.example.riddhi.coronatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class Dashboard extends AppCompatActivity {
    private TextView tvTotalConfirmed,tvTotalDeaths,tvTotalRecovered,tvActiveCases;
    PieChart pieChart;
    private ProgressBar progressBar;
    ImageView back;

    private Button Details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        progressBar=findViewById(R.id.progress_bar);
        tvTotalConfirmed=findViewById(R.id.tvTotalConfirmed);
        tvTotalDeaths=findViewById(R.id.tvTotalDeaths);
        tvTotalRecovered=findViewById(R.id.tvTotalRecovered);
        tvActiveCases=findViewById(R.id.tvActiveCases);
        pieChart=findViewById(R.id.piechart);
        Details=findViewById(R.id.detail);
        getData();
        Details.setOnClickListener(v-> startActivity(new Intent(Dashboard.this,World.class)));
        back=findViewById(R.id.back_arrow_world_dashboard);
        back.setOnClickListener(v -> onBackPressed());
    }
    private void getData() {
        progressBar.setVisibility(View.VISIBLE);
        RequestQueue queue= Volley.newRequestQueue(this);

        String url="https://corona.lmao.ninja/v2/all";

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    tvTotalConfirmed.setText(jsonObject.getString("cases"));
                    tvTotalDeaths.setText(jsonObject.getString("deaths"));
                    tvTotalRecovered.setText(jsonObject.getString("recovered"));
                    tvActiveCases.setText(jsonObject.getString("active"));

                    pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(tvTotalConfirmed.getText().toString()),Color.parseColor("#ffa726")));
                   pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#EF5350")));
                   pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(tvTotalRecovered.getText().toString()), Color.parseColor("#66bb6a")));
                    pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActiveCases.getText().toString()), Color.parseColor("#29B6F6")));
                    pieChart.startAnimation();



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("Error Respose",error.toString());
            }
        });
        queue.add(stringRequest);
    }
}

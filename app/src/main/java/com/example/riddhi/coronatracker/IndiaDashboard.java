package com.example.riddhi.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class IndiaDashboard extends AppCompatActivity implements MainPresenter.View{

    private ProgressBar progressBar;
    private BarChart barChart;
    private TextView tvTotalConfirmed,tvTotalDeaths,tvTotalRecovered,tvActiveCases;
    private MainPresenterImpl mainPresenter;
    private Button stateDetails;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_dashboard);

        back=findViewById(R.id.back_arrow_india_dashboard);
        back.setOnClickListener(v -> onBackPressed());
        stateDetails=findViewById(R.id.stateDetails);
        progressBar=findViewById(R.id.progess_bar);
        barChart=findViewById(R.id.bar_chart);
        tvTotalConfirmed=findViewById(R.id.tvTotalConfirmed);
        tvTotalDeaths=findViewById(R.id.tvTotalDeaths);
        tvTotalRecovered=findViewById(R.id.tvTotalRecovered);
        tvActiveCases=findViewById(R.id.tvActiveCases);

        mainPresenter=new MainPresenterImpl(this);
        stateDetails.setOnClickListener(v -> startActivity(new Intent(IndiaDashboard.this,India.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.downloadData();
        getData();
    }


    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        barChart.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        barChart.setVisibility(View.VISIBLE);
        getData();

    }

    @Override
    public void dataDownloadedSuccessfully(ArrayList<String> datesArrayList, ArrayList<Status> statusArrayList) {
        ArrayList<BarEntry> barEntryArrayList = new ArrayList<>();
        for (int i = 0; i < datesArrayList.size(); i++) {
            barEntryArrayList.add(new BarEntry(statusArrayList.get(i).getConfirmed(), i));
        }

        BarDataSet barDataSet = new BarDataSet(barEntryArrayList, "Confirmed");
        barDataSet.setColor(getResources().getColor(R.color.colorTotalConfirmed));
        BarData barData = new BarData(datesArrayList,barDataSet);
        barChart.setData(barData);
        barChart.animateY(3000);
    }
    private void getData() {
        RequestQueue queue= Volley.newRequestQueue(this);

        String url="https://corona.lmao.ninja/v2/countries/IND";

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    tvTotalConfirmed.setText(jsonObject.getString("cases"));
                    tvTotalDeaths.setText(jsonObject.getString("deaths"));
                    tvTotalRecovered.setText(jsonObject.getString("recovered"));
                    tvActiveCases.setText(jsonObject.getString("active"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("Error Response",error.toString());
            }
        });
        queue.add(stringRequest);
    }
}
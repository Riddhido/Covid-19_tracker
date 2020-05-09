package com.example.riddhi.coronatracker;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class India extends AppCompatActivity {
    ListView listView;
    ImageView back;

    public static List<DemoStatewiseModel> stateModelList = new ArrayList<>();
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);

        back=findViewById(R.id.back_arrow_india);
        back.setOnClickListener(v -> onBackPressed());
        listView = findViewById(R.id.listViewState);

        fetchData();
    }

    private void fetchData() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://api.rootnet.in/covid19-in/unofficial/covid19india.org/statewise";

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            try {
                JSONObject object = new JSONObject(response);
                if (object.getJSONObject("data").getJSONArray("statewise").length() > 0) {
                    Gson gson = new Gson();
                    for (int i = 0; i < object.getJSONObject("data").getJSONArray("statewise").length(); i++) {
                        stateModelList.add(gson.fromJson(object.getJSONObject("data")
                                .getJSONArray("statewise").getJSONObject(i).toString(), new TypeToken<DemoStatewiseModel>() {
                        }.getType()));
                    }
                }
                //todo: Why StateModel is not working with Gson and why it worked with DemoStatewiseModel. Need to check it.

                customAdapter = new CustomAdapter(India.this, stateModelList);
                listView.setAdapter(customAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> Log.e("Error Response", error.toString()));
        queue.add(request);
    }
}

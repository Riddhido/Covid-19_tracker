package com.example.riddhi.coronatracker;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainPresenterImpl implements MainPresenter {
    private MainPresenter.View view;

    public MainPresenterImpl(View view) {
        this.view = view;
    }

    @Override
    public void downloadData() {
        view.showProgressBar();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .client(new OkHttpClient())
                .build();

        Call<ResponseBody> call  = retrofit.create(Covid19Service.class).getHistoryDataForIndia();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String strResponse = null;
                try {
                    strResponse = response.body().string();
                    parse(strResponse);
                    view.hideProgressBar();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.hideProgressBar();
            }
        });
    }

    private void parse(String strResponse) {
        JSONObject responseObject = null;
        try {
            responseObject = new JSONObject(strResponse);
            JSONObject resultObject = responseObject.getJSONObject("result");
            Iterator<String> iterator = resultObject.keys();

            ArrayList<String> datesArrayList = new ArrayList<>();
            ArrayList<Status> statusArrayList = new ArrayList<>();

            while (iterator.hasNext()){
                String key = iterator.next();

                JSONObject statusPerDay = resultObject.getJSONObject(key);
                int confirmed = statusPerDay.getInt("confirmed");
                int deaths = statusPerDay.getInt("deaths");
                int recovered = statusPerDay.getInt("recovered");

                Status status = new Status(confirmed, deaths, recovered);

                statusArrayList.add(status);
                datesArrayList.add(key);

                view.dataDownloadedSuccessfully(datesArrayList, statusArrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}

package com.example.riddhi.coronatracker;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Covid19Service {
    @GET("v1/country/IND")
    Call<ResponseBody> getHistoryDataForIndia();
}

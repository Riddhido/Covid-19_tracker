package com.example.riddhi.coronatracker.Demo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DemoStateDataModel {
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("lastRefreshed")
    @Expose
    private String lastRefreshed;
    @SerializedName("total")
    @Expose
    private DemoStateTotalModel total;
    @SerializedName("statewise")
    @Expose
    private List<DemoStatewiseModel> statewise = null;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public DemoStateTotalModel getTotal() {
        return total;
    }

    public void setTotal(DemoStateTotalModel total) {
        this.total = total;
    }

    public List<DemoStatewiseModel> getStatewise() {
        return statewise;
    }

    public void setStatewise(List<DemoStatewiseModel> statewise) {
        this.statewise = statewise;
    }
}
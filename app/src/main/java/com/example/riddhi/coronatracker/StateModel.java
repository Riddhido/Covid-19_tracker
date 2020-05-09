package com.example.riddhi.coronatracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StateModel {
    //    private String state,confirmed,recovered,deaths,active;
//
//    public StateModel() {
//    }
//
//    public StateModel(String state, String confirmed, String recovered, String deaths, String active) {
//        this.state = state;
//        this.confirmed = confirmed;
//        this.recovered = recovered;
//        this.deaths = deaths;
//        this.active = active;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getConfirmed() {
//        return confirmed;
//    }
//
//    public void setConfirmed(String confirmed) {
//        this.confirmed = confirmed;
//    }
//
//    public String getRecovered() {
//        return recovered;
//    }
//
//    public void setRecovered(String recovered) {
//        this.recovered = recovered;
//    }
//
//    public String getDeaths() {
//        return deaths;
//    }
//
//    public void setDeaths(String deaths) {
//        this.deaths = deaths;
//    }
//
//    public String getActive() {
//        return active;
//    }
//
//    public void setActive(String active) {
//        this.active = active;
//    }
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("active")
    @Expose
    private Integer active;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "StateModel{" +
                "state='" + state + '\'' +
                ", confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", active=" + active +
                '}';
    }
}

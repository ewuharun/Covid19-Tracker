package com.example.coronatracker.Model;

import com.example.coronatracker.Country;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyResponse {
    private int cases;
    private int todayDeaths;
    private int active;
    private int recovered;

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    private int deaths;

    public MyResponse(int deaths,int cases, int todayDeaths, int active, int recovered, String country) {
        this.cases = cases;
        this.todayDeaths = todayDeaths;
        this.active = active;
        this.recovered = recovered;
        this.country = country;
        this.deaths=deaths;
    }

    public int getCases() {
        return cases;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public int getActive() {
        return active;
    }

    public int getRecovered() {
        return recovered;
    }

    public String getCountry() {
        return country;
    }

    private String country;

    public void setCases(int cases) {
        this.cases = cases;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
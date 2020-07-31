package com.example.coronatracker;

public class Country {
    private String country_name;
    private String totalCase;
    private String totalDeaths;
    private String totalActive;

    public void setTotalNumberOfDeaths(String totalNumberOfDeaths) {
        this.totalNumberOfDeaths = totalNumberOfDeaths;
    }

    public String getTotalNumberOfDeaths() {
        return totalNumberOfDeaths;
    }

    private String totalNumberOfDeaths;
    private String totalRecovered;


    public Country(String totalNumberOfDeaths,String country_name, String totalCase, String totalDeaths, String totalActive, String totalRecovered) {
        this.country_name = country_name;
        this.totalCase = totalCase;
        this.totalDeaths = totalDeaths;
        this.totalActive = totalActive;
        this.totalRecovered = totalRecovered;
        this.totalNumberOfDeaths=totalNumberOfDeaths;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getTotalCase() {
        return totalCase;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public String getTotalActive() {
        return totalActive;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public void setTotalCase(String totalCase) {
        this.totalCase = totalCase;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public void setTotalActive(String totalActive) {
        this.totalActive = totalActive;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }
}

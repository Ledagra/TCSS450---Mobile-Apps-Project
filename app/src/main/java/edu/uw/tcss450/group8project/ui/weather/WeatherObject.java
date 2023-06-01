package edu.uw.tcss450.group8project.ui.weather;

import androidx.annotation.NonNull;

public class WeatherObject {
    private String mLocation;
    private String mTemperature;
    private String mCondition;

    private String mDate;

    private String mHour;

    public WeatherObject() {
        this.mLocation = "";
        this.mTemperature = "";
        this.mCondition = "";
        this.mDate = "";
        this.mHour = "";
    }

    public WeatherObject(String theLocation, String theTemp, String theCondition, String theDate) {
        this.mLocation = theLocation;
        this.mTemperature = theTemp;
        this.mCondition = theCondition;
        this.mDate = theDate;
        this.mHour = "";
    }

    public WeatherObject(String date, String theTemp, String theCondition) {
        this.mLocation = "";
        this.mTemperature = theTemp;
        this.mCondition = theCondition;
        this.mDate = date;
        this.mHour = "";

    }

    public WeatherObject(String theTemp, String theCondition, int theHour) {
        this.mLocation = "";
        this.mTemperature = theTemp;
        this.mCondition = theCondition;
        this.mDate = "";
        if(theHour < 10) {
            this.mHour = "0" + theHour + ":00";
        } else {
            this.mHour = theHour + ":00";
        }

    }

    public String getLocation() {
        return mLocation;
    }

    public String getTemperature() {
        return mTemperature;
    }

    public String getCondition() {
        return mCondition;
    }

    public String getDate() {
        return mDate;
    }

    public String getHour() {
        return mHour;
    }

    @NonNull
    @Override
    public String toString() {
        return "" //+ mLocation + "\n"
                + mTemperature + "\n"
                + mCondition + "\n"
                //+ mDate + "\n"
                + mHour + "\n";
    }
}

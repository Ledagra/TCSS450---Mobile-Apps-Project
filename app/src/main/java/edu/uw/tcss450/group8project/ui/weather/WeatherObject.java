package edu.uw.tcss450.group8project.ui.weather;

public class WeatherObject {
    private String mLocation;
    private double mTemp;
    private String mDescription;

    public WeatherObject(String location, double temp, String description) {
        this.mLocation = location;
        this.mTemp = temp;
        this.mDescription = description;
    }

    public String getLocation() {
        return mLocation;
    }

    public double getTemp() {
        return mTemp;
    }

    public String getDescription() {
        return mDescription;
    }
}

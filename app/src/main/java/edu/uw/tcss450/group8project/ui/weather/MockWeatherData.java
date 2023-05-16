package edu.uw.tcss450.group8project.ui.weather;

import org.json.JSONException;
import org.json.JSONObject;

public class MockWeatherData {

    private JSONObject mMockWeather;


    public MockWeatherData() throws JSONException {
        mMockWeather = new JSONObject();
        fillJSONData();
    }

    private void fillJSONData() throws JSONException {
        JSONObject currentJSON = new JSONObject();
        currentJSON.put("cityName", "Bonney Lake");
        currentJSON.put("currTemp", "0 C°");
        currentJSON.put("currCon", "Sunny");
        mMockWeather.put("current", currentJSON);

        JSONObject[] hourlyJSON = new JSONObject[24];
        for (int i = 0; i < 24; i++) {
            hourlyJSON[i] = new JSONObject();
            hourlyJSON[i].put("hour", i);
            hourlyJSON[i].put("temp", i + " C°");
            hourlyJSON[i].put("con", "Sunny");
        }
        mMockWeather.put("hourly", hourlyJSON);

        JSONObject[] dailyJSON = new JSONObject[7];
        for (int i = 0; i < 7; i++) {
            dailyJSON[i] = new JSONObject();
            dailyJSON[i].put("day", "Mar " + (i + 1));
            dailyJSON[i].put("temp", i + " C°");
            dailyJSON[i].put("con", "Sunny");
        }
        mMockWeather.put("daily", dailyJSON);
    }

    public JSONObject getMockWeather() {
        return mMockWeather;
    }




}

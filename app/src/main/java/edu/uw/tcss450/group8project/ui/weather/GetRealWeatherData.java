package edu.uw.tcss450.group8project.ui.weather;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import edu.uw.tcss450.group8project.R;

public class GetRealWeatherData {
    private MutableLiveData<JSONObject> mDataResponse;

    private String mZipCode;

    public GetRealWeatherData(final String zipCode) {
        if(zipCode.length() == 5 &&
                zipCode.matches("[0-9]+")) {
            mZipCode = zipCode;
        } else {
            mZipCode = "98391";
        }
        talkToAPI();
    }

    private void talkToAPI() {
        String url = "https://huskytalk.herokuapp.com/weatherCurrent";

        JSONObject body = new JSONObject();

        try {
            body.put("location", mZipCode);
        } catch (JSONException e) {
            Log.w("JSON ERROR", e.toString());
        }

        Request request = new JsonObjectRequest();


        )
    }

    public String getRawJSON() {
        return mDataResponse;
    }
}

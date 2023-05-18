package edu.uw.tcss450.group8project.ui.weather;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

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
        Log.i("Weather Data", mDataResponse.toString());
    }

    private void talkToAPI() {
        String url = "https://huskytalk.herokuapp.com/weatherCurrent";

        JSONObject body = new JSONObject();

        try {
            body.put("location", mZipCode);
        } catch (JSONException e) {
            Log.w("JSON ERROR", e.toString());
        }

        Request request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                body,
                mDataResponse::setValue,
                null);

        request.setRetryPolicy(new DefaultRetryPolicy(
                10_000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(null).add(request);
    }
}

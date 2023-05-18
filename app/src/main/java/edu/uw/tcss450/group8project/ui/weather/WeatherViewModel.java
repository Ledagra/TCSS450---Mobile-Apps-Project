package edu.uw.tcss450.group8project.ui.weather;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherViewModel extends AndroidViewModel {
    private MutableLiveData<JSONObject> mDataResponse;

    public WeatherViewModel(@NonNull Application application) {
        super(application);
        mDataResponse = new MutableLiveData<>();
        mDataResponse.setValue(new JSONObject());
    }

    public void talkToAPI(String zipCode) {
        String url = "https://huskytalk.herokuapp.com/weatherForecast";

        JSONObject body = new JSONObject();

        try {
            body.put("location", zipCode);
        } catch (JSONException e) {
            Log.w("JSON ERROR", e.toString());
        }

        Request request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                body,
                mDataResponse::setValue,
                this::handleError);

        request.setRetryPolicy(new DefaultRetryPolicy(
                10_000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(getApplication().getApplicationContext()).add(request);
    }

    private void handleError(VolleyError volleyError) {
        Log.e("CONNECTION ERROR", volleyError.toString());
    }
}

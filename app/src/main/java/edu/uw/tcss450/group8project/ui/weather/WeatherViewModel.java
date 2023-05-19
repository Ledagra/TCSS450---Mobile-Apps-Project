package edu.uw.tcss450.group8project.ui.weather;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WeatherViewModel extends AndroidViewModel {
    private MutableLiveData<JSONObject> mDataResponse;

    public WeatherViewModel(@NonNull Application application) {
        super(application);
        mDataResponse = new MutableLiveData<>();
        mDataResponse.setValue(new JSONObject());
    }

    public void addResponseObserver(@NonNull LifecycleOwner owner,
                                    @NonNull Observer<? super JSONObject> observer) {
        mDataResponse.observe(owner, observer);
    }

    public void talkToAPI(final String zipCode){
        String url = "https://huskytalk.herokuapp.com/weatherForecast";

        Map<String, String> bodyInit = new HashMap<>();
        bodyInit.put("location", zipCode);

        JsonObjectRequest request = new JsonObjectRequest(
                url,
                new JSONObject(bodyInit),
                mDataResponse::setValue,
                this::handleError);

        request.setRetryPolicy(new DefaultRetryPolicy(
                10_000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(getApplication()
                .getApplicationContext()).add(request);
    }

    private void handleError(@NonNull VolleyError volleyError) {
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (networkResponse != null && networkResponse.data != null) {
            String jsonError = new String(networkResponse.data);
            Log.e("Volley Error: ", jsonError);
        }
    }
}

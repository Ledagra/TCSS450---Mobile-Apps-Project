package edu.uw.tcss450.group8project.ui.weather;

import android.os.Bundle;

import android.app.Application;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import edu.uw.tcss450.group8project.R;
import edu.uw.tcss450.group8project.databinding.FragmentWeatherBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public final class WeatherFragment extends Fragment {

    private WeatherViewModel mViewModel;

    private FragmentWeatherBinding mBinding;

    private ArrayList<WeatherObject[]> mWeatherObjects;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new WeatherViewModel((Application) getActivity().getApplicationContext());

        mViewModel.addResponseObserver(this, list -> {
            TextView cityName = getView().findViewById(R.id.curr_location_name);
            TextView currentTemp = getView().findViewById(R.id.curr_location_temp);
            TextView currentCondition = getView().findViewById(R.id.curr_location_con);
            RecyclerView dailyRecyclerView = getView().findViewById(R.id.daily_forecast_recycler_view);

            TextView jsonTextView = getView().findViewById(R.id.json_info);
            try{
                jsonTextView.setText(list.getJSONArray("daily").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }


            if(mViewModel.getResponseSize() > 0) {
                mWeatherObjects = setWeatherObjects(mViewModel.getResponse());
                cityName.setText(mWeatherObjects.get(0)[0].getLocation());
                currentTemp.setText(mWeatherObjects.get(0)[0].getTemperature() + " °C");
                currentCondition.setText(mWeatherObjects.get(0)[0].getCondition());
                mBinding.hourlyForecastRecyclerView
                        .setAdapter(new HourlyWeatherAdapter(mWeatherObjects.get(2)));
                mBinding.dailyForecastRecyclerView
                        .setAdapter(new DailyWeatherAdapter(mWeatherObjects.get(1)));
            }
        });
    }

    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {
        mBinding = FragmentWeatherBinding.inflate(inflater);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.searchLocationButton.setOnClickListener(button -> searchLocation());
    }

    private void searchLocation() {
        String test = mBinding.searchLocation.getText().toString();

        boolean toContinue = validateZipCode(test);

        if(toContinue) {
            Log.i("Valid ZIP", test);
            mViewModel.talkToAPI(test);
        } else {
            Log.w("Invalid ZIP", "Invalid ZIP");
        }
    }

    private boolean validateZipCode(final String theZip) {
        return theZip.length() == 5 && theZip.matches("[0-9]+");
    }

    private ArrayList<WeatherObject[]> setWeatherObjects(MutableLiveData<JSONObject> theList) {
        WeatherObject[] currentWeatherObjects = new WeatherObject[1];
        WeatherObject[] dailyWeatherObjects = new WeatherObject[7];
        WeatherObject[] hourlyWeatherObjects = new WeatherObject[24];
        ArrayList<WeatherObject[]> allWeatherObjects = new ArrayList<>();

        WeatherObject weatherObjectTemp = null;
        JSONObject tempJSON = null;

        try {
            tempJSON = theList.getValue().getJSONObject("current");
            weatherObjectTemp = new WeatherObject(tempJSON.getString("cityName"),
                    tempJSON.getString("currTemp"),
                    tempJSON.getString("currCon"),
                    "");
            currentWeatherObjects[0] = weatherObjectTemp;

            for(int i = 0; i < 6; i++) {
                tempJSON = theList.getValue().getJSONArray("daily").getJSONObject(i);
                weatherObjectTemp = new WeatherObject(tempJSON.getString("day"),
                        tempJSON.getString("dayTemp"),
                        tempJSON.getString("dayCon"));
                dailyWeatherObjects[i] = weatherObjectTemp;
            }

            for(int i = 0; i < 24; i++) {
                tempJSON = theList.getValue().getJSONArray("hourly").getJSONObject(i);
                weatherObjectTemp = new WeatherObject(tempJSON.getString("hourTemp"),
                        tempJSON.getString("hourCon"),i);
                hourlyWeatherObjects[i] = weatherObjectTemp;
            }


        } catch (JSONException e) {
            Log.e("Error parsing through data response", e.getMessage());
        }





        allWeatherObjects.add(currentWeatherObjects);
        allWeatherObjects.add(dailyWeatherObjects);
        allWeatherObjects.add(hourlyWeatherObjects);
        return allWeatherObjects;
    }

}

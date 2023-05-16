package edu.uw.tcss450.group8project.ui.weather;


import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.uw.tcss450.group8project.R;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {
    private JSONArray mWeatherData;

    private String mRawJSON;

    public WeatherAdapter(JSONObject weatherData) {
        mRawJSON = weatherData.toString();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View hourlyView = View.inflate(parent.getContext(),
                R.layout.daily_weather_card_item, null);

        return new MyViewHolder(hourlyView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder,
                                 final int position) {
        holder.mJSONInfo.setText(mRawJSON);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mDate;
        private TextView mTemp;
        private TextView mCondition;

        private TextView mJSONInfo;

        public MyViewHolder(final View itemView) {
            super(itemView);
            mDate = itemView.findViewById(R.id.card_forecast_day);
            mTemp = itemView.findViewById(R.id.card_forecast_temp);
            mCondition = itemView.findViewById(R.id.card_forecast_con);
        }

    }
}

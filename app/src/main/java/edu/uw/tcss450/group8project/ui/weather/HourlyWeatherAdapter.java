package edu.uw.tcss450.group8project.ui.weather;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.uw.tcss450.group8project.R;

public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.MyViewHolder> {

    private WeatherObject[] mHourlyWeather;

    public HourlyWeatherAdapter(final WeatherObject[] theHourlyWeather) {
        mHourlyWeather = theHourlyWeather;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View hourlyView = View.inflate(parent.getContext(),
                R.layout.hourly_weather_card_item, null);

        return new MyViewHolder(hourlyView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder,
                                 final int position) {
        holder.setHourlyWeather(mHourlyWeather[position]);

    }

    @Override
    public int getItemCount() {
        return mHourlyWeather.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTemp;
        private TextView mCondition;

        private TextView mHour;


        public MyViewHolder(final View itemView) {
            super(itemView);
            mHour = itemView.findViewById(R.id.card_forecast_hour);
            mTemp = itemView.findViewById(R.id.card_forecast_temp);
            mCondition = itemView.findViewById(R.id.card_forecast_con);
        }

        void setHourlyWeather(WeatherObject theHour) {
            mTemp.setText(theHour.getTemperature() + " °C");
            mCondition.setText(theHour.getCondition());
            mHour.setText(theHour.getHour());

        }

    }
}

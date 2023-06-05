package edu.uw.tcss450.group8project.ui.weather;


import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.uw.tcss450.group8project.R;

public class DailyWeatherAdapter extends RecyclerView.Adapter<DailyWeatherAdapter.MyViewHolder> {

    private WeatherObject[] mDailyWeather;


    public DailyWeatherAdapter(final WeatherObject[] theDailyWeather) {
        mDailyWeather = theDailyWeather;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View dailyView = View.inflate(parent.getContext(),
                R.layout.daily_weather_card_item, null);

        return new MyViewHolder(dailyView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder,
                                 final int position) {

        holder.setDailyWeather(mDailyWeather[position]);


    }

    @Override
    public int getItemCount() {
        return mDailyWeather.length - 1;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mDay;
        private TextView mTemp;
        private TextView mCondition;

        public MyViewHolder(final View itemView) {
            super(itemView);
            mDay = itemView.findViewById(R.id.card_forecast_day);
            mTemp = itemView.findViewById(R.id.card_forecast_temp);
            mCondition = itemView.findViewById(R.id.card_forecast_con);
        }

        public void setDailyWeather(WeatherObject theDay) {
            mDay.setText(theDay.getDate());
            mTemp.setText(theDay.getTemperature() + " °C");
            mCondition.setText(theDay.getCondition());
        }

    }
}

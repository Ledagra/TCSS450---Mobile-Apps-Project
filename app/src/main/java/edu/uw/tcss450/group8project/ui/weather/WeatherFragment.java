package edu.uw.tcss450.group8project.ui.weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.uw.tcss450.group8project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public final class WeatherFragment extends Fragment {
    private MockWeatherData mMockWeatherData;
    private String mRawJSON;

    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView jsonView = view.findViewById(R.id.json_info);

        GetRealWeatherData getRealWeatherData = new GetRealWeatherData("98391");

        jsonView.setText(getRealWeatherData.getRawJSON());
    }
}

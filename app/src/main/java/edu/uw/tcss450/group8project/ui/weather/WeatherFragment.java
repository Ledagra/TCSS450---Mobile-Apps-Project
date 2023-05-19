package edu.uw.tcss450.group8project.ui.weather;

import android.os.Bundle;

import android.app.Application;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
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
import edu.uw.tcss450.group8project.databinding.FragmentWeatherBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public final class WeatherFragment extends Fragment {

    private WeatherViewModel mViewModel;

    private FragmentWeatherBinding mBinding;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(getActivity())
                .get(WeatherViewModel.class);

        mViewModel.addResponseObserver(this, list -> {
            TextView tv = getView().findViewById(R.id.json_info);

            tv.setText(list.toString());
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

}

package edu.uw.tcss450.group8project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import edu.uw.tcss450.group8project.model.UserInfoViewModel;
import edu.uw.tcss450.group8project.R;
import edu.uw.tcss450.group8project.ui.weather.GetRealWeatherData;

/**
 * Main Activity for the app.
 */
public final class MainActivity extends AppCompatActivity {
    /** AppBarConfiguration object. */
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MainActivity args = MainActivityArgs
//                .fromBundle(getIntent().getExtras());

        MainActivityArgs args = MainActivityArgs.fromBundle(getIntent().getExtras());

        new ViewModelProvider(this,
                new UserInfoViewModel
                        .UserInfoViewModelFactory(args.getEmail(),
                        args.getJwt()))
                .get(UserInfoViewModel.class);

        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        //Passing each menu ID as a set of Ids because each
        //menu should be considered as top level destinations
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_messages,
                R.id.navigation_weather,
                R.id.navigation_friends).build();
        NavController navController = Navigation
                .findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,
                navController,
                mAppBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);

//        SearchManager searchManager = (SearchManager)
//                getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView)
//                menu.findItem(R.id.action_search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

//    @Override
//    public void onNewIntent(final Intent intent) {
//        super.onNewIntent(intent);
//        handleIntent(intent);
//    }

//    private void handleIntent(final Intent intent) {
//        String query = "";
//        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//            query = intent.getStringExtra(SearchManager.QUERY);
//            Log.w("Search Query Entered: ", query);
//        }
//
//        View weatherView = findViewById(R.id.navigation_weather);
//
//        new GetRealWeatherData(query, weatherView);
//    }
}

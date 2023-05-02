package edu.uw.tcss450.lab3_authentication.ui.friends;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.uw.tcss450.lab3_authentication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendListFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView listView;
        String[] friendList = {"Steve", "Bob", "Chuck", "Larry", "Ethel", "Gertrude", "Hilda"};

        listView = (ListView) getView().findViewById(R.id.navigation_friends);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>();
        listView.setAdapter(arrayAdapter);
        return inflater.inflate(R.layout.fragment_friend_list, container, false);
    }
}
package edu.uw.tcss450.lab3_authentication.ui.friends;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.uw.tcss450.lab3_authentication.R;
import edu.uw.tcss450.lab3_authentication.model.UserInfoViewModel;

/**
 * Fragment to display a list of friends.
 */
public final class FriendListFragment extends Fragment {

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.items_list, container, false);
//    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        UserInfoViewModel model = new ViewModelProvider(getActivity())
//                .get(UserInfoViewModel.class);
//
//    }
    /** String variable for first parameter. */
    private String param1;
    /** String variable for second parameter. */
    private String param2;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString("param1");
            param2 = getArguments().getString("param2");
        }
    }
//
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friend_list,
                container, false);
    }
//    /**
//     * Method to create a new instance of
//     * FriendListFragment.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment
//     * FriendListFragment.
//     */
//    public static FriendListFragment newInstance(final String param1,
//                                            final String param2) {
//        FriendListFragment fragment = new FriendListFragment();
//        Bundle args = new Bundle();
//        args.putString("param1", param1);
//        args.putString("param2", param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
    @Override
    public void onViewCreated(final View view,
                              final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this.getContext(),
                LinearLayoutManager.VERTICAL,
                false);

        // getting the friend list
        ArrayList<Friend> friendList
                = Constants.getFriendData();

        Log.w("FriendListFragment", "onViewCreated: " + friendList.size());
        Log.w("FriendListFragment", "onViewCreated: " + friendList.get(0).getName());
        Log.w("FriendListFragment", "onViewCreated: " + friendList.get(0).getEmail());

        // Assign employeelist to ItemAdapter
        FriendAdapter friendAdapter = new FriendAdapter(friendList);



        // Set the LayoutManager that
        // this RecyclerView will use.
        RecyclerView recyclerView
                = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(layoutManager);
//
//        // adapter instance is set to the
//        // recyclerview to inflate the items.
        recyclerView.setAdapter(friendAdapter);
    }
}

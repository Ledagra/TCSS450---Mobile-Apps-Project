package edu.uw.tcss450.group8project.ui.friends;

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

import edu.uw.tcss450.group8project.R;
import edu.uw.tcss450.group8project.databinding.FragmentChatListBinding;
import edu.uw.tcss450.group8project.databinding.FragmentFriendListBinding;
import edu.uw.tcss450.group8project.model.UserInfoViewModel;
import edu.uw.tcss450.group8project.ui.chat.ChatListRecyclerViewAdapter;

/**
 * Fragment to display a list of friends.
 */
public final class FriendListFragment extends Fragment {
    private FriendListViewModel mModel;
    private UserInfoViewModel mUserModel;
    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(getActivity());
        mUserModel = provider.get(UserInfoViewModel.class);
        mModel = provider.get(FriendListViewModel.class);
        mModel.connectGet(mUserModel.getmJwt());
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friend_list, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentFriendListBinding binding = FragmentFriendListBinding.bind(getView());
        mModel.addFriendListObserver(getViewLifecycleOwner(), friendList -> {
            if (!friendList.isEmpty()) {
                binding.listRoot.setAdapter(new FriendListRecyclerViewAdapter(friendList));
            }
            binding.layoutWait.setVisibility(View.GONE);
        });
    }
}

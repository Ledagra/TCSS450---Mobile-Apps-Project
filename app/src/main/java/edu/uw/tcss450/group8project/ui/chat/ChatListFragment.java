package edu.uw.tcss450.group8project.ui.chat;

import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.auth0.android.jwt.JWT;

import edu.uw.tcss450.group8project.MainActivity;
import edu.uw.tcss450.group8project.R;
import edu.uw.tcss450.group8project.databinding.FragmentChatListBinding;
import edu.uw.tcss450.group8project.model.NewMessageCountViewModel;
import edu.uw.tcss450.group8project.model.UserInfoViewModel;
import edu.uw.tcss450.group8project.services.PushReceiver;

public class ChatListFragment extends Fragment {

    private ChatListViewModel mModel;
    private UserInfoViewModel mUserModel;
    private FragmentChatListBinding binding;

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider provider = new ViewModelProvider(getActivity());
        mUserModel = provider.get(UserInfoViewModel.class);
        mModel = provider.get(ChatListViewModel.class);
        mModel.connectGet(mUserModel.getmJwt());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentChatListBinding.inflate(inflater);
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_chat_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentChatListBinding binding = FragmentChatListBinding.bind(getView());
        mModel.addChatListObserver(getViewLifecycleOwner(), chatList -> {
            if (!chatList.isEmpty()) {
                binding.listRoot.setAdapter(new ChatListRecyclerViewAdapter(chatList, mUserModel.getmUsername()));
            }
            binding.layoutWait.setVisibility(View.GONE);
        });
        binding.buttonCreateChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(ChatListFragmentDirections.actionNavigationChatlistToChatCreateFragment());
            }
        });
    }
}
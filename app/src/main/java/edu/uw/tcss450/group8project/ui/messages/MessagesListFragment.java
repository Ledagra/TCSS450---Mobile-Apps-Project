package edu.uw.tcss450.group8project.ui.messages;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import edu.uw.tcss450.group8project.R;
import edu.uw.tcss450.group8project.ui.HomeFragment;
import edu.uw.tcss450.group8project.ui.chat.ChatFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public final class MessagesListFragment extends Fragment {

    private String param1;
    private String param2;
    private String param3;
    @Override
    public void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            param1 = getArguments().getString("param1");
            param2 = getArguments().getString("param2");
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this.getContext(),
                LinearLayoutManager.VERTICAL,
                false);

        ArrayList<Message> messageList = MessageInfo.getMessageData();

        Log.w("MessagesListFragment", "onViewCreated: " + messageList.size());
        Log.w("MessagesListFragment", "onViewCreated: " + messageList.get(0).getName());
        Log.w("MessagesListFragment", "onViewCreated: " + messageList.get(0).getRecentText());
        Log.w("MessagesListFragment", "onViewCreated: " + messageList.get(0).getTime());


        MessageAdapter messageAdapter = new MessageAdapter(messageList);

        RecyclerView recyclerView
                = view.findViewById(R.id.messageRecyclerView);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(messageAdapter);

        //handling the image button to create a new chatroom
        ImageButton imageButton = view.findViewById(R.id.addButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_messages_to_creatChatRoomDialog2);
            }

        });



    }

//    public void replaceFragment(Fragment someFragment) {
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.chat_layout, someFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
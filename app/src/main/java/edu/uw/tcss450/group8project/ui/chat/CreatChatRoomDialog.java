package edu.uw.tcss450.group8project.ui.chat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

import edu.uw.tcss450.group8project.R;
import edu.uw.tcss450.group8project.ui.friends.Constants;
import edu.uw.tcss450.group8project.ui.friends.Friend;
import edu.uw.tcss450.group8project.ui.messages.Message;
import edu.uw.tcss450.group8project.ui.messages.MessageInfo;

public class CreatChatRoomDialog extends DialogFragment {

    private ArrayList<Friend> selectedList;
    private ArrayList<Friend> mFriend = Constants.getFriendData();
    private ArrayList<Message> mMessage;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        selectedList = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Convert ArrayList to string array
        String[] friendNames = new String[mFriend.size()];
        for (int i = 0; i < mFriend.size(); i++) {
            friendNames[i] = mFriend.get(i).getName(); // Replace 'getName()' with the appropriate method to get the friend's name
        }


        //set dialog title
        builder.setTitle("Select Contacts")
                .setMultiChoiceItems(friendNames, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked){
                            //user selected the item, add it to the selected item
                            selectedList.add(mFriend.get(which));
                        } else if(selectedList.contains(mFriend.get(which))){
                            //item already in the array, remove it (uncheck)
                            selectedList.remove(mFriend.get(which));
                        }
                    }
                })
                .setPositiveButton("Create Chatroom", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //create chatroom with new contacts
                        //add it into the
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });


        


        return builder.create();
    }
}

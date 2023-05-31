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
import edu.uw.tcss450.group8project.ui.messages.MessageInfo;

public class CreatChatRoomDialog extends DialogFragment {

    private ArrayList<Friend> selectedList;
    private ArrayList<Friend> mFriend = Constants.getFriendData();

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        selectedList = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //set dialog title
        builder.setTitle("Select Contacts")
//                .setMultiChoiceItems(mFriend, null, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                        if(isChecked){
//                            //user selected the item, add it to the selected item
//                            selectedList.add(mFriend.get(which));
//                        } else if(selectedList.contains(mFriend.get(which))){
//                            //item already in the array, remove it (uncheck)
//                            selectedList.remove(mFriend.get(which));
//                        }
//                    }
//                })
                .setPositiveButton("Create Chatroom", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //create chatroom with new contacts
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

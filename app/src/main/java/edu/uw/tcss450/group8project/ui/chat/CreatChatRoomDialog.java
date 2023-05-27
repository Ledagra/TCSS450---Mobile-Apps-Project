package edu.uw.tcss450.group8project.ui.chat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

import edu.uw.tcss450.group8project.ui.friends.Friend;

public class CreatChatRoomDialog extends DialogFragment {

    private ArrayList<Friend> selectedList;
    private ArrayList<Friend> mFriend;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        selectedList = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //set dialog title
        builder.setTitle("Select Contacts")
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

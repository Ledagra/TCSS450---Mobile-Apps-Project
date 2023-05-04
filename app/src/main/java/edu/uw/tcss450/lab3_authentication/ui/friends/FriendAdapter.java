package edu.uw.tcss450.lab3_authentication.ui.friends;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.uw.tcss450.lab3_authentication.R;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder> {
    private ArrayList<Friend> mFriendList;

    public FriendAdapter(ArrayList<Friend> friendList) {
        this.mFriendList = friendList;
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_friend_list, parent, false);
        return new MyViewHolder(itemView);
    }

    // This method returns the total
    // number of items in the data set
    @Override
    public int getItemCount() {
        return mFriendList.size();
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Friend currentFriend = mFriendList.get(position);
        holder.name.setText(currentFriend.getName());
        holder.email.setText(currentFriend.getEmail());
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView email;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
        }
    }
}

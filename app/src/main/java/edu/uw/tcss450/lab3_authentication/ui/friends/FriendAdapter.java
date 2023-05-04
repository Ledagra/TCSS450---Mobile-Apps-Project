package edu.uw.tcss450.lab3_authentication.ui.friends;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.uw.tcss450.lab3_authentication.R;

/**
 * Adapts friend object to recycler view.
 */
public final class FriendAdapter extends
        RecyclerView.Adapter<FriendAdapter.MyViewHolder> {
    /** List of friends. */
    private ArrayList<Friend> mFriendList;
    /** Constructor for FriendAdapter.
     * @param friendList list of friends
     */
    public FriendAdapter(final ArrayList<Friend> friendList) {
        this.mFriendList = friendList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent,
                                           final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_friend_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,
                                 final int position) {
        Friend currentFriend = mFriendList.get(position);
        holder.name.setText(currentFriend.getName());
        holder.email.setText(currentFriend.getEmail());
    }

    /**
     * This class defines the ViewHolder object for
     * each item in the RecyclerView.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        /** TextView for the friend's name. */
        private TextView name;
        /** TextView for the friend's email. */
        private TextView email;

        /**
         * Constructor for the ViewHolder.
         * @param itemView view of the item
         */
        public MyViewHolder(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
        }
    }
}

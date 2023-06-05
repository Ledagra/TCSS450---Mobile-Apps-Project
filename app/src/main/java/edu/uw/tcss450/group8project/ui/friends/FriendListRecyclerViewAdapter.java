package edu.uw.tcss450.group8project.ui.friends;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.uw.tcss450.group8project.R;
import edu.uw.tcss450.group8project.databinding.FragmentChatCardBinding;
import edu.uw.tcss450.group8project.databinding.FragmentFriendCardBinding;

/**
 * Adapts friend object to recycler view.
 */
public final class FriendListRecyclerViewAdapter extends
        RecyclerView.Adapter<FriendListRecyclerViewAdapter.FriendViewHolder> {
    // TODO: Implement the ViewModel
    private final List<Friend> mFriendlist;
    public FriendListRecyclerViewAdapter(List<Friend> items) {
        this.mFriendlist = items;
    }
    @NonNull
    @Override
    public FriendListRecyclerViewAdapter.FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendListRecyclerViewAdapter.FriendViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.fragment_friend_card, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull FriendListRecyclerViewAdapter.FriendViewHolder holder, int position) {
        holder.setFriend(mFriendlist.get(position));
    }
    @Override
    public int getItemCount() { return mFriendlist.size(); }

    /**
     * Objects from this class represent an Individual row View from the List
     * of rows in the Blog Recycler View.
     */
    public class FriendViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public FragmentFriendCardBinding binding;
        private Friend mFriend;
        public FriendViewHolder(View view) {
            super(view);
            mView = view;
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            binding = FragmentFriendCardBinding.bind(view);
        }
        void setFriend(final Friend friend) {
            mFriend = friend;
            binding.textFriendCardUsername.setText(friend.getName());
            binding.textFriendCardEmail.setText(friend.getEmail());
        }
    }
}

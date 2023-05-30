package edu.uw.tcss450.group8project.ui.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.uw.tcss450.group8project.R;
import edu.uw.tcss450.group8project.databinding.FragmentChatCardBinding;

public class ChatListRecyclerViewAdapter extends RecyclerView.Adapter<ChatListRecyclerViewAdapter.ChatViewHolder> {
    // TODO: Implement the ViewModel
    private final List<ChatPreview> mChatPreviews;
    public ChatListRecyclerViewAdapter(List<ChatPreview> items) {
        this.mChatPreviews = items;

    }
    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.fragment_chat_card, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.setChat(mChatPreviews.get(position));
    }
    @Override
    public int getItemCount() { return mChatPreviews.size(); }

    /**
     * Objects from this class represent an Individual row View from the List
     * of rows in the Blog Recycler View.
     */
    public class ChatViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public FragmentChatCardBinding binding;
        private ChatPreview mChatPreview;
        public ChatViewHolder(View view) {
            super(view);
            mView = view;
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(mView)
                            .navigate(ChatListFragmentDirections
                                    .actionChatListFragmentToChatFragment());
                }
            });
            binding = FragmentChatCardBinding.bind(view);
        }
        void setChat(final ChatPreview chatPreview) {
            mChatPreview = chatPreview;
            binding.textChatCardUsername.setText(chatPreview.getmChatname());
            binding.textChatCardTime.setText(chatPreview.getmTime());
            binding.testChatCardPreview.setText(chatPreview.getmPreview());

        }
    }
}
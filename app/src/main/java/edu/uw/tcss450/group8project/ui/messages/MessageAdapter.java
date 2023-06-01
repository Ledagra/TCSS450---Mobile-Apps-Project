package edu.uw.tcss450.group8project.ui.messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.uw.tcss450.group8project.R;

public class MessageAdapter extends
        RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> mMessageList;

    public MessageAdapter(List<Message> messageList){ this.mMessageList = messageList; }



    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_item, parent, false);

        //handling the CardView when clicked to open the chatroom associate with the recipient/group
        CardView cardView = itemView.findViewById(R.id.messageListCardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //move to the chatroom fragment associated with the chatid
                Navigation.findNavController(itemView).navigate(R.id.action_navigation_messages_to_chatFragment2);
            }
        });
        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MessageViewHolder holder,
                                 final int position) {
        Message currentMessage = mMessageList.get(position);

        holder.name.setText(currentMessage.getName());
        holder.recentText.setText(currentMessage.getRecentText());
        holder.recentTime.setText(currentMessage.getTime());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }


    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView recentText;

        private TextView recentTime;

        public MessageViewHolder(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            recentText = itemView.findViewById(R.id.recentText);
            recentTime = itemView.findViewById(R.id.recentTime);
        }

    }
}

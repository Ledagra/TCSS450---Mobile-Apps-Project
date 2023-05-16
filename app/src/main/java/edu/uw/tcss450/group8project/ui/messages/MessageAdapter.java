package edu.uw.tcss450.group8project.ui.messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        return new MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MessageViewHolder holder,
                                 final int position) {
        Message currentMessage = mMessageList.get(position);

        holder.name.setText(currentMessage.getName());
        holder.recentText.setText(currentMessage.getRecentText());
        holder.divider.setText(currentMessage.getDivider());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }


    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView recentText;

        private TextView divider;
        public MessageViewHolder(final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            recentText = itemView.findViewById(R.id.recentText);
            divider = itemView.findViewById(R.id.divider);
        }

    }
}

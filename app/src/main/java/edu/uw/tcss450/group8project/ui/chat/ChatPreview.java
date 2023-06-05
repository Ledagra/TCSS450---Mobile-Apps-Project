package edu.uw.tcss450.group8project.ui.chat;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class ChatPreview implements Serializable {
    private final String mTime;
    private final String mChatname;
    private final String mPreview;
    private final int mChatId;

    /**
     * Helper class for building Credentials.
     *
     * @author Fred Xu
     */
    public static class Builder {
        private final String mTime;
        private final String mChatname;
        private String mPreview = "";
        private final int mChatId;

        /**
         * Constructs a new Builder.
         *
         * @param time the published date of the chat message
         * @param chatname the other user's name of the chat
         */
        public Builder(String time, String chatname, int chatid) {
            this.mTime = time;
            this.mChatname = chatname;
            this.mChatId = chatid;
        }

        /**
         * Add an optional preview of the chat.
         * @param val an optional preview of the chat.
         * @return the Builder of this BlogPost
         */
        public Builder addPreview(final String val) {
            mPreview = val;
            return this;
        }

        public ChatPreview build() {
            return new ChatPreview(this);
        }

    }

    private ChatPreview(final Builder builder) {
        this.mTime = builder.mTime;
        this.mChatname = builder.mChatname;
        this.mPreview = builder.mPreview;
        this.mChatId = builder.mChatId;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmChatname() {
        return mChatname;
    }

    public String getmPreview() { return mPreview; }

    public int getmChatId() { return mChatId; }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof ChatPreview) {
            ChatPreview ptr = (ChatPreview) obj;
            result = ptr.getmChatId() == this.getmChatId();
        }
        return result;
    }
}

package edu.uw.tcss450.group8project.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class ChatInfoViewModel extends ViewModel {

    private final List<String> mUsernames;
    private final int mChatid;

    private ChatInfoViewModel(List<String> usernames, int chatid) {
        mUsernames = usernames;
        mChatid = chatid;
    }

    public List<String> getmUsernames() {
        return mUsernames;
    }

    public int getmChatid() {
        return mChatid;
    }

    public static class UserInfoViewModelFactory implements ViewModelProvider.Factory {

        private final List<String> mUsernames;
        private final int chatid;

        public UserInfoViewModelFactory(List<String> usernames, int chatid) {
            this.mUsernames = usernames;
            this.chatid = chatid;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass == ChatInfoViewModel.class) {
                return (T) new ChatInfoViewModel(mUsernames, chatid);
            }
            throw new IllegalArgumentException(
                    "Argument must be: " + ChatInfoViewModel.class);
        }
    }
}
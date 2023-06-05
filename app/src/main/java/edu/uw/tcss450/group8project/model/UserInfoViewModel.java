package edu.uw.tcss450.group8project.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class UserInfoViewModel extends ViewModel {

    private final String mUsername;
    private final String mJwt;


    private UserInfoViewModel(String username, String jwt) {
        mUsername = username;
        mJwt = jwt;
    }

    public String getmUsername() {
        return mUsername;
    }

    public String getmJwt() {
        return mJwt;
    }

    public static class UserInfoViewModelFactory implements ViewModelProvider.Factory {

        private final String mUsername;
        private final String jwt;

        public UserInfoViewModelFactory(String username, String jwt) {
            this.mUsername = username;
            this.jwt = jwt;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass == UserInfoViewModel.class) {
                return (T) new UserInfoViewModel(mUsername, jwt);
            }
            throw new IllegalArgumentException(
                    "Argument must be: " + UserInfoViewModel.class);
        }
    }
}
package edu.uw.tcss450.group8project.ui.chat;

import static edu.uw.tcss450.group8project.utils.PasswordValidator.checkExcludeWhiteSpace;
import static edu.uw.tcss450.group8project.utils.PasswordValidator.checkPwdLength;
import static edu.uw.tcss450.group8project.utils.PasswordValidator.checkPwdSpecialChar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import edu.uw.tcss450.group8project.databinding.FragmentChatCreateBinding;
import edu.uw.tcss450.group8project.model.UserInfoViewModel;
import edu.uw.tcss450.group8project.utils.PasswordValidator;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatCreateFragment extends Fragment {

    private FragmentChatCreateBinding mBinding;
    private ChatCreateViewModel mCreateModel;
    private UserInfoViewModel mUserModel;
    private PasswordValidator mNameValidator = checkPwdLength(1);
    private PasswordValidator mEmailValidator = checkPwdLength(2)
            .and(checkExcludeWhiteSpace())
            .and(checkPwdSpecialChar("@"));
    public ChatCreateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserModel = new ViewModelProvider(getActivity())
                .get(UserInfoViewModel.class);
        mCreateModel = new ViewModelProvider(getActivity())
                .get(ChatCreateViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentChatCreateBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return mBinding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.buttonCreateChat.setOnClickListener(this::attemptCreate);

        mCreateModel.addResponseObserver(
                getViewLifecycleOwner(),
                this::observeCreateResponse);
    }

    private void observeCreateResponse(JSONObject response) {
        if (response.length() > 0) {
            if (response.has("code")) {
                try {
                    mBinding.editEmail.setError(
                            "Error Authenticating: " +
                                    response.getJSONObject("data").getString("message"));
                } catch (JSONException e) {
                    Log.e("JSON Parse Error", e.getMessage());
                }
            } else {
                int chatid = -1;
                try {
                    chatid = response.getInt("chatID");
                } catch ( JSONException e) {
                    Log.e("JSON Parse Error", e.getMessage());
                }
                navigateToChatList();
            }
        } else {
            Log.d("JSON Response", "No Response");
        }
    }

    private void navigateToChatList() {
        Navigation.findNavController(getView())
                .navigate(ChatCreateFragmentDirections
                        .actionChatCreateFragmentToNavigationChatlist());
    }

    private void attemptCreate(View view) {
        validateEmail();
    }
    private void validateEmail() {
        mEmailValidator.processResult(
                mEmailValidator.apply(mBinding.editEmail.getText().toString().trim()),
                this::validateChatname,
                result -> mBinding.editEmail.setError("Please enter a valid Email address."));
    }
    private void validateChatname() {
        mNameValidator.processResult(
                mNameValidator.apply(mBinding.editName
                        .getText().toString().trim()),
                this::verifyAuthWithServer,
                result -> mBinding.editName
                        .setError("Please enter a username."));
    }
    private void verifyAuthWithServer() {
        mCreateModel.connect(
                mUserModel.getmJwt(),
                mBinding.editEmail.getText().toString(),
                mBinding.editName.getText().toString());
    }
}
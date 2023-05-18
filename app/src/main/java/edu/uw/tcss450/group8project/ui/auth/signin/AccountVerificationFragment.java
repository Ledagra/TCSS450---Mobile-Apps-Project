package edu.uw.tcss450.group8project.ui.auth.signin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.group8project.R;
import edu.uw.tcss450.group8project.databinding.FragmentAccountVerificationBinding;
import edu.uw.tcss450.group8project.databinding.FragmentSignInBinding;

public class AccountVerificationFragment extends Fragment {

    private FragmentAccountVerificationBinding mbinding;

    private AccountVerificationViewModel mAVModel;

    public AccountVerificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAVModel = new ViewModelProvider(getActivity()).get(AccountVerificationViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mbinding = FragmentAccountVerificationBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return mbinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mbinding.buttonResend.setOnClickListener(this::attemptResend);

        //AccountVerificationFragmentArgs args = AccountVerificationFragmentArgs.fromBundle(getArguments());
    }

    private void attemptResend(View button) {
        verifyWithServer();
    }

    private void verifyWithServer() {
        //mAVModel.connect();
    }
}
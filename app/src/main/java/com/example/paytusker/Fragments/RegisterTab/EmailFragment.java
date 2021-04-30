package com.example.paytusker.Fragments.RegisterTab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.paytusker.R;

public class EmailFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button email_button;

    public EmailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_email, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        email_button.setOnClickListener(this);
    }

    private void ids() {
        email_button=view.findViewById(R.id.email_button);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.email_button:
                Navigation.findNavController(view).navigate(R.id.action_email_RegistrationFragment_to_otpFragment);
                break;
        }
    }
}
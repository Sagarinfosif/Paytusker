package com.example.paytusker.Fragments.RegisterTab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.paytusker.R;

public class NumberFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView privacy_text_number;
    private Button button_number;

    public NumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_number, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        button_number.setOnClickListener(this);
    }

    private void ids() {
        button_number=view.findViewById(R.id.button_number);
        privacy_text_number = view.findViewById(R.id.privacy_text_number);

        Spannable wordtoSpan = new SpannableString(getString(R.string.intro_number_reg));

        wordtoSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.button_color)), 50, 81, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        privacy_text_number.setText(wordtoSpan);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_number:
                Navigation.findNavController(view).navigate(R.id.action_email_RegistrationFragment_to_otpFragment);
                break;
        }
    }
}
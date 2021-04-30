package com.example.paytusker.Fragments;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.paytusker.R;
import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class RegisterationFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView privacy_text;
    private Button number_email_reg;
    private LinearLayout l_registrationlayout;

    public RegisterationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_registeration, container, false);
        ids();
        setup();

        return view;
    }

//    private void animation() {
//        StartSmartAnimation.startAnimation(
//                view.findViewById(R.id.l_registrationlayout),
//                AnimationType.SlideInRight,
//                900,
//                0,
//                true
//        );
//    }

    private void setup() {
        number_email_reg.setOnClickListener(this);
    }

    private void ids() {
        privacy_text=view.findViewById(R.id.privacy_text);
        number_email_reg=view.findViewById(R.id.number_email_reg);
        l_registrationlayout=view.findViewById(R.id.l_registrationlayout);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_registrationlayout.setAnimation(animation);

        Spannable wordtoSpan = new SpannableString(getString(R.string.intro_reg));

        wordtoSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.button_color)),50,81,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        privacy_text.setText(wordtoSpan);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.number_email_reg:
                Navigation.findNavController(view).navigate(R.id.action_registerationFragment_to_email_RegistrationFragment);
                break;
        }
    }
}




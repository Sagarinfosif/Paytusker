package com.example.paytusker.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.paytusker.R;
import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class OtpFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button otp_button;
    private LinearLayout l_otplayout;

    public OtpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_otp, container, false);
        ids();
        setup();
//        animation();
        return  view;
    }

//    private void animation() {
//        StartSmartAnimation.startAnimation(
//                view.findViewById(R.id.l_otplayout),
//                AnimationType.SlideInRight,
//                900,
//                0,
//                true
//        );
//    }

    private void setup() {
        otp_button.setOnClickListener(this);
    }

    private void ids() {
        otp_button=view.findViewById(R.id.otp_button);
        l_otplayout=view.findViewById(R.id.l_otplayout);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_otplayout.setAnimation(animation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.otp_button:
                Navigation.findNavController(view).navigate(R.id.action_otpFragment_to_congoFragment);
                break;
        }
    }
}
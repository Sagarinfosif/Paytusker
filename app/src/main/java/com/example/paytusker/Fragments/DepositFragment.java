package com.example.paytusker.Fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.paytusker.R;
import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class DepositFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private RelativeLayout background_topbar;
    private Button btn_confirm_deposit;
    private ImageView back;
    private LinearLayout l_depositlayout;

    public DepositFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_deposit, container, false);
        ids();
        setup();

        return view;
    }


    private void setup() {
        btn_confirm_deposit.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_depositlayout.setAnimation(animation);


    }

    private void ids() {
        btn_confirm_deposit = view.findViewById(R.id.btn_confirm_deposit);
        l_depositlayout = view.findViewById(R.id.l_depositlayout);
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm_deposit:
                Navigation.findNavController(view).navigate(R.id.action_depositFragment_to_depositWithStripeFragment);
                break;
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Deposit");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }
}
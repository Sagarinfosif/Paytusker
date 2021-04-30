package com.example.paytusker.Fragments;

import android.media.Image;
import android.net.LinkAddress;
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


public class RequestAmountFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back;
    private RelativeLayout background_topbar;
    private LinearLayout l_req_amountlayout;
    private Button btn_confirm_req_money;

    public RequestAmountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_request_amount, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        btn_confirm_req_money.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_req_amountlayout.setAnimation(animation);
    }

    private void ids() {
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
        btn_confirm_req_money=view.findViewById(R.id.btn_confirm_req_money);
        l_req_amountlayout=view.findViewById(R.id.l_req_amountlayout);
    }

    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Request Amount");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_confirm_req_money:
                Navigation.findNavController(view).navigate(R.id.action_requestAmountFragment_to_requestandReviewFragment);
                break;
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
}
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.paytusker.R;

public class RequestMoneyFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back;
    private Button req_money_next;
    private LinearLayout l_request_moneylayout;
    private RelativeLayout background_topbar;

    public RequestMoneyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_request_money, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        req_money_next.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_left);
        l_request_moneylayout.setAnimation(animation);
    }

    private void ids() {
        req_money_next = view.findViewById(R.id.req_money_next);
        l_request_moneylayout = view.findViewById(R.id.l_request_moneylayout);
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
    }

    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Request Money");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.req_money_next:
                Navigation.findNavController(view).navigate(R.id.action_requestMoneyFragment_to_requestAmountFragment);
                break;
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
}
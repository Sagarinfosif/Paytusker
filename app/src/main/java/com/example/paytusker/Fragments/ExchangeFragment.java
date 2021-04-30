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

public class ExchangeFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btn_exchange_next;
    private TextView heading;
    private ImageView back;
    private RelativeLayout background_topbar;
    private LinearLayout l_exchange_amountlayout;

    public ExchangeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_exchange, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        btn_exchange_next.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_exchange_amountlayout.setAnimation(animation);
    }

    private void ids() {
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
        btn_exchange_next=view.findViewById(R.id.btn_exchange_next);
        l_exchange_amountlayout=view.findViewById(R.id.l_exchange_amountlayout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_exchange_next:
                Navigation.findNavController(view).navigate(R.id.action_exchangeFragment_to_reviewAndExhangeFragment);
                break;

            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Exchange");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }
}
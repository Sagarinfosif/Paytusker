package com.example.paytusker.Fragments;

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

public class SendMoneyFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private ImageView back;
    private Button send_money_next;
    private RelativeLayout background_topbar;
    private LinearLayout l_send_moneylayout;


    public SendMoneyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_send_money, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        send_money_next.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_send_moneylayout.setAnimation(animation);
    }

    private void ids() {
        send_money_next=view.findViewById(R.id.send_money_next);
        l_send_moneylayout=view.findViewById(R.id.l_send_moneylayout);
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
    }

    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Send Money");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_money_next:
                Navigation.findNavController(view).navigate(R.id.action_sendMoneyFragment_to_sendAmountFragment);
                break;
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
}
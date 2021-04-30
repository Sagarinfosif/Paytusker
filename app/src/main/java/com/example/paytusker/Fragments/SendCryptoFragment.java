package com.example.paytusker.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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


public class SendCryptoFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button send_crypto_next;
    private RelativeLayout background_topbar;
    private LinearLayout l_send_cryptolayout;
    private TextView heading;
    private ImageView back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_send_crypto, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        send_crypto_next.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_left);
        l_send_cryptolayout.setAnimation(animation);
    }

    private void ids() {
        send_crypto_next = view.findViewById(R.id.send_crypto_next);
        l_send_cryptolayout = view.findViewById(R.id.l_send_cryptolayout);
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_crypto_next:

                break;
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Send DOGETEST");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }
}
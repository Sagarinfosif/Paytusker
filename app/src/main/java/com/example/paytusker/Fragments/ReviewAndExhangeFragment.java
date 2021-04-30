package com.example.paytusker.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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

import com.example.paytusker.HomeActivity;
import com.example.paytusker.R;

public class ReviewAndExhangeFragment extends Fragment implements View.OnClickListener {

    private View view;
    private RelativeLayout background_topbar;
    private TextView heading;
    private ImageView back;
    private Button exchange_money_button,alert_btn_exchange_done;
    private LinearLayout l_review_exchange_layout;

    public ReviewAndExhangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_review_and_exhange, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        exchange_money_button.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_review_exchange_layout.setAnimation(animation);
    }


    private void ids() {
        exchange_money_button = view.findViewById(R.id.exchange_money_button);
        l_review_exchange_layout = view.findViewById(R.id.l_review_exchange_layout);
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.exchange_money_button:
                final AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.exhange_alert, null);
                dialogBuilder1.setView(dialogView);
                alert_btn_exchange_done = dialogView.findViewById(R.id.alert_btn_exchange_done);
                final AlertDialog alertDialog1 = dialogBuilder1.create();
                alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog1.show();
                alert_btn_exchange_done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                        startActivity(intent);
                        alertDialog1.dismiss();
                    }
                });
                break;
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Review & Payout");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }
}
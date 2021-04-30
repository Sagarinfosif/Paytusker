package com.example.paytusker.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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

import com.example.paytusker.HomeActivity;
import com.example.paytusker.R;

public class DepositConfirmFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private RelativeLayout background_topbar;
    private ImageView back;
    private Button depost_money_button, aler_btn_deposit_done;
    private LinearLayout l_deposit_confirmlayout;

    public DepositConfirmFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_deposit_confirm, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        depost_money_button.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_deposit_confirmlayout.setAnimation(animation);
    }

    private void ids() {
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
        depost_money_button = view.findViewById(R.id.depost_money_button);
        l_deposit_confirmlayout = view.findViewById(R.id.l_deposit_confirmlayout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.depost_money_button:
                final AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.success_alert, null);
                dialogBuilder1.setView(dialogView);
                aler_btn_deposit_done = dialogView.findViewById(R.id.aler_btn_deposit_done);
                final AlertDialog alertDialog1 = dialogBuilder1.create();
                alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog1.show();
                aler_btn_deposit_done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                        startActivity(intent);
//                        Navigation.findNavController(view).navigate(R.id.action_depositConfirmFragment3_to_homeFragment);
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
        heading.setText("Deposit");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }
}
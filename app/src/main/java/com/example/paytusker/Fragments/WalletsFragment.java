package com.example.paytusker.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.paytusker.R;
import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class WalletsFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView heading;
    private RelativeLayout background_topbar;
    private ImageView back;
    private LinearLayout l_walletlayout;

    public WalletsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_wallets, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
back.setOnClickListener(this);
    }

    private void ids() {
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
        l_walletlayout=view.findViewById(R.id.l_walletlayout);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_walletlayout.setAnimation(animation);
    }

    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Wallets");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
}
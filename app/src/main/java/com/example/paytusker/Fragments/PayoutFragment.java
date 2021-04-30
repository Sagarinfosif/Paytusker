package com.example.paytusker.Fragments;

import android.media.Image;
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

public class PayoutFragment extends Fragment implements View.OnClickListener {

  private View view;
    private TextView heading;
    private RelativeLayout background_topbar;
    private ImageView back;
    private Button btn_confirm_payout;
    private LinearLayout l_payoutlayout;

    public PayoutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_payout, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        btn_confirm_payout.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_payoutlayout.setAnimation(animation);

    }

    private void ids() {
        btn_confirm_payout = view.findViewById(R.id.btn_confirm_payout);
        l_payoutlayout = view.findViewById(R.id.l_payoutlayout);
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_confirm_payout:
                Navigation.findNavController(view).navigate(R.id.action_payoutFragment_to_reviewAndPayoutFragment);
                break;
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Payout");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }
}
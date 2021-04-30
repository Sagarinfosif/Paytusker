package com.example.paytusker.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.paytusker.Adapter.TransactionAdapter;
import com.example.paytusker.R;
import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class MyActivityFragment extends Fragment implements View.OnClickListener {

    private TextView heading;
    private View view;
    private ImageView back;
    private RecyclerView rv_transactions;
    private RelativeLayout background_topbar;
    private LinearLayout l_activitylayout;
    private TransactionAdapter transactionAdapter;

    public MyActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_activity, container, false);
        ids();
        setup();
        return view;
    }


    private void setup() {

        back.setOnClickListener(this);

        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_activitylayout.setAnimation(animation);
        transactionAdapter = new TransactionAdapter(getActivity());
        rv_transactions.setAdapter(transactionAdapter);
    }

    private void ids() {
        rv_transactions = view.findViewById(R.id.rv_transactions);
        l_activitylayout = view.findViewById(R.id.l_activitylayout);
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
    }

    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Transactions");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                getActivity().onBackPressed();
                break;
        }
    }
}
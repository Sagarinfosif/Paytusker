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
import android.widget.LinearLayout;

import com.example.paytusker.R;
import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class CongoFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button done;
    private LinearLayout l_congolayout;

    public CongoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_congo, container, false);
        ids();
        setup();

        return view;
    }

    private void setup() {
        done.setOnClickListener(this);
    }

    private void ids() {
        done=view.findViewById(R.id.done);
        l_congolayout=view.findViewById(R.id.l_congolayout);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_congolayout.setAnimation(animation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.done:
                Navigation.findNavController(view).navigate(R.id.action_congoFragment_to_loginFragment);
                break;
        }
    }
}
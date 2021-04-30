package com.example.paytusker.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.paytusker.HomeActivity;
import com.example.paytusker.R;
import com.example.paytusker.Utils.App;
import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button login;
    private TextView register;
    private RelativeLayout layout;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_login, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    private void ids() {
        register=view.findViewById(R.id.register);
        login=view.findViewById(R.id.login);
        layout=view.findViewById(R.id.l_loginlayout);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        layout.setAnimation(animation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerationFragment);
                break;
            case R.id.login:
                Intent intent=new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
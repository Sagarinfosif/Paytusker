package com.example.paytusker.Fragments.RegisterTab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.paytusker.Adapter.EmailAdapter;
import com.example.paytusker.R;
import com.google.android.material.tabs.TabLayout;
import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

public class Email_RegistrationFragment extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private EmailAdapter emailAdapter;
    private LinearLayout l_registerlayout;

       public Email_RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_email__registration, container, false);
        findIds();
        setup();

        return view;
    }


    private void findIds() {
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        l_registerlayout=view.findViewById(R.id.l_registerlayout);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_registerlayout.setAnimation(animation);
    }

    private void setup() {
        emailAdapter = new EmailAdapter(getChildFragmentManager());
        viewPager.setAdapter(emailAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
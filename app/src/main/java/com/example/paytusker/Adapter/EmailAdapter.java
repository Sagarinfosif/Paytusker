package com.example.paytusker.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.paytusker.Fragments.RegisterTab.EmailFragment;
import com.example.paytusker.Fragments.RegisterTab.NumberFragment;

public class EmailAdapter extends FragmentPagerAdapter {

    public EmailAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public EmailAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                NumberFragment numberFragment = new NumberFragment();
                return numberFragment;
            case 1:
                EmailFragment emailFragment = new EmailFragment();
                return emailFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {

            case 0:
                return "Number";
            case 1:
                return "Email";

            default:
                return null;
        }

    }
}


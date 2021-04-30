package com.example.paytusker.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paytusker.Adapter.HomeServiceAdapter;
import com.example.paytusker.HomeActivity;
import com.example.paytusker.ModelClass.ServiceData;
import com.example.paytusker.R;
import com.example.paytusker.Utils.App;
import com.google.android.material.card.MaterialCardView;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;
import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView img_side_menu, img_close;
    private RecyclerView dashboard_service_recycleview;
    private TextView heading;
    private ImageView back;
    private LinearLayout llayout;
    private MaterialCardView wallets, my_activity;
    private HomeServiceAdapter homeServiceAdapter;
    private List<ServiceData> list = new ArrayList<>();
    private AdvanceDrawerLayout advance_drawer;
    private RelativeLayout background_topbar;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);
            listItem();
            ids();
            setup();
            recyclerList();
        }

        return view;
    }


    private void listItem() {
        list.add(new ServiceData("Deposit", R.drawable.money_icon_));
        list.add(new ServiceData("Payout", R.drawable.hand));
        list.add(new ServiceData("Send Money", R.drawable.send_money_));
        list.add(new ServiceData("Request Money", R.drawable.request_money_));
        list.add(new ServiceData("Exchange", R.drawable.currency_exchange_));
        list.add(new ServiceData("Crypto", R.drawable.crypto));


    }

    private void recyclerList() {
        homeServiceAdapter = new HomeServiceAdapter(getActivity(), list, new HomeServiceAdapter.Select() {
            @Override
            public void onClick(int position) {
                if (position == 0) {
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_depositFragment);
                } else if (position == 1) {
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_payoutFragment);
                } else if (position == 2) {
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_sendMoneyFragment);
                } else if (position == 3) {
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_requestMoneyFragment);
                } else if (position == 4) {
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_exchangeFragment);
                } else if (position == 5) {
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_cryptoFragment);
                }
            }
        });
        dashboard_service_recycleview.setAdapter(homeServiceAdapter);
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Please wait...");
        builder.setMessage("Coming soon...");

        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    }


    private void setup() {
        wallets.setOnClickListener(this);
        back.setOnClickListener(this);
        my_activity.setOnClickListener(this);

    }

    private void ids() {
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        my_activity = view.findViewById(R.id.my_activity);
        llayout = view.findViewById(R.id.llayout);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
        wallets = view.findViewById(R.id.wallets);
        dashboard_service_recycleview = view.findViewById(R.id.dashboard_service_recycleview);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wallets:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_walletsFragment);
                break;
            case R.id.my_activity:
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_myActivityFragment);
                break;
            case R.id.back:
                getActivity().finishAffinity();
                break;

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ids();
        back.setOnClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        llayout.setAnimation(animation);
        heading.setText("DashBoard");
        background_topbar.setBackgroundResource(R.drawable.dashboard_topbar_color);
        if (App.getSingleton().getCheckScreen() != 0) {
            switch (App.getSingleton().getCheckScreen()) {
                case 1:
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileFragment);
                    break;
                case 3:
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_myActivityFragment);
                    break;
                case 4:
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_walletsFragment);
                    break;
                case 5:
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_depositFragment);
                    break;
                case 6:
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_payoutFragment);
                    break;
                case 7:
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_sendMoneyFragment);
                    break;
                case 8:
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_requestMoneyFragment);
                    break;
                case 9:
                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_exchangeFragment
                    );
                    break;
            }
        }
        App.getSingleton().setCheckScreen(0);
    }
}
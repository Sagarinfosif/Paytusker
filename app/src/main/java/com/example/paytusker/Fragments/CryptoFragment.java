package com.example.paytusker.Fragments;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
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
import android.widget.Toast;

import com.example.paytusker.Adapter.CryptoWalletAdapter;
import com.example.paytusker.R;

public class CryptoFragment extends Fragment implements View.OnClickListener {

    private View view;
    private CryptoWalletAdapter cryptoWalletAdapter;
    private LinearLayout l_crypto_layout;
    private TextView heading;
    private ImageView back;
    private RelativeLayout background_topbar;
    private RecyclerView rv_crypto_wallet;

    public CryptoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_crypto, container, false);
        ids();
        setup();
        return view;
    }

    private void setup() {
        back.setOnClickListener(this);
        cryptoWalletAdapter = new CryptoWalletAdapter(getActivity(), new CryptoWalletAdapter.Select() {
            @Override
            public void onclick(int position) {
                Navigation.findNavController(view).navigate(R.id.action_cryptoFragment_to_cryptoReceivedFragment);
            }

            @Override
            public void onsendclick(int position) {
                Navigation.findNavController(view).navigate(R.id.action_cryptoFragment_to_sendCryptoFragment);
            }
        });
        rv_crypto_wallet.setAdapter(cryptoWalletAdapter);
    }

    private void ids() {
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
        rv_crypto_wallet = view.findViewById(R.id.rv_crypto_wallet);
        l_crypto_layout = view.findViewById(R.id.l_crypto_layout);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_crypto_layout.setAnimation(animation);
    }
    @Override
    public void onResume() {
        super.onResume();
        heading.setText("Crypto Wallet");
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
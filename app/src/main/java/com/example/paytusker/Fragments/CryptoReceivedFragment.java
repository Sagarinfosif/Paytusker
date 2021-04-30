package com.example.paytusker.Fragments;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.LinkAddress;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paytusker.HomeActivity;
import com.example.paytusker.R;
import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

import static android.content.Context.CLIPBOARD_SERVICE;
import static android.content.Context.WINDOW_SERVICE;

public class CryptoReceivedFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView imageView_qrcode;
    private Bitmap bitmap;
    private ImageView back;
    private RelativeLayout background_topbar;
    private LinearLayout l_receive_crypto_layout;
    private Button copy_text,alert_copy_done;
    private TextView receive_address,heading;

    public CryptoReceivedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_crypto_received, container, false);
        ids();
        setup();
        clicking();
        return view;
    }

    private void clicking() {
        copy_text.setOnClickListener(this);
        back.setOnClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(getActivity(),R.anim.animation_left);
        l_receive_crypto_layout.setAnimation(animation);
    }

    private void setup() {
        WindowManager manager = (WindowManager) getActivity().getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;


        QRGEncoder qrgEncoder = new QRGEncoder("PayTusker", null,
                QRGContents.Type.TEXT,
                smallerDimension);

        try {
            bitmap = qrgEncoder.encodeAsBitmap();
            imageView_qrcode.setImageBitmap(bitmap);

        } catch (WriterException e) {
            Toast.makeText(getActivity(), "" + e, Toast.LENGTH_SHORT).show();
        }
    }

    private void ids() {
        imageView_qrcode = view.findViewById(R.id.imageView_qrcode);
        receive_address = view.findViewById(R.id.receive_address);
        copy_text = view.findViewById(R.id.copy_text);
        heading = getActivity().findViewById(R.id.heading);
        back = getActivity().findViewById(R.id.back);
        background_topbar = getActivity().findViewById(R.id.background_topbar);
        l_receive_crypto_layout = view.findViewById(R.id.l_receive_crypto_layout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.copy_text:
                ClipboardManager _clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                CharSequence copyText = receive_address.getText().toString();
                _clipboard.setText(copyText);
                final AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.copy_alert, null);
                dialogBuilder1.setView(dialogView);
                alert_copy_done = dialogView.findViewById(R.id.alert_copy_done);
                final AlertDialog alertDialog1 = dialogBuilder1.create();
                alertDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog1.show();
                alert_copy_done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
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
        heading.setText("Crypto Received");
        background_topbar.setBackground(getActivity().getResources().getDrawable(R.color.button_color));
    }
}

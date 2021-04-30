package com.example.paytusker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paytusker.R;

public class CryptoWalletAdapter extends RecyclerView.Adapter<CryptoWalletAdapter.ViewHolder> {

    Context context;
    Select select;

    public interface Select{
        void onclick(int position);
        void onsendclick(int position);
    }

    public CryptoWalletAdapter(Context context, Select select) {
        this.context = context;
        this.select = select;
    }

    @NonNull
    @Override
    public CryptoWalletAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.crypto_wallet_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoWalletAdapter.ViewHolder holder, int position) {
    holder.receive_btn_crypto.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            select.onclick(position);
        }
    });
    holder.send_btn_crypto.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            select.onsendclick(position);
        }
    });
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button receive_btn_crypto,send_btn_crypto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            send_btn_crypto=itemView.findViewById(R.id.send_btn_crypto);
            receive_btn_crypto=itemView.findViewById(R.id.receive_btn_crypto);
        }
    }
}

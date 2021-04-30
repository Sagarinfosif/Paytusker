package com.example.paytusker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paytusker.ModelClass.ServiceData;
import com.example.paytusker.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeServiceAdapter extends RecyclerView.Adapter<HomeServiceAdapter.ViewHolder> {
    Context context;
    private List<ServiceData> list=new ArrayList<>();
    private Select select;

    public HomeServiceAdapter(Context context, List<ServiceData> list, Select select) {
        this.context = context;
        this.list = list;
        this.select = select;
    }

    public interface Select{
        void onClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.dashboard_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       holder.image_service.setImageResource(list.get(position).getImage());
       holder.title_service.setText(list.get(position).getTitle());

       holder.service_recycle_item.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               select.onClick(position);
           }
       });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialCardView service_recycle_item;
        private CircleImageView image_service;
        private TextView title_service;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            service_recycle_item=itemView.findViewById(R.id.service_recycle_item);
            image_service=itemView.findViewById(R.id.image_service);
            title_service=itemView.findViewById(R.id.title_service);
        }
    }
}

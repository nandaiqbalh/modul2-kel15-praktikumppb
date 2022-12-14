package com.nandaiqbalh.modul2kel15.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nandaiqbalh.modul2kel15.R;
import com.nandaiqbalh.modul2kel15.data.DataItem;
import com.nandaiqbalh.modul2kel15.ui.DetailActivity;

import java.util.List;

public class RecyclerAdapter extends
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<DataItem> dataUser;
    private Context mContext;

    public RecyclerAdapter(List<DataItem> dataUser, Context mContext) {
        this.dataUser = dataUser;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_list_user, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") int i) {
        viewHolder.tvFirstName.setText(dataUser.get(i).getFirstName());
        viewHolder.tvLastName.setText(dataUser.get(i).getLastName());
        viewHolder.tvEmail.setText(String.format("Email : %s", dataUser.get(i).getEmail()));

        Glide.with(mContext).load(dataUser.get(i).getAvatar()).into(viewHolder.imgPhotoUser);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);

                // creating a bundle object
                Bundle bundleUser = new Bundle();

                // storing the string value in the bundle
                // which is mapped to key
                bundleUser.putString("avatar", dataUser.get(i).getAvatar());
                bundleUser.putString("first_name", dataUser.get(i).getFirstName());
                bundleUser.putString("last_name", dataUser.get(i).getLastName());
                bundleUser.putString("email", dataUser.get(i).getEmail());

                // passing the bundle into the intent
                intent.putExtras(bundleUser);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPhotoUser;
        private TextView tvFirstName, tvLastName, tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhotoUser = itemView.findViewById(R.id.img_photo_user);
            tvFirstName = itemView.findViewById(R.id.tv_item_first_name);
            tvLastName = itemView.findViewById(R.id.tv_item_last_name);
            tvEmail = itemView.findViewById(R.id.tv_item_email);
        }
    }
}
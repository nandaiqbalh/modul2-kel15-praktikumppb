package com.nandaiqbalh.modul2kel15.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nandaiqbalh.modul2kel15.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivUserDetail;
    private TextView tvNameDetail, tvEmailDetail;

    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // call init function
        initView();

        // display user
        displayUser();
    }

    private void initView(){
        ivUserDetail =(ImageView) findViewById(R.id.iv_user_detail);
        tvNameDetail = (TextView) findViewById(R.id.tv_name_detail);
        tvEmailDetail = (TextView) findViewById(R.id.tv_email_detail);
    }

    private void getUserData(){
        bundle = getIntent().getExtras();

    }

    private void displayUser(){
        getUserData();

        // user avatar
        Glide.with(this).load(bundle.getString("avatar")).into(ivUserDetail);

        // user string value
        String firstName = bundle.getString("first_name");
        String lastName = bundle.getString("last_name");

        String fullName = firstName + " " + lastName;
        tvNameDetail.setText(fullName);

        tvEmailDetail.setText(bundle.getString("email"));
    }
}

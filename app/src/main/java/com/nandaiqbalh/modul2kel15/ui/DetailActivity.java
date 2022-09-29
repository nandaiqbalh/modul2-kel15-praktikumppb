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

    private String firstName, lastName, fullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // call init function
        initView();

        // display user
        displayUser();

        // set toolbar
        setMyToolbar();

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
        firstName = bundle.getString("first_name");
        lastName = bundle.getString("last_name");

        fullName = firstName + " " + lastName;
        tvNameDetail.setText(fullName);

        tvEmailDetail.setText(bundle.getString("email"));
    }

    private void setMyToolbar(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(fullName);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }


}

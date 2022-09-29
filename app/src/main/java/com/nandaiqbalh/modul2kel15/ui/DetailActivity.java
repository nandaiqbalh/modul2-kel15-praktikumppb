package com.nandaiqbalh.modul2kel15.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.nandaiqbalh.modul2kel15.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvNama = findViewById(R.id.tv_first_name);
        if (getIntent().hasExtra("name")) {
            String nama = getIntent().getStringExtra("name");
            tvNama.setText(nama);
        }
    }
}

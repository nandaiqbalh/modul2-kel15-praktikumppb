package com.nandaiqbalh.modul2kel15.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.nandaiqbalh.modul2kel15.R;
import com.nandaiqbalh.modul2kel15.helper.AnggotaAdapter;

public class AboutActivity extends AppCompatActivity {

    private ListView anggotaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // init
        initView();

        // toolbar
        setMyToolbar();

        // show list item
        displayListAnggota();
    }

    private void initView() {

        anggotaListView = findViewById(R.id.lv_anggota);
    }

    private void displayListAnggota() {
        String namaList[] = {"Nanda Iqbal Hanafi", "Alya Zahra Fatikha", "Anggi Nikmatun Zahra", "Novita Auliya"};
        String nimList[] = {"21120120130109", "21120120140056", "21120120120008", "21120120140114"};

        AnggotaAdapter customAdapter = new AnggotaAdapter(getApplicationContext(), namaList, nimList);
        anggotaListView.setAdapter(customAdapter);
    }

    private void setMyToolbar(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Tentang Kelompok 15");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}
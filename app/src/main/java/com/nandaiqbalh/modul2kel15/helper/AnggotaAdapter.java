package com.nandaiqbalh.modul2kel15.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nandaiqbalh.modul2kel15.R;

public class AnggotaAdapter extends ArrayAdapter {
    private String[] namaAnggota;
    private String[] nimAnggota;
    private Context context;

    public AnggotaAdapter(@NonNull Context context, String[] namaAnggota, String[] nimAnggota) {
        super(context, R.layout.row_item_anggota, namaAnggota);
        this.namaAnggota = namaAnggota;
        this.nimAnggota = nimAnggota;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.row_item_anggota, null, true);
        TextView nama = view.findViewById(R.id.tv_item_nama);
        TextView nim = view.findViewById(R.id.tv_item_nim);

        nama.setText(namaAnggota[position]);
        nim.setText(nimAnggota[position]);
        return view;
    }
}

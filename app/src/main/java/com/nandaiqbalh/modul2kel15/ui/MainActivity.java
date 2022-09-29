package com.nandaiqbalh.modul2kel15.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nandaiqbalh.modul2kel15.R;
import com.nandaiqbalh.modul2kel15.data.DataItem;
import com.nandaiqbalh.modul2kel15.helper.RecyclerAdapter;
import com.nandaiqbalh.modul2kel15.http.api.ApiClient;
import com.nandaiqbalh.modul2kel15.http.user.ListUserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListUser;
    private List<DataItem> listItem;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvListUser = findViewById(R.id.rv_list_user);
        ApiClient.getService().getList().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {

                if (response.isSuccessful()) {
                    listItem = response.body().getData();
                    adapter = new RecyclerAdapter(listItem, MainActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), (CharSequence) t, Toast.LENGTH_LONG).show();
            }
        });
    }
}

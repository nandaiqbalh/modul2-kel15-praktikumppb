package com.nandaiqbalh.modul2kel15.http.api;

import com.nandaiqbalh.modul2kel15.http.user.ListUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/users?page=2")
    Call<ListUserResponse> getList();
}
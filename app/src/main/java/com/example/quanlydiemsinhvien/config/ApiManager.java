package com.example.quanlydiemsinhvien.config;


import com.example.quanlydiemsinhvien.model.StudentDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiManager {
    @POST("api/student/do-search")
    Call<ArrayList<StudentDTO>> doSearch(@Body StudentDTO obj);

    @POST("api/student/save")
    Call<String> save(@Body StudentDTO obj);
}

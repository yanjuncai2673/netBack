package com.example.netback.model.api;


import com.example.netback.model.bean.maintitle.MainTitleBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

//Api接口类
public interface ShopApi {


    //专题界面数据
    @GET("topic/list")
    Flowable<MainTitleBean> getMainTitleData(@Query("page") int page, @Query("size") int size);


}
package com.example.sampleapp.network

import com.example.sampleapp.home.data.AddPostModel
import com.example.sampleapp.home.data.AddProductResponse
import com.example.sampleapp.home.data.PostModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET("api/public/get")
    fun fetchAllProducts(): Call<List<PostModel>>

    @POST("api/public/add")
    fun addProduct(@Body postModel: AddPostModel): Response<AddProductResponse>


}
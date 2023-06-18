package com.example.sampleapp.home.data

import com.google.gson.annotations.SerializedName

data class AddPostModel(

    @field:SerializedName("product_name")
    var name: String,

    @field:SerializedName("product_type")
    var type: String,

    @field:SerializedName("price")
    var price: String?,

    @field:SerializedName("tax")
    var tax: String?,
)
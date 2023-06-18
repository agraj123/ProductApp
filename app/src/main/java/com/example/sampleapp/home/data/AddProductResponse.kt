package com.example.sampleapp.home.data

import com.google.gson.annotations.SerializedName

data class AddProductResponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("product_details")
    val productDetail: ProductDetail? = null,

    @field:SerializedName("product_id")
    val productId: Int? = null,

    @field:SerializedName("success")
    val success: Boolean?
)

data class ProductDetail(

    @field:SerializedName("product_name")
    val name: String? = null,

    @field:SerializedName("product_type")
    val type: Int? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("tax")
    val tax: Int? = null,

)

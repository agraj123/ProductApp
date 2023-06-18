package com.example.sampleapp.home.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sampleapp.network.ApiClient
import com.example.sampleapp.network.ApiInterface
import com.example.sampleapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

    private var apiInterface: ApiInterface? = null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun fetchAllProducts(): LiveData<List<PostModel>> {
        val data = MutableLiveData<List<PostModel>>()

        apiInterface?.fetchAllProducts()?.enqueue(object : Callback<List<PostModel>> {

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 && res != null) {
                    data.value = res
                } else {
                    data.value = null
                }

            }
        })

        return data

    }

     suspend fun addProduct(addPostModel: AddPostModel): Flow<Resource<AddProductResponse>> {
         return flow {
             val addPostResponse = apiInterface!!.addProduct(addPostModel)
             if (addPostResponse.isSuccessful) {
                 emit(Resource.Success(addPostResponse.body()!!))
             } else {
                 emit(Resource.Error(addPostResponse.message()))
             }
         }.flowOn(Dispatchers.IO)
     }

}
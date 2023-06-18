package com.example.sampleapp.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sampleapp.home.data.AddPostModel
import com.example.sampleapp.home.data.AddProductResponse
import com.example.sampleapp.home.data.HomeRepository
import com.example.sampleapp.home.data.PostModel
import com.example.sampleapp.utils.Event
import com.example.sampleapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private var homeRepository: HomeRepository? = null
    var postModelListLiveData: LiveData<List<PostModel>>? = null
    var createPostLiveData= MutableLiveData<Event<Resource<AddProductResponse>>>()
    var deletePostLiveData: LiveData<Boolean>? = null

    val addData: LiveData<Event<Resource<AddProductResponse>>>
        get() = createPostLiveData

    init {
        homeRepository = HomeRepository()
        postModelListLiveData = MutableLiveData()
        deletePostLiveData = MutableLiveData()
    }

    fun fetchAllProducts() {
        postModelListLiveData = homeRepository?.fetchAllProducts()
    }

    fun addProduct(addPostModel: AddPostModel) {
        viewModelScope.launch {
            createPostLiveData.value = Event(Resource.Loading())
            homeRepository!!.addProduct(addPostModel).catch { exception ->
                createPostLiveData.value = Event(Resource.Error(exception.localizedMessage!!))
            }.collect { item ->
                createPostLiveData.value = Event(item)
            }
        }
    }

}
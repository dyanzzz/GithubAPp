package com.kotlin.githubapps.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.githubapps.api.RetrofitClient
import com.kotlin.githubapps.data.model.DetailUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel: ViewModel() {
    val user = MutableLiveData<DetailUserResponse>()

    fun setUserDetail(username: String) {
        RetrofitClient.apiInstance
            .getUserDetail(username)
            .enqueue(object : Callback<DetailUserResponse>{
                override fun onResponse(
                    call: Call<DetailUserResponse>,
                    response: Response<DetailUserResponse>
                ) {
                    if (response.isSuccessful) {
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailUserResponse>, t: Throwable) {
                    println("##### ${t.message}")
                }

            })
    }

    fun getUserDetail(): LiveData<DetailUserResponse> = user

}
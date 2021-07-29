package com.kotlin.githubapps.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.githubapps.api.RetrofitClient
import com.kotlin.githubapps.data.model.User
import com.kotlin.githubapps.data.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    // ini merupakan mutable live data yg merupakan arraylist dari data user
    val listUser = MutableLiveData<ArrayList<User>>()

    // function setter
    fun setSearchUsers(query: String) {
        println(query)
        RetrofitClient.apiInstance
            .getSearchUser(query)
            .enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        listUser.postValue(response.body()?.items)
                    }
                    println("Response $response")
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    t.message?.let {
                        Log.d("Failure", it)
                        println("Failure it $it")
                    }

                }

            })
    }

    // function getter
    fun getSearchUser(): LiveData<ArrayList<User>>{
        return listUser
    }
}
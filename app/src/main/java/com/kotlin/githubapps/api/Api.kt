package com.kotlin.githubapps.api

import com.kotlin.githubapps.BuildConfig
import com.kotlin.githubapps.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token "+BuildConfig.API_KEY)
    fun getSearchUser(@Query("q") query: String): Call<UserResponse>
}
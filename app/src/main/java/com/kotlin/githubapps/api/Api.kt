package com.kotlin.githubapps.api

import com.kotlin.githubapps.BuildConfig
import com.kotlin.githubapps.data.model.DetailUserResponse
import com.kotlin.githubapps.data.model.User
import com.kotlin.githubapps.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: ${BuildConfig.API_KEY}")
    fun getSearchUser(
        @Query("q")
        query: String
    ): Call<UserResponse>

    @GET("user/{username}")
    @Headers("Authorization: ${BuildConfig.API_KEY}")
    fun getUserDetail(
        @Path("username")
        username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: ${BuildConfig.API_KEY}")
    fun getFollowers(
        @Path("username")
        username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: ${BuildConfig.API_KEY}")
    fun getFollowing(
        @Path("username")
        username: String
    ): Call<ArrayList<User>>
}
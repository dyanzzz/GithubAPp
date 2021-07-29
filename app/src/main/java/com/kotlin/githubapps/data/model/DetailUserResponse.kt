package com.kotlin.githubapps.data.model

// tips:
// membuat data class response itu menyesuaikan dengan object response dari API
// https://api.github.com/users/dyanzzz
data class DetailUserResponse(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val followers_url: String,
    val following_url: String,
    val name: String,
    val following: Int,
    val followers: Int

)

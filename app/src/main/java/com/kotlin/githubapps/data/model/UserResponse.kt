package com.kotlin.githubapps.data.model

data class UserResponse(
    // jika ingin membuat nama variable yg berbeda dengan field
    //@SerializedName("items")
    // nama variable berikut harus sama dengan nama field object response dari API == items
    val items : ArrayList<User>
)

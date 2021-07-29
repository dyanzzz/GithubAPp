package com.kotlin.githubapps.data.model

// tips:
// membuat data class response itu menyesuaikan dengan object response dari API
// https://api.github.com/search/users?q=dyanzzz
data class UserResponse(
    // jika ingin membuat nama variable yg berbeda dengan field. gunakan anotasi @SerializedName("items)
    // @SerializedName("items")
    // nama variable berikut harus sama dengan nama field object response dari API == items
    // ambil object dari items
    val items : ArrayList<User>
)

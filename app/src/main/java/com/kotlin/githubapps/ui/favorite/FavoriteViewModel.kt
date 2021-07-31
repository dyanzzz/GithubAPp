package com.kotlin.githubapps.ui.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.githubapps.data.local.FavoriteUser
import com.kotlin.githubapps.data.local.FavoriteUserDao
import com.kotlin.githubapps.data.local.UserDatabase
import com.kotlin.githubapps.data.model.DetailUserResponse

class FavoriteViewModel(application: Application): AndroidViewModel(application) {
    val user = MutableLiveData<DetailUserResponse>()

    // declare Dao
    private var userDao: FavoriteUserDao?
    private var userDb: UserDatabase? = UserDatabase.getDatabase(application)

    init {
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavoriteUser>>? {
        return userDao?.getFavoriteUser()
    }
}
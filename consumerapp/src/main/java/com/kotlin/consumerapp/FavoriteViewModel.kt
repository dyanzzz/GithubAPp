package com.kotlin.consumerapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FavoriteViewModel(application: Application): AndroidViewModel(application) {
    private var list = MutableLiveData<ArrayList<User>>()

    fun setFavoriteUser(context: Context) {
        val cursor = context.contentResolver.query(
            DatabaseContract.FavoriteUserColumns.CONTENT_URI,
            null,
            null,
            null,
            null
        )

        val listConverted = cursor?.let { MappingHelper.mapCursorToArrayList(it) }

        list.postValue(listConverted)
    }

    fun getFavoriteUser(): LiveData<ArrayList<User>>? {
        return list
    }
}
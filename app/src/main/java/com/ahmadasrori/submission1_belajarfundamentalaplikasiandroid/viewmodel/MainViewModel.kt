package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.data.Repository
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.User
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.detail.UserDetail
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.search.Search
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(val repository: Repository) : ViewModel() {

    val search = MutableLiveData<List<Search>>()
    val userDetail = MutableLiveData<UserDetail>()
    val follower = MutableLiveData<List<User>>()
    val following = MutableLiveData<List<User>>()

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun search(username: String?) {
        compositeDisposable.add(
            repository.searchUser(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    val response = it
                    val data = response.list
                    search.postValue(data)
                }
        )
    }

    fun getUserDetail(username: String?) {
        compositeDisposable.add(
            repository.getDetailUser(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    val response = it
                    userDetail.postValue(response)
                }
        )
    }

    fun getFollower(username: String?) {
        compositeDisposable.add(
            repository.getFollower(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val response = it
                    val data = response
                    follower.postValue(data)
                }, {
                    Log.e("ERROR", it.localizedMessage)
                })
        )
    }

    fun getFollowing(username: String?) {
        compositeDisposable.add(
            repository.getFollowing(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    val response = it
                    val data = response
                    following.postValue(data)
                }, {
                    Log.e("ERROR", it.localizedMessage)

                })
        )
    }

}
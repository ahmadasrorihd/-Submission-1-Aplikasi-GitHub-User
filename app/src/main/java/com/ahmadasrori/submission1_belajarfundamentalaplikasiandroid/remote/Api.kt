package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.remote

import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.User
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.detail.UserDetail
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.search.SearchResponse
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.util.Constant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: "+Constant.TOKEN)
    fun searchUser(
        @Query("q") username: String?
    ): Observable<SearchResponse>

    @GET("users/{username}")
    @Headers("Authorization: "+Constant.TOKEN)
    fun getDetailUser(
        @Path("username") username: String?
    ): Observable<UserDetail>

    @GET("users/{username}/following")
    @Headers("Authorization: "+Constant.TOKEN)
    fun getFollowing(
        @Path("username") username: String?
    ): Observable<List<User>>

    @GET("users/{username}/followers")
    @Headers("Authorization: "+Constant.TOKEN)
    fun getFollower(
        @Path("username") username: String?
    ): Observable<List<User>>

}

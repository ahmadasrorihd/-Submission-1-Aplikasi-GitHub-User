package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.di

import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.data.Repository
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.remote.Api
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.remote.RetrofitClient
import org.koin.dsl.module

val dataModule = module {
    single {
        RetrofitClient.instance
    }
    factory {
        Repository(get<Api>())
    }
}
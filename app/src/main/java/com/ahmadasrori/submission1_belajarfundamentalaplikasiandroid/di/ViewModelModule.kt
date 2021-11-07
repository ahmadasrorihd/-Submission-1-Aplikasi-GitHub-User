package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.di

import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.data.Repository
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get<Repository>())
    }
}
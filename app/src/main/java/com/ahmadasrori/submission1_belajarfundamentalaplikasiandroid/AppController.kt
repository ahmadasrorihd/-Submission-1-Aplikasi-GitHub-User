package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid

import android.app.Application
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.di.dataModule
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppController : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppController)
            modules(dataModule)
            modules(viewModelModule)
        }
    }


}
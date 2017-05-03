package com.hucet.fcmapp

import android.app.Application
import com.hucet.fcmapp.di.*

class MyApplication : Application() {

    companion object {
        lateinit var googleTokenComponent: GoogleTokenComponent
    }

    override fun onCreate() {
        super.onCreate()
        googleTokenComponent = DaggerGoogleTokenComponent
                .builder()
                .googleTokenModule(GoogleTokenModule())
                .build()
    }
}
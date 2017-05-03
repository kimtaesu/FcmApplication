package com.hucet.fcmapp

import android.app.Application
import com.hucet.fcmapp.di.app.AppComponent
import com.hucet.fcmapp.di.app.AppModule
import com.hucet.fcmapp.di.app.DaggerAppComponent

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initComponents()
    }

    fun initComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}
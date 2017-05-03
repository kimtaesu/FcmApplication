package com.hucet.fcmapp

import android.app.Application
import android.content.Intent
import com.google.firebase.iid.FirebaseInstanceId
import com.hucet.fcmapp.di.app.AppComponent
import com.hucet.fcmapp.di.app.AppModule
import com.hucet.fcmapp.di.app.DaggerAppComponent
import com.hucet.fcmapp.di.google.GoogleComponent
import com.hucet.fcmapp.di.google.GoogleModule
import com.hucet.fcmapp.di.view.MainActivityComponent
import com.hucet.fcmapp.di.view.MainActivityModule

class MyApplication : Application() {

    companion object {
        private lateinit var appComponent: AppComponent
        fun injectGoogleModule(a: MyFirebaseInstanceIDService) {
            appComponent.plus(GoogleModule()).inject(a)
        }


        fun injectMainActivityComponent(a: MainActivity) {
            appComponent.plus(MainActivityModule(a)).inject(a)
        }
    }

    override fun onCreate() {
        super.onCreate()
        initComponents()
        sendBroadcastForGoogleToken()
    }

    fun sendBroadcastForGoogleToken() {
        val token = FirebaseInstanceId.getInstance().token
        if (token == null) {
            startService(Intent(this, MyFirebaseInstanceIDService::class.java))
        }
    }

    fun initComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }


}



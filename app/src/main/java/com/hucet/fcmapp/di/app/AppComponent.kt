package com.hucet.fcmapp.di.app

import com.hucet.fcmapp.di.google.GoogleComponent
import com.hucet.fcmapp.di.google.GoogleModule
import com.hucet.fcmapp.di.view.MainActivityComponent
import com.hucet.fcmapp.di.view.MainActivityModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        PreferenceModule::class,
        NetworkModule::class))
interface AppComponent {
    //    inject google
    fun plus(g: GoogleModule): GoogleComponent

    //    inject MainActivity
    fun plus(mainActivityModule: MainActivityModule): MainActivityComponent
}

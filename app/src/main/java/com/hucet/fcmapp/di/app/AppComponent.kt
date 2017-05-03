package com.hucet.fcmapp.di.app

import com.hucet.fcmapp.di.google.GoogleTokenComponent
import com.hucet.fcmapp.di.google.GoogleTokenModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class,
        PreferenceModule::class))
interface AppComponent {

    fun plus(g: GoogleTokenModule): GoogleTokenComponent
}

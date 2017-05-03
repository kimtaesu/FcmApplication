package com.hucet.fcmapp.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Module
class AppModule(val application: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }
}

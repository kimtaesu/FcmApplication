package com.hucet.fcmapp.di.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }


    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }
}

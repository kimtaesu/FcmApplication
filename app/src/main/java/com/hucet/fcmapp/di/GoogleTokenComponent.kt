package com.hucet.fcmapp.di

import com.hucet.fcmapp.MainActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(GoogleTokenModule::class))
interface GoogleTokenComponent {
    fun inject(mainActivity: MainActivity)
}

@Singleton
@Module
class GoogleTokenModule {
    @Provides
    @Singleton
    fun provideToken(): GoogleTokenService {
        return GoogleTokenService()
    }
}
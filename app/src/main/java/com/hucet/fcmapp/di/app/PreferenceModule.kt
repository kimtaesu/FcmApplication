package com.hucet.fcmapp.di.app

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.hucet.fcmapp.service.PreferenceService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferenceModule {

    @Provides
    @Singleton
    fun providePreference(c: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(c)
    }

    @Provides
    @Singleton
    fun providePreferenceService(s: SharedPreferences): PreferenceService {
        return PreferenceService(s)
    }
}
package com.hucet.fcmapp.di.view

import com.hucet.fcmapp.MainActivity
import com.hucet.fcmapp.di.google.ActivityScope
import com.hucet.fcmapp.di.google.GoogleScope
import com.hucet.fcmapp.presenter.MainActivityPresenter
import com.hucet.fcmapp.presenter.MainActivityPresenterImpl
import com.hucet.fcmapp.service.PreferenceService
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(val mainActivity: MainActivity) {
    @Provides
    @GoogleScope
    fun provideMainActivityPresenter(preference: PreferenceService): MainActivityPresenter {
        return MainActivityPresenterImpl(mainActivity, preference)
    }

    @Provides
    @GoogleScope
    fun provideMainActivity(): MainActivity {
        return mainActivity
    }

}

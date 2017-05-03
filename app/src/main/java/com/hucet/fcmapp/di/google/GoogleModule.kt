package com.hucet.fcmapp.di.google

import com.hucet.fcmapp.di.presenter.GooglePresenter
import com.hucet.fcmapp.di.presenter.GooglePresenterImpl
import com.hucet.fcmapp.service.GoogleTokenService
import com.hucet.fcmapp.service.PreferenceService
import dagger.Module
import dagger.Provides

@Module
class GoogleTokenModule {

    @GoogleScope
    @Provides
    fun provideToken(): GoogleTokenService {
        return GoogleTokenService()
    }

    @GoogleScope
    @Provides
    fun provideGooglePresenter(tokenService: GoogleTokenService,
                               preferenceService: PreferenceService): GooglePresenter {
        return GooglePresenterImpl(tokenService, preferenceService)
    }
}
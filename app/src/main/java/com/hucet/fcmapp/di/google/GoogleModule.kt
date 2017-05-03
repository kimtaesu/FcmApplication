package com.hucet.fcmapp.di.google

import com.hucet.fcmapp.repository.FCMRepository
import com.hucet.fcmapp.repository.ServerRepository
import com.hucet.fcmapp.service.FirebaseTokenService
import com.hucet.fcmapp.service.GooglePresenter
import com.hucet.fcmapp.service.GooglePresenterImpl
import com.hucet.fcmapp.service.PreferenceService
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class GoogleModule() {

    @GoogleScope
    @Provides
    fun provideFirebaseToken(): FirebaseTokenService {
        return FirebaseTokenService()
    }

    @GoogleScope
    @Provides
    fun provideGooglePresenter(tokenService: FirebaseTokenService,
                               preferenceService: PreferenceService,
                               repository: ServerRepository,
                               fcmRepository: FCMRepository): GooglePresenter {
        return GooglePresenterImpl(tokenService,
                preferenceService,
                repository,
                fcmRepository);
    }
}
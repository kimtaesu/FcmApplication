package com.hucet.fcmapp.di.presenter

import com.hucet.fcmapp.service.GoogleTokenService
import com.hucet.fcmapp.service.PreferenceService
import io.reactivex.Observable

interface GooglePresenter {
    fun updateGoogleId(): Observable<String>
}

class GooglePresenterImpl(val tokenService: GoogleTokenService,
                          val preferenceService: PreferenceService) : GooglePresenter {
    override fun updateGoogleId(): Observable<String> {
        return tokenService
                .getToken()
                //               Save the token to preference
                .map { token ->
                    preferenceService.setGoogleInstanceToken(token)
                    token
                }

    }
}
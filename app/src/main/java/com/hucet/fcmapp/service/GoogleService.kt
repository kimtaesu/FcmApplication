package com.hucet.fcmapp.service

import com.hucet.fcmapp.ifHttpFailThrowException
import com.hucet.fcmapp.onDefaultThread
import com.hucet.fcmapp.repository.GoogleToken
import com.hucet.fcmapp.repository.GoogleTokenResponse
import com.hucet.fcmapp.repository.ServerRepository
import io.reactivex.Observable
import retrofit2.Response

interface GooglePresenter {
    fun updateGoogleToken(): Observable<GoogleTokenResponse>
}

class GooglePresenterImpl(val tokenService: FirebaseTokenService,
                          val preferenceService: PreferenceService,
                          val repository: ServerRepository) : GooglePresenter {
    override fun updateGoogleToken(): Observable<GoogleTokenResponse> {
//       ??? Token? ?? ????? Skip
        val token = preferenceService.getGoogleInstanceToken()
        if (null != token) {
            return Observable.just(GoogleTokenResponse(token))
        }

//       ??? Token? ??? ??
        return tokenService.getToken()
                .map { token ->
                    preferenceService.setGoogleInstanceToken(token)
                    GoogleToken(token)
                }
                .concatMap { token ->
                    repository.saveGoogleToken(token)
                            .onDefaultThread()
                            .ifHttpFailThrowException()
                }
                .map(Response<GoogleTokenResponse>::body)
    }
}
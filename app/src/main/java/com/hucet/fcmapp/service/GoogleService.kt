package com.hucet.fcmapp.service

import com.hucet.fcmapp.ifHttpFailThrowException
import com.hucet.fcmapp.model.*
import com.hucet.fcmapp.onDefaultThread
import com.hucet.fcmapp.repository.FCMRepository
import com.hucet.fcmapp.repository.ServerRepository
import io.reactivex.Observable
import retrofit2.Response

interface GooglePresenter {
    fun updateGoogleToken(): Observable<GoogleTokenResponse>

    fun sendMessage(data: FCMData): Observable<FCMResponse>
}

class GooglePresenterImpl(val tokenService: FirebaseTokenService,
                          val preferenceService: PreferenceService,
                          val repository: ServerRepository,
                          val fcmRepository: FCMRepository) : GooglePresenter {

    override fun updateGoogleToken(): Observable<GoogleTokenResponse> {
        val token = preferenceService.getGoogleInstanceToken()
        if (null != token) {
            return Observable.just(GoogleTokenResponse(token))
        }

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

    override fun sendMessage(data: FCMData): Observable<FCMResponse> {
        val msg = FCMMesage(to = preferenceService.getGoogleInstanceToken()!!, data = data)

        return fcmRepository.sendMessage(msg)
                .onDefaultThread()
                .ifHttpFailThrowException()
                .map { it ->
                    it.body()
                }
    }

}
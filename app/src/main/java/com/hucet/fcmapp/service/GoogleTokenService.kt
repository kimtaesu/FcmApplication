package com.hucet.fcmapp.service

import com.google.firebase.iid.FirebaseInstanceId
import com.hucet.fcmapp.exception.TokenNullException
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


class GoogleTokenService {
    fun getToken(): Observable<String> {

        val token = FirebaseInstanceId.getInstance().token
        return Observable.just(token!!)
                .map { token ->
                    //                    token ?: throw TokenNullException("Token is null")
                    throw TokenNullException("Token is null")
                    token
                }
                .subscribeOn(Schedulers.io())
    }
}
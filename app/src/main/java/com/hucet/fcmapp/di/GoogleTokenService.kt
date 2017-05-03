package com.hucet.fcmapp.di

import com.google.firebase.iid.FirebaseInstanceId
import io.reactivex.Single
import io.reactivex.rxkotlin.toSingle


class GoogleTokenService {
    fun getToken(): Single<String> {
        FirebaseInstanceId.getInstance().token ?: throw RuntimeException("token is null")

        FirebaseInstanceId.getInstance().token!!
                .toSingle()
                .map {

                }
    }
}
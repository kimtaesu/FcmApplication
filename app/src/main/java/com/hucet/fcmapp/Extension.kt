package com.hucet.fcmapp

import com.hucet.fcmapp.exception.HttpFailException
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

inline fun <T> Observable<Response<T>>.onDefaultThread(): Observable<Response<T>> {
    return this
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}


inline fun <T> Observable<Response<T>>.ifHttpFailThrowException(): Observable<Response<T>> {
    return this.map { res ->
        if (!res.isSuccessful)
            throw HttpFailException("message : ${res.message()} code : ${res.code()}")
        res
    }
}
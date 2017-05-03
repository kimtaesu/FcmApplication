package com.hucet.fcmapp.repository

import com.hucet.fcmapp.model.*
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface FCMRepository {

    @POST("fcm/send")
    @Headers(
            "Content-Type: application/json"
    )
    fun sendMessage(@Body request: FCMMesage): Observable<Response<FCMResponse>>

}
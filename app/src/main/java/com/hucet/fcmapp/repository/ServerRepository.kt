package com.hucet.fcmapp.repository

import com.hucet.fcmapp.model.*
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface ServerRepository {
    @POST("post")
    @Headers(
            "Content-Type: application/json; charset=utf-8"
    )
    fun saveGoogleToken(@Body request: GoogleToken): Observable<Response<GoogleTokenResponse>>

}
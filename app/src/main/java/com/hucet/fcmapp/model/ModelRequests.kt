package com.hucet.fcmapp.model

data class GoogleToken(val token: String)


data class FCMMesage(val to: String, val data: FCMData)

data class FCMData(val message: String)
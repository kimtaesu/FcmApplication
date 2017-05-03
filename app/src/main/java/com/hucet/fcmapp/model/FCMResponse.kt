package com.hucet.fcmapp.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*


data class FCMResponse(
        val multicast_id: Long,
        val success: Long,
        val failure: Long,
        val canonical_ids: Long
) {

}
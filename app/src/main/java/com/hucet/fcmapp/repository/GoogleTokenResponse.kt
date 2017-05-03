package com.hucet.fcmapp.repository

import android.os.Parcel
import android.os.Parcelable

data class GoogleTokenResponse(
        val data: String
) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<GoogleTokenResponse> = object : Parcelable.Creator<GoogleTokenResponse> {
            override fun createFromParcel(source: Parcel): GoogleTokenResponse = GoogleTokenResponse(source)
            override fun newArray(size: Int): Array<GoogleTokenResponse?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(data)
    }
}

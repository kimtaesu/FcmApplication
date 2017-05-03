package com.hucet.fcmapp.service

import android.content.SharedPreferences
import javax.inject.Inject


class PreferenceService @Inject constructor(val s: SharedPreferences) {
    val KEY_TOKEN = "key_google_token"
    fun getGoogleInstanceToken(): String? {
        return s.getString(KEY_TOKEN, null);
    }

    fun setGoogleInstanceToken(token: String) {
        val editor = s.edit()
        editor.putString(KEY_TOKEN, token)
        editor.commit()
    }
}
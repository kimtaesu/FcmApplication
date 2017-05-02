package com.hucet.fcmapp

import com.google.firebase.iid.FirebaseInstanceId
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class MainActivityTest {
    @Test
    fun addition_isCorrect() {
        FirebaseInstanceId.getInstance().token
    }
}
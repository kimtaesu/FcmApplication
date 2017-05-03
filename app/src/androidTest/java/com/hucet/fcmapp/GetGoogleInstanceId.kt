package com.hucet.fcmapp

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import android.content.Intent


@RunWith(AndroidJUnit4::class)
class GetGoogleInstanceId {
    @Rule
    @JvmField var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun GoogleInstanceId_???() {

    }
}
package com.hucet.fcmapp.di.google

import com.hucet.fcmapp.MainActivity
import com.hucet.fcmapp.MyFirebaseInstanceIDService
import dagger.Subcomponent


@GoogleScope
@Subcomponent(modules = arrayOf(
        GoogleModule::class
))
interface GoogleComponent {
    fun inject(service: MyFirebaseInstanceIDService)
}

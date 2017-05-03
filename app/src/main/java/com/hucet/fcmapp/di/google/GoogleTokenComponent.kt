package com.hucet.fcmapp.di.google

import com.hucet.fcmapp.MainActivity
import dagger.Subcomponent


@GoogleScope
@Subcomponent(modules = arrayOf(GoogleTokenModule::class))
interface GoogleTokenComponent {
    fun inject(mainActivity: MainActivity)
}


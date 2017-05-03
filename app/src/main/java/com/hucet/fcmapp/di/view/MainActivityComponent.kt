package com.hucet.fcmapp.di.view

import com.hucet.fcmapp.MainActivity
import com.hucet.fcmapp.di.google.ActivityScope
import com.hucet.fcmapp.di.google.GoogleModule
import com.hucet.fcmapp.di.google.GoogleScope
import dagger.Subcomponent

@GoogleScope
@Subcomponent(modules = arrayOf(MainActivityModule::class, GoogleModule::class))
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}

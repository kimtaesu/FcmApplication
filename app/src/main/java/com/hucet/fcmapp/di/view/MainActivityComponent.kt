package com.hucet.fcmapp.di.view

import com.hucet.fcmapp.MainActivity
import com.hucet.fcmapp.di.google.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}

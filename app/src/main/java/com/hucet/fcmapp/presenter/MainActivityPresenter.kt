package com.hucet.fcmapp.presenter

import com.hucet.fcmapp.MainActivity
import com.hucet.fcmapp.service.PreferenceService
import kotlinx.android.synthetic.main.activity_main.*

interface MainActivityPresenter {
    fun updateTokenUi()
}

class MainActivityPresenterImpl constructor(val mainActivity: MainActivity, val prefer: PreferenceService) : MainActivityPresenter {

    override fun updateTokenUi() {
        mainActivity.dis_token.text = prefer.getGoogleInstanceToken()
    }
}
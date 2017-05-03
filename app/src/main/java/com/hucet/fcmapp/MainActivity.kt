package com.hucet.fcmapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hucet.fcmapp.presenter.MainActivityPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.injectMainActivityComponent(this)

        mainActivityPresenter.updateTokenUi()
    }
}

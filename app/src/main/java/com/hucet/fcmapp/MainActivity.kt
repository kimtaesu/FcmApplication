package com.hucet.fcmapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hucet.fcmapp.di.google.GoogleTokenModule
import com.hucet.fcmapp.di.presenter.GooglePresenter
import com.hucet.fcmapp.service.PreferenceService
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var googlePresenter: GooglePresenter

    @Inject
    lateinit var preferenceService: PreferenceService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.appComponent.plus(GoogleTokenModule()).inject(this)
        googlePresenter
                .updateGoogleId()
                .subscribe(
                        { it ->
                        },
                        { error ->
                        })
    }
}

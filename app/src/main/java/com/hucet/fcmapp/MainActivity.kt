package com.hucet.fcmapp

import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.hucet.fcmapp.di.GoogleTokenService
import io.reactivex.Single
import io.reactivex.rxkotlin.toSingle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var googleTokenService: GoogleTokenService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.googleTokenComponent.inject(this)
//        googleTokenService.getToken().subscribe({ token ->
//            Log.e("!!!!!!!!!!!!!!!!!!", token)

//        })
//        Log.e("!!!!!!!!!!!!", FirebaseInstanceId.getInstance().getToken();)
//        print(googleInstanceToken)
    }
}

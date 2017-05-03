package com.hucet.fcmapp

import android.util.Log
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import com.hucet.fcmapp.service.GooglePresenter
import javax.inject.Inject

class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {

    @Inject
    lateinit var googlePresenter: GooglePresenter

    override fun onCreate() {
        super.onCreate()
        MyApplication.injectGoogleModule(this)
    }

    /**
     * Called if InstanceID tokenService is updated. This may occur if the security of
     * the previous tokenService had been compromised. Note that this is called when the InstanceID tokenService
     * is initially generated so this is where you would retrieve the tokenService.
     */
    // [START refresh_token]
    override fun onTokenRefresh() {

        // Get updated InstanceID tokenService.
        val refreshedToken = FirebaseInstanceId.getInstance().token
        googlePresenter.updateGoogleToken()
                .blockingSubscribe(
                        { token ->
                        },
                        { error ->
                            Toast.makeText(this, "Token? ????? ???????.", Toast.LENGTH_SHORT).show()
                        })
        Log.d("TokenRefresh", "Refreshed tokenService: " + refreshedToken!!)
    }

}
package com.hucet.fcmapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.hucet.fcmapp.model.FCMData
import com.hucet.fcmapp.model.FCMMesage
import com.hucet.fcmapp.presenter.MainActivityPresenter
import com.hucet.fcmapp.service.GooglePresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    @Inject
    lateinit var googlePresenter: GooglePresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.injectMainActivityComponent(this)
        mainActivityPresenter.updateTokenUi()

        send_message.setOnClickListener {
            googlePresenter.sendMessage(FCMData(input.text.toString()))
                    .subscribe({ body ->

                    }, { error ->
                        Toast.makeText(this, "Fail to send the messages", Toast.LENGTH_SHORT).show()
                    })
        }
    }
}

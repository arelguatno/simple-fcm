package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging

private const val TAG = "FcmAndFiam"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fcm()
    }

    private fun fcm(){

        FirebaseMessaging.getInstance().token.addOnCompleteListener { regTokenTask ->
            if (regTokenTask.isSuccessful) {
                Log.d(TAG, "FCM registration token: ${regTokenTask.result}")
            } else {
                Log.e(TAG, "Unable to retrieve registration token",
                    regTokenTask.exception)
            }
        }
        FirebaseInstallations.getInstance().id.addOnCompleteListener { installationIdTask ->
            if (installationIdTask.isSuccessful) {
                Log.d(TAG, "Firebase Installations ID: ${installationIdTask.result}")
            } else {
                Log.e(
                    TAG, "Unable to retrieve installations ID",
                    installationIdTask.exception
                )
            }
        }

    }
}
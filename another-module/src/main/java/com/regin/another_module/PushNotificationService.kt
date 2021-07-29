package com.regin.another_module

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.android.EarlyEntryPoints
import dagger.hilt.components.SingletonComponent

class PushNotificationService : FirebaseMessagingService() {

    @EarlyEntryPoint
    @InstallIn(SingletonComponent::class)
    interface PushNotificationServiceInterface {}

    override fun onMessageReceived(message: RemoteMessage) {

    }

    override fun onNewToken(token: String) {
        Log.d("HiltIssue", "Ensure that app gets here")
        val service =
            EarlyEntryPoints.get(applicationContext, PushNotificationServiceInterface::class.java)
        Log.d("HiltIssue", "and at this point app won't get $service")
    }
}
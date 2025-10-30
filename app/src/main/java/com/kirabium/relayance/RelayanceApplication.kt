package com.kirabium.relayance

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * The application class for the Relayance application.
 * This class serves as the entry point for the application and can be used for global application-level
 * initialization tasks such as dependency injection setup using Hilt.
 */
@HiltAndroidApp
class RelayanceApplication : Application() {

    /**
     * Called when the application is starting, before any activity, service, or receiver objects (excluding content providers) have been created.
     */
    override fun onCreate() {
        super.onCreate()
    }
}
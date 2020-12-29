package com.android.layout;

import android.app.Application;

class LayoutApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}

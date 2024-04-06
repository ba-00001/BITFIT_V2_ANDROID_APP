package com.example.bitfit_v2_android_app

import android.app.Application

class BitFitApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}
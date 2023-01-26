package com.jg.ts.application

import android.app.Application
import com.jg.ts.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class TsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        // only for debug the timber is able
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}
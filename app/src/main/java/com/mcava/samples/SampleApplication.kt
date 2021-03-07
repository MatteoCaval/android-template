package com.mcava.samples

import android.app.Application
import com.mcava.samples.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()

            androidContext(this@SampleApplication)

            androidFileProperties()

            modules(appModule)
        }
    }
}
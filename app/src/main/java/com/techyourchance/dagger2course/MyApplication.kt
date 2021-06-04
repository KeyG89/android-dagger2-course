package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.di.AppModule
import com.techyourchance.dagger2course.common.di.DaggerAppComponent

class MyApplication: Application() {

    public val appComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}
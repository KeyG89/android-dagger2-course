package com.techyourchance.dagger2course.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
        private val activity: AppCompatActivity
) {

    @Provides
    fun activity() = activity

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

}
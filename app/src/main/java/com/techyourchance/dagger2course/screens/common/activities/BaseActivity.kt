package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.di.activity.ActivityModule
import com.techyourchance.dagger2course.common.di.activity.DaggerActivityComponent
import com.techyourchance.dagger2course.common.di.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.di.presentation.PresentationComponent
import com.techyourchance.dagger2course.common.di.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this, appComponent))
                .build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
                .presentationModule(PresentationModule(activityComponent))
                .build()
    }

    protected val injector: PresentationComponent get() = presentationComponent
}
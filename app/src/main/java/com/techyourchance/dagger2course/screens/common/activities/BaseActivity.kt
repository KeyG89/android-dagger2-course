package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.di.ActivityCompositionRoot
import com.techyourchance.dagger2course.common.di.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.di.Injector
import com.techyourchance.dagger2course.common.di.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot

    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
                .presentationModule(PresentationModule(activityCompositionRoot))
                .build()
    }

    protected val injector get() = Injector(presentationComponent)
}
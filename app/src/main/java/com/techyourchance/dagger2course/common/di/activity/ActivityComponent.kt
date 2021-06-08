package com.techyourchance.dagger2course.common.di.activity

import com.techyourchance.dagger2course.common.di.app.AppComponent
import com.techyourchance.dagger2course.common.di.presentation.PresentationComponent
import com.techyourchance.dagger2course.common.di.presentation.PresentationModule
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}
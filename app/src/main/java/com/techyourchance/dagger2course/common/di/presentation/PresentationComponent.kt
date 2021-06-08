package com.techyourchance.dagger2course.common.di.presentation

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class, UseCasesModule::class])
interface PresentationComponent {

    fun inject(fragment: QuestionsListFragment)
    fun inject(activity: QuestionDetailsActivity)
}
package com.techyourchance.dagger2course.common.di

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment

class Injector(private val compositionRoot: PresentationCompositionRoot) {
    fun inject(fragment: QuestionsListFragment) {
        with(fragment) {
            fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
            dialogsNavigator = compositionRoot.dialogsNavigator
            screensNavigator = compositionRoot.screensNavigator
            viewMvcFactory = compositionRoot.viewMvcFactory
        }
    }

    fun inject(activity: QuestionDetailsActivity) {
        with(activity) {
            fetchQuestionsDetailsUseCase = compositionRoot.fetchQuestionsDetailsUseCase
            dialogsNavigator = compositionRoot.dialogsNavigator
            screensNavigator = compositionRoot.screensNavigator
            viewMvcFactory = compositionRoot.viewMvcFactory
        }
    }
}
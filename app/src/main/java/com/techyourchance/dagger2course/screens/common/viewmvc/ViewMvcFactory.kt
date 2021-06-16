package com.techyourchance.dagger2course.screens.common.viewmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.techyourchance.dagger2course.screens.common.imageloader.ImageLoader
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsViewMvc
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject
import javax.inject.Provider

class ViewMvcFactory @Inject constructor(
        private val layoutInflaterProvider: Provider<LayoutInflater>,
        private val imageLoaderProvider: Provider<ImageLoader>) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflaterProvider.get(), parent)
    }

    fun newQuestionDetailsViewMvc(parent: ViewGroup? = null): QuestionDetailsViewMvc {
        val imageLoader1 = imageLoaderProvider.get()
        val imageLoader2 = imageLoaderProvider.get()
        val imageLoader3 = imageLoaderProvider.get()

        return QuestionDetailsViewMvc(layoutInflaterProvider.get(), imageLoaderProvider.get(),  parent)
    }
}
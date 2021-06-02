package com.techyourchance.dagger2course.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.questions.FetchQuestionsDetailsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.ServerErrorDialogFragment
import kotlinx.coroutines.*

class QuestionDetailsActivity : AppCompatActivity(), QuestionDetailsViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var viewMvc: QuestionDetailsViewMvc

    private lateinit var fetchQuestionsDetailsUseCase: FetchQuestionsDetailsUseCase

    private lateinit var questionId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewMvc = QuestionDetailsViewMvc(LayoutInflater.from(this), null)

        setContentView(viewMvc.rootView)

        // retrieve question ID passed from outside
        questionId = intent.extras!!.getString(EXTRA_QUESTION_ID)!!

        fetchQuestionsDetailsUseCase = FetchQuestionsDetailsUseCase()
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        fetchQuestionDetails()
    }

    override fun onStop() {
        super.onStop()
        viewMvc.unRegisterListener(this)
        coroutineScope.coroutineContext.cancelChildren()
    }

    private fun fetchQuestionDetails() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                val result = fetchQuestionsDetailsUseCase.fetchDetailedQuestion(questionId)
                when (result) {
                    is FetchQuestionsDetailsUseCase.Result.Success -> {
                        viewMvc.bindQuestionBody(result.question.body)

                    }
                    is FetchQuestionsDetailsUseCase.Result.Failure -> {
                        onFetchFailed()
                    }
                }
            } finally {
                viewMvc.hideProgressIndication()
            }

        }
    }

    private fun onFetchFailed() {
        supportFragmentManager.beginTransaction()
                .add(ServerErrorDialogFragment.newInstance(), null)
                .commitAllowingStateLoss()
    }

    override fun onBackClicked() {
        super.onBackPressed()
    }

    companion object {
        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"
        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }
}
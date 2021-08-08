package com.techyourchance.dagger2course.screens.questionslist

import android.os.Bundle
import android.util.Log
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuestionsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_frame)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(
                R.id.frame_content, QuestionsListFragment()
            ).commit()
        }
    }
}
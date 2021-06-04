package com.techyourchance.dagger2course.screens.common.activities

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    protected val compositionRoot get() = (requireActivity() as BaseActivity).compositionRoot
}
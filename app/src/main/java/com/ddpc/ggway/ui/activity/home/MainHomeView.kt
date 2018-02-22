package com.ddpc.ggway.ui.activity.home

import com.ddpc.ggway.ui.MainView

/**
 * Created by diha- on 10.02.2018.
 */

interface MainHomeView : MainView {
    fun changeFragment(position: Int)
    fun startSignInActivity()
    fun showAlertDialogUpdateProfileInformation()
}

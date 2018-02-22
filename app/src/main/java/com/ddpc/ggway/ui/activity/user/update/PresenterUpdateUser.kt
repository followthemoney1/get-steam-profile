package com.ddpc.ggway.ui.activity.user.update

import com.ddpc.ggway.ui.MainPresenter

/**
 * Created by diha- on 03.02.2018.
 */

interface PresenterUpdateUser : MainPresenter {
    fun onUpdateButtonClick(userId: String)
    fun onItemClicked(position: Int)
}

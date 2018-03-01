package com.ddpc.ggway.ui.fragment.user.create

import com.ddpc.ggway.ui.MainPresenter

/**
 * Created by diha- on 03.02.2018.
 */

interface PresenterCreateUser : MainPresenter {
    fun onUpdateButtonClick(userId: String)
    fun onItemClicked(position: Int)
}

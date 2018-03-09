package com.ddpc.ggway.ui.fragment.user.change

import android.content.Context

/**
 * Created by diha- on 08.03.2018.
 */
class ChangeUserProfilePresenterImpl(val changeUserProfileView: ChangeUserProfileView, val context:Context) : ChangeUserProfilePresenter {
    override fun onResume() {
        changeUserProfileView.getFragmentArguments()
        changeUserProfileView.initRecycleView()
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
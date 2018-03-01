package com.ddpc.ggway.ui.activity.user.update

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

import com.ddpc.ggway.R
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.ddpc.ggway.ui.fragment.user.create.CreateUserProfileFragment
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Predicate

/**
 * Created by diha- on 09.01.2018.
 */

class UserProfileActivity : Activity(), ViewUserProfile {

    lateinit var presenter: PresenterUserProfileImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user_profile)
        ButterKnife.bind(this)
        presenter = PresenterUserProfileImpl(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun addCreateUserProfileFragment() {
     fragmentManager.beginTransaction()
             .replace(R.id.root,CreateUserProfileFragment.newInstance())
             .commit()
    }

    override fun addUpdateUserProfileFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

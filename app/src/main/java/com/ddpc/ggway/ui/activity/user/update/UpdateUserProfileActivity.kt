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
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Predicate

/**
 * Created by diha- on 09.01.2018.
 */

class UpdateUserProfileActivity : Activity(), ViewUpdateUser {

    @BindView(R.id.userId)
    lateinit var userId: EditText
    @BindView(R.id.loadData)
    lateinit var loadData: ImageView

    lateinit var presenter: PresenterUpdateUserImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user_profile)
        ButterKnife.bind(this)
        presenter = PresenterUpdateUserImpl(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    @OnClick(R.id.loadData)
    internal fun loadDataOnClick() {
        presenter.onUpdateButtonClick(userId.text.toString())
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setOnItemClick() {

    }

    override fun setTextChangeListener() {
        RxTextView.afterTextChangeEvents(userId)
                .subscribe(object : Observer<TextViewAfterTextChangeEvent> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(value: TextViewAfterTextChangeEvent) {
                        if (userId.length() > 0 && !userId.text.toString().contains(" ")) {
                            loadData.isEnabled = true
                            loadData.setColorFilter(0)
                        } else {
                            loadData.isEnabled = false
                            loadData.setColorFilter(resources.getColor(R.color.text_secondary_light))
                        }
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {

                    }
                })
    }
}

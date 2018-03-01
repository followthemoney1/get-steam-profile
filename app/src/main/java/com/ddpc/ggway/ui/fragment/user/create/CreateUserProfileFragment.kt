package com.ddpc.ggway.ui.fragment.user.create

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.ddpc.ggway.R
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by diha- on 01.03.2018.
 */
class CreateUserProfileFragment: Fragment(), ViewCreateUser {

    @BindView(R.id.userId)
    lateinit var userId: EditText
    @BindView(R.id.loadData)
    lateinit var loadData: ImageView

    lateinit var presenter: PresenterCreateUserImpl

     companion object {
        fun newInstance():Fragment{
            val args = Bundle()
            val fragment = CreateUserProfileFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val root = inflater!!.inflate(R.layout.fragment_create_user_profile,container,false);
        ButterKnife.bind(this,root);
        presenter = PresenterCreateUserImpl(this)
        return root
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOnItemClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
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
package com.ddpc.ggway.ui.fragment.user.create

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.fragment_create_user_profile.*
import com.ddpc.ggway.R
import com.ddpc.ggway.data.steam.UserData
import com.ddpc.ggway.data.steam.models.GameData
import com.ddpc.ggway.data.steam.models.SteamUser
import com.ddpc.ggway.ui.activity.user.update.PresenterUserProfile
import com.ddpc.ggway.ui.activity.user.update.ViewUserProfile

/**
 * Created by diha- on 01.03.2018.
 */
class CreateUserProfileFragment: androidx.fragment.app.Fragment(), ViewCreateUser {

    lateinit var presenter: PresenterCreateUserImpl

    lateinit var viewUserProfileInterface: ViewUserProfile

     companion object {
        fun newInstance():CreateUserProfileFragment{
            val args = Bundle()
            val fragment = CreateUserProfileFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_create_user_profile,container,false);
        presenter = PresenterCreateUserImpl(this)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewsOnClick()
    }

    fun setUpViewsOnClick(){
        loadData.setOnClickListener {
            presenter.onUpdateButtonClick(userId.text.toString())
        }
        addAnotherGame.setOnClickListener {
            viewUserProfileInterface.updateUserGameData(UserData(null,null))
        }
        userId.doAfterTextChanged {
            if (userId.length() > 0 && !userId.text.toString().contains(" ")) {
                loadData.isEnabled = true
                loadData.setColorFilter(0)
            } else {
                loadData.isEnabled = false
                loadData.setColorFilter(resources.getColor(R.color.text_secondary_light))
            }
        }
    }
    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun setOnItemClick() {
    }

    override fun setTextChangeListener() {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initInterfaces(context as Activity)
    }

    fun initInterfaces( context: Activity){
        viewUserProfileInterface =  context as ViewUserProfile
    }

    override fun updateGameData(o: UserData) {
        viewUserProfileInterface.updateUserGameData(o)
    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}
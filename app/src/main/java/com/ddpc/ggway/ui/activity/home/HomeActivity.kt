package com.ddpc.ggway.ui.activity.home

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.ddpc.ggway.R
import com.ddpc.ggway.ui.MyFragmentManager
import com.ddpc.ggway.ui.activity.SettingsActivity
import com.ddpc.ggway.ui.activity.user.update.UserProfileActivity
import com.ddpc.ggway.utils.Constants.RC_SIGN_IN
import com.ddpc.ggway.utils.ViewUtils
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


class HomeActivity : FragmentActivity(), MainHomeView {
    private val TAG = "HomeActivity"

    var previousButton: View? = null

    val providers = arrayListOf(
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
    )

    lateinit var presenter: MainHomePresenterImpl
    lateinit var myFragmentManager: MyFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainHomePresenterImpl(this)
        myFragmentManager = MyFragmentManager(supportFragmentManager, R.id.content)
        setUpViewClicks()
    }

    fun setUpViewClicks(){
        arrowUp.setOnClickListener {
            val i = Intent(this, SettingsActivity::class.java)
            startActivity(i,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        search.setOnClickListener {
            changeFragment(0)
            updateBottomMenuViewState(it)
        }
        mail.setOnClickListener {
            updateBottomMenuViewState(it)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    protected override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        myFragmentManager.onBackPressed()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeFragment(position: Int) {
        myFragmentManager.changeFragment(position)
    }

    override fun startSignInActivity() {
//        startActivityForResult(
//                AuthUI.getInstance()
//                        .createSignInIntentBuilder()
//                        .setAvailableProviders(providers)
//                        .setLogo(R.drawable.googleg_standard_color_18)
//                        .setTheme(R.style.GGWay)
//                        .build(),
//                RC_SIGN_IN)
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN)
    }

    override fun showAlertDialogUpdateProfileInformation() {
        ViewUtils.showAlertDialog(this, "Profile status", "Your profile information is not filled, would you like to fill it? ") { startActivity(Intent(this@HomeActivity, UserProfileActivity::class.java)) }
    }

    fun updateBottomMenuViewState(v: View) {
        if (previousButton == null)
            previousButton = v
        else {
            previousButton!!.alpha = 0.2f
            previousButton = v
        }
        previousButton!!.alpha = 1f
    }
}

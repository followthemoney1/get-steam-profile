package com.ddpc.ggway.ui.activity.home

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.ddpc.ggway.R
import com.ddpc.ggway.ui.MyFragmentManager
import com.ddpc.ggway.ui.activity.SettingsActivity
import com.ddpc.ggway.ui.activity.user.update.UserProfileActivity
import com.ddpc.ggway.utils.Constants.RC_SIGN_IN
import com.ddpc.ggway.utils.ViewUtils
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.firebase.ui.auth.ResultCodes
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class HomeActivity : FragmentActivity(), MainHomeView {
    private val TAG = "HomeActivity"

    @BindView(R.id.arrowUp)
    lateinit  var arrowUp: ImageView

    var previousButton: View?=null

    private val providers = Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build(),
            AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build())

     lateinit var presenter: MainHomePresenterImpl
     lateinit var fragmentManager: MyFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        presenter = MainHomePresenterImpl(this)
        fragmentManager = MyFragmentManager(getFragmentManager(), R.id.content)
        onSearchClick(findViewById(R.id.search))
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        fragmentManager.onBackPressed()
    }

    @OnClick(R.id.arrowUp)
    internal fun upOnClick() {
        val i = Intent(this, SettingsActivity::class.java)
        startActivity(i,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

    }

    @OnClick(R.id.search)
    internal fun onSearchClick(v: View) {
        changeFragment(0)
        updateBottomMenuViewState(v)
    }

    @OnClick(R.id.mail)
    internal fun onMailClick(v: View) {
        updateBottomMenuViewState(v)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == ResultCodes.OK) {
                val user = FirebaseAuth.getInstance().currentUser

            } else {

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
        fragmentManager.changeFragment(position)
    }

    override fun startSignInActivity() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.googleg_standard_color_18)
                        .setTheme(R.style.GGWay)
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

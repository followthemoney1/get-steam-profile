package com.ddpc.ggway.ui.activity.home;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ddpc.ggway.R;
import com.ddpc.ggway.data.UserManager;
import com.ddpc.ggway.ui.MyFragmentManager;
import com.ddpc.ggway.ui.activity.SettingsActivity;
import com.ddpc.ggway.ui.activity.user.update.UpdateUserProfileActivity;
import com.ddpc.ggway.ui.widget.BackgroundMainAnimatedView;
import com.ddpc.ggway.utils.ViewUtils;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.ddpc.ggway.utils.Constants.RC_SIGN_IN;

public class HomeActivity extends FragmentActivity implements MainHomeView {
    private final String TAG = "HomeActivity";

    @BindView(R.id.arrowUp)
    ImageView arrowUp;

    View previousButton;

    private List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build(),
            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build());

    private MainHomePresenterImpl presenter;
    private MyFragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainHomePresenterImpl(this);
        fragmentManager = new MyFragmentManager(getFragmentManager(),R.id.content);
        onSearchClick(findViewById(R.id.search));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fragmentManager.onBackPressed();
    }

    @OnClick(R.id.arrowUp)
    void upOnClick(){
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }

    @OnClick(R.id.search)
    void onSearchClick(View v){
        changeFragment(0);
        updateBottomMenuViewState(v);
    }

    @OnClick(R.id.mail)
    void onMailClick(View v){
        updateBottomMenuViewState(v);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == ResultCodes.OK) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            } else {

            }
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeFragment(int position) {
        fragmentManager.changeFragment(position);
    }

    @Override
    public void startSignInActivity() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.googleg_standard_color_18)
                        .setTheme(R.style.GGWay)
                        .build(),
                RC_SIGN_IN);
    }

    @Override
    public void showAlertDialogUpdateProfileInformation() {
        ViewUtils.showAlertDialog(this, "Profile status", "Your profile information is not filled, would you like to fill it? ", new ViewUtils.DialogCallback() {
            @Override
            public void positiveButtonClick() {
                startActivity( new Intent(HomeActivity.this, UpdateUserProfileActivity.class));
            }
        });
    }

    void updateBottomMenuViewState(View v){
        if (previousButton == null) previousButton = v;
        else {
            previousButton.setAlpha(0.2f);
            previousButton = v;
        }
        previousButton.setAlpha(1f);
    }
}

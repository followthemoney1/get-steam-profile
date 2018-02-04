package com.ddpc.ggway.ui.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.ddpc.ggway.R;
import com.ddpc.ggway.data.FirebaseDataManager;
import com.ddpc.ggway.data.UserPresenter;
import com.ddpc.ggway.ui.activity.user.update.UpdateUserProfileActivity;
import com.ddpc.ggway.ui.widget.BackgroundMainAnimatedView;
import com.ddpc.ggway.utils.ViewUtils;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.apmem.tools.layouts.FlowLayout;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.ddpc.ggway.data.FirebaseDataManager.loadCategory;
import static com.ddpc.ggway.utils.CategoryUtils.createOneCategory;
import static com.ddpc.ggway.utils.Constants.RC_SIGN_IN;

public class MainActivity extends FragmentActivity {
    private final String TAG = "MainActivity";

    private Context context;

    @BindView(R.id.arrowUp)
    ImageView arrowUp;
    @BindView(R.id.flowLayout)
    FlowLayout flowLayout;
    @BindView(R.id.backgroundAnimatedView)
    BackgroundMainAnimatedView backgroundAnimatedView;

    private List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build(),
            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build());

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    UserPresenter userPresenter = new UserPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        ButterKnife.bind(this);
        checkAuth();
        getCategory(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        backgroundAnimatedView.invalidate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        backgroundAnimatedView.destroyAnimations();
    }

    @OnClick(R.id.arrowUp)
    void upOnClick(){
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

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

    private void checkAuth(){
        if ( auth.getCurrentUser() == null){
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                    .setLogo(R.drawable.googleg_standard_color_18)
                    .setTheme(R.style.GGWay)
                    .build(),
                    RC_SIGN_IN);
        }else {
            checkIfUserExistsInDatabase();
        }
    }

    private void checkIfUserExistsInDatabase(){
        userPresenter.checkIfUserExistsInDatabase(auth.getCurrentUser(), new UserPresenter.ExistUserCallback() {
            @Override
            public void exists() {
                ViewUtils.showToast(context,"User Exists");
            }

            @Override
            public void doesentExists() {
                ViewUtils.showAlertDialog(context, "Profile status", "Your profile information is not filled, would you like to fill it? ", new ViewUtils.DialogCallback() {
                    @Override
                    public void positiveButtonClick() {
                    startActivity( new Intent(context, UpdateUserProfileActivity.class));
                    }
                });
            }

            @Override
            public void error() {
                ViewUtils.showToast(context,"User Exists Error");
            }
        });
    }

    public void getCategory(final Context context){
        loadCategory(new FirebaseDataManager.CategoryCallback() {
            @Override
            public void onLoad(List<Object> list) {
                for (Iterator<Object> it = list.iterator(); it.hasNext(); ) {
                    Object object = it.next();
                    flowLayout.addView(createOneCategory(context,object.toString()));
                }
            }

            @Override
            public void onError() {
                Toast.makeText(MainActivity.this,"Error load category",Toast.LENGTH_SHORT).show();
            }
        });
    }

}

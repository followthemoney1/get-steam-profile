package com.ddpc.ggway.ui.activity.user.update;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;

import com.ddpc.ggway.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by diha- on 09.01.2018.
 */

public class UpdateUserProfileActivity  extends Activity  implements MainViewUpdateUser{

    @BindView(R.id.userId)
    EditText userId;

    MainPresenterUpdateUserImpl presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_profile);
        ButterKnife.bind(this);
        presenter = new MainPresenterUpdateUserImpl(this);
    }

    @OnClick(R.id.loadData)
    void loadDataOnClick(){
        presenter.onUpdateButtonClick(userId.getText().toString());
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
    public void setOnItemClick() {

    }
}

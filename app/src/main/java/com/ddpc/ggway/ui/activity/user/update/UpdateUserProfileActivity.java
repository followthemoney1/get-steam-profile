package com.ddpc.ggway.ui.activity.user.update;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ddpc.ggway.R;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

/**
 * Created by diha- on 09.01.2018.
 */

public class UpdateUserProfileActivity  extends Activity  implements ViewUpdateUser {

    @BindView(R.id.userId)
    EditText userId;
    @BindView(R.id.loadData)
    ImageView loadData;

    PresenterUpdateUserImpl presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_profile);
        ButterKnife.bind(this);
        presenter = new PresenterUpdateUserImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
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

    @Override
    public void setTextChangeListener() {
        RxTextView.afterTextChangeEvents(userId)
                .subscribe(new Observer<TextViewAfterTextChangeEvent>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextViewAfterTextChangeEvent value) {
                        if (userId.length()>0&&!userId.getText().toString().contains(" ")){
                            loadData.setEnabled(true);
                            loadData.setColorFilter(0);
                        }else {
                            loadData.setEnabled(false);
                            loadData.setColorFilter(getResources().getColor(R.color.text_secondary_light));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

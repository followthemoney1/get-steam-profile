package com.ddpc.ggway.data;

import android.support.annotation.NonNull;
import android.util.Log;

import com.ddpc.ggway.utils.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Collections;

import static com.ddpc.ggway.utils.Constants.USERS_FIREBASE;

/**
 * Created by diha- on 06.01.2018.
 */

public class UserPresenter {

    public interface ExistUserCallback{
        void exists();
        void doesentExists();
        void error();
    }

    private static FirebaseUser user ;
    private static FirebaseFirestore firebaseFirestore;

    public UserPresenter() {
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public static FirebaseUser getCurrentUser(){
        user = FirebaseAuth.getInstance().getCurrentUser();
        return user;
    }

    public void checkIfUserExistsInDatabase(final FirebaseUser user, final ExistUserCallback existUserCallback){
        firebaseFirestore.collection(USERS_FIREBASE)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                              if (document.contains(user.getUid())) {
                                  existUserCallback.exists();
                                  return;
                              }
                            }
                            existUserCallback.doesentExists();
                        } else {
                         existUserCallback.error();
                        }
                    }
                });

    }

}

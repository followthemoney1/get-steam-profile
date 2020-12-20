package com.ddpc.ggway.data

import android.util.Log

import com.ddpc.ggway.utils.Constants
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

import java.util.Collections

import com.ddpc.ggway.utils.Constants.USERS_FIREBASE

/**
 * Created by diha- on 06.01.2018.
 */

class UserManager {

    interface ExistUserCallback {
        fun exists()
        fun doesentExists()
        fun error()
    }

    init {
        firebaseFirestore = FirebaseFirestore.getInstance()
    }

    fun checkIfUserExistsInDatabase(user: FirebaseUser, existUserCallback: ExistUserCallback) {
        firebaseFirestore.collection(USERS_FIREBASE)
                .get()
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result) {
                            if (document.contains(user.uid)) {
                                existUserCallback.exists()
                                return@OnCompleteListener
                            }
                        }
                        existUserCallback.doesentExists()
                    } else {
                        existUserCallback.error()
                    }
                })

    }

    companion object {

        private var user: FirebaseUser? = null
        private lateinit var firebaseFirestore: FirebaseFirestore

        val currentUser: FirebaseUser?
            get() {
                user = FirebaseAuth.getInstance().currentUser
                return user
            }
    }

}

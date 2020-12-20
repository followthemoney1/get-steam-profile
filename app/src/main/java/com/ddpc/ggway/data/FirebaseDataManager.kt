package com.ddpc.ggway.data

import android.util.Log

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.QuerySnapshot

import java.util.ArrayList
import java.util.Collections

import com.ddpc.ggway.utils.Constants.CATEGORIES_FIREBASE

/**
 * Created by dd.pc on 09.12.2017.
 */

object FirebaseDataManager {
    interface CategoryCallback {
        fun onLoad(list: List<Any>)
        fun onError()
    }

    fun loadCategory(categoryCallback: CategoryCallback) {
        val categories = ArrayList<Any>()
        val settings = FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build()
        val db = FirebaseFirestore.getInstance()
        db.firestoreSettings = settings
        db.collection(CATEGORIES_FIREBASE)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result) {
                            Collections.addAll(categories, *document.data.values.toTypedArray())
                            categoryCallback.onLoad(categories)
                            Log.i("DATA CATEGORY--", document.data.values.toString())
                        }
                    } else {
                        categoryCallback.onError()
                        Log.w("DATA CATEGORY--", "Error getting documents.", task.exception)
                    }
                }
    }
}

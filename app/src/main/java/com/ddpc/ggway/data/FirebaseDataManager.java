package com.ddpc.ggway.data;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.ddpc.ggway.utils.Constants.CATEGORIES_FIREBASE;

/**
 * Created by dd.pc on 09.12.2017.
 */

public class FirebaseDataManager {
    public interface CategoryCallback{
        void onLoad(List<Object> list);
        void onError();
    }
    public static void loadCategory(final CategoryCallback categoryCallback){
        final List<Object> categories = new ArrayList<>();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.setFirestoreSettings(settings);
        db.collection(CATEGORIES_FIREBASE)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Collections.addAll(categories, document.getData().values().toArray());
                                categoryCallback.onLoad(categories);
                                Log.i("DATA CATEGORY--",document.getData().values().toString());
                            }
                        } else {
                            categoryCallback.onError();
                            Log.w("DATA CATEGORY--", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}

package com.mityaalim.data.remote.firestore

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase
import javax.inject.Inject


class FirestoreHelper @Inject constructor(){
    val db = Firebase.firestore
    val settings = firestoreSettings {
        isPersistenceEnabled = true
    }

    init {
        db.firestoreSettings = settings
    }
}
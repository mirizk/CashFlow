package com.mityaalim.data.remote.firestore

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestoreHelper @Inject constructor() {
    val db = Firebase.firestore
    val settings = firestoreSettings {
        isPersistenceEnabled = true
    }

    init {
        db.firestoreSettings = settings
    }

    suspend fun readEvents(): QuerySnapshot? {
        return try {
            val data = db.collection("events")
                .get()
                .await()
            data
        } catch (e: Exception) {
            null
        }

    }

    fun getEventsReference(): CollectionReference{
        return db.collection("events")
    }

    fun getInvestmentsReference(): CollectionReference {
        return db.collection("investments")
    }

    fun getAcademyReference(): CollectionReference {
        return db.collection("academy")
    }
}
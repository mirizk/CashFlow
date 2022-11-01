package com.mityaalim.data.remote

import com.google.firebase.firestore.ktx.toObject
import com.mityaalim.data.remote.firestore.FirestoreHelper
import com.mityaalim.data.remote.model.EventItem
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val firestoreHelper: FirestoreHelper
) {
    suspend fun getAllEvents(): List<EventItem>? {
        return firestoreHelper.readEvents()?.documents?.mapNotNull {
            it.toObject<EventItem>()
        }
    }

}
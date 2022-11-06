package com.mityaalim.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.toObject
import com.mityaalim.data.remote.firestore.FirestoreHelper
import com.mityaalim.data.remote.model.EventItem
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val firestoreHelper: FirestoreHelper
) {

    var events = MutableLiveData<List<EventItem>?>()
    suspend fun getAllEvents(): List<EventItem>? {
        return firestoreHelper.readEvents()?.documents?.mapNotNull {
            it.toObject<EventItem>()
        }
    }

    fun getEventsLiveData(): LiveData<List<EventItem>?> {
        firestoreHelper.getEventsReference().addSnapshotListener { value, error ->
            if (error != null) {
                events.value = null
                return@addSnapshotListener
            }

            val eventsList: MutableList<EventItem> = mutableListOf()
            for (doc in value!!) {
                val item = doc.toObject(EventItem::class.java)
                eventsList.add(item)
            }
            events.value = eventsList
        }
        return events
    }

}
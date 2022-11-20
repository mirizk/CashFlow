package com.mityaalim.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.toObject
import com.mityaalim.data.remote.firestore.FirestoreHelper
import com.mityaalim.data.remote.model.AcademyItem
import com.mityaalim.data.remote.model.EventItem
import com.mityaalim.data.remote.model.InvestmentsItem
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val firestoreHelper: FirestoreHelper
) {

    var events = MutableLiveData<List<EventItem>?>()
    var investments = MutableLiveData<List<InvestmentsItem>?>()
    var academy = MutableLiveData<List<AcademyItem>?>()
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

    fun getInvestmentsLiveData(): LiveData<List<InvestmentsItem>?> {
        firestoreHelper.getInvestmentsReference().addSnapshotListener { value, error ->
            if (error != null) {
                investments.value = null
                return@addSnapshotListener
            }

            val investmentsList: MutableList<InvestmentsItem> = mutableListOf()
            for (doc in value!!) {
                val item = doc.toObject(InvestmentsItem::class.java)
                investmentsList.add(item)
            }
            investments.value = investmentsList
        }
        return investments
    }

    fun getAcademyLiveData(): LiveData<List<AcademyItem>?> {
        firestoreHelper.getAcademyReference().addSnapshotListener { value, error ->
            if (error != null) {
                academy.value = null
                return@addSnapshotListener
            }

            val academyList: MutableList<AcademyItem> = mutableListOf()
            for (doc in value!!) {
                val item = doc.toObject(AcademyItem::class.java)
                academyList.add(item)
            }
            academy.value = academyList
        }
        return academy
    }


}
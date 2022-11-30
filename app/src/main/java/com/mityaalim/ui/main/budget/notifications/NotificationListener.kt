package com.mityaalim.ui.main.budget.notifications

import android.app.Notification
import android.os.Bundle
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.core.app.NotificationCompat
import com.mityaalim.data.enums.BudgetType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject


class NotificationListener
//@Inject constructor(repo: GeneralRepo)
    : NotificationListenerService() {

    private val listenerJob = SupervisorJob()
    private val listenerScope = CoroutineScope(listenerJob + Dispatchers.Default)

    override fun onDestroy() {
        // Cancel the Coroutines
        listenerJob.cancel()
    }

    override fun onListenerConnected() {
        Log.d("miri", "Notification Listener connected")
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        if (sbn.packageName != WA_PACKAGE) return
        val notification: Notification = sbn.notification
        val bundle: Bundle = notification.extras
        val from = bundle.getString(NotificationCompat.EXTRA_TITLE)
        val message = bundle.getString(NotificationCompat.EXTRA_TEXT)
        Log.d("miri", "From: $from")
        Log.d("miri", "Message: $message")
    }

    fun saveNewBudget(type: BudgetType, name: String, sum: Int, date: Date) {
        listenerScope.launch {
//            repo?.saveBudget(Budget(UUID.randomUUID().toString(), name, type, sum, date))
        }
    }

    companion object {
        private const val WA_PACKAGE = "com.whatsapp"
    }
}
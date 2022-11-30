package com.cashflow.ui.main.budget.notifications

import android.app.Notification
import android.os.Bundle
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.core.app.NotificationCompat
import com.cashflow.data.enums.BudgetType
import com.cashflow.data.general.Budget
import com.cashflow.data.repo.GeneralRepo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class NotificationListener : NotificationListenerService() {

    private val listenerJob = SupervisorJob()
    private val listenerScope = CoroutineScope(listenerJob + Dispatchers.Default)

    @Inject
    lateinit var repo: GeneralRepo


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
        val message = bundle.getString(NotificationCompat.EXTRA_TEXT)?.split(" ")
        Log.d("miri", "From: $from")
        Log.d("miri", "Message: $message")
        if ((message?.size ?: 0) < 4)
            return
        val price = message?.get(3)?.toIntOrNull()
        if (price != null)
        when(message.get(0)){
            "הכנסה" ->{saveNewBudget(BudgetType.INCOME, message.get(1), price, Date())}
            "הוצאה" ->{saveNewBudget(BudgetType.EXPENSE, message.get(1), price, Date())}
        }

    }

    fun saveNewBudget(type: BudgetType, name: String, sum: Int, date: Date) {
        listenerScope.launch {
            repo.saveBudget(Budget(UUID.randomUUID().toString(), name, type, sum, date))
        }
    }

    companion object {
        private const val WA_PACKAGE = "com.whatsapp"
    }
}
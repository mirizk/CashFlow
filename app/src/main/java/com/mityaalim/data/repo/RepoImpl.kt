package com.mityaalim.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.mityaalim.data.general.Budget
import com.mityaalim.data.general.Event
import com.mityaalim.data.local.database.LocalDataSource
import com.mityaalim.data.local.prefs.Prefs
import com.mityaalim.data.remote.RemoteDataSource
import com.mityaalim.data.remote.toGeneralEventsList
import com.mityaalim.ui.main.investment.ServiceItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val prefs: Prefs,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : GeneralRepo {

    override suspend fun saveBudget(budget: Budget) {
        localDataSource.insertBudget(budget)
    }

    override fun getAllBudget(): Flow<List<Budget>> {
        return localDataSource.getAllBudget()
    }

    override fun deleteBudget(budget: Budget) {
        localDataSource.deleteBudget(budget)
    }

    override fun getAllServices(): LiveData<List<ServiceItem>> {
        val services = listOf(
            ServiceItem(
                "1",
                "ליווי אישי – הכל כלול",
                "פגישת ליווי אישי הכוללת: מעבר על נושאים של בניית תוכנית כלכלית למשק הבית, תכנון ועזרה בבחירת ניירות ערך לצרכי בניית תיק השקעות, הוזלת עלויות בביטוחים, וסידור הפנסיה.",
                100f,
                "https://igreviews.org/wp-content/uploads/2020/12/5a.jpg.webp"
            ),
            ServiceItem(
                "2",
                "שירותי ראיית חשבון לעסקים ושכירים",
                "בין אם אתם שכירים שצריכים החזר מס, או עסקים קטנים שצריכים סיוע עם כל הנהלת החשבונות, אנחנו פה בשביל לעזור. העלות תלויה בצרכי ודרישות הלקוח.",
                imageUrl = "https://elceo.com/wp-content/uploads/2021/09/miscelanea-freepik.jpg"
            ),
            ServiceItem(
                "3",
                "פגישת ייעוץ עם יועץ נדל\"ן עצמאי ובלתי תלוי",
                "שיחת ייעוץ נדל\"ן עם יועץ עצמאי ובלתי תלוי, שבה נעבור איתכם ביחד על כל השאלות שיש לכם לגבי שוק הנדל\"ן וכיצד אפשר להשקיע בצורה נבונה.",
                300f,
                "https://resize.indiatv.in/resize/newbucket/905_-/2022/01/life-insurance-cover-1614605758-1641637993.jpg"
            ),
        )
        return MutableLiveData(services)
    }

    override fun getEventsLiveData(): LiveData<List<Event>?> {
        return remoteDataSource.getEventsLiveData().map {
            it?.toGeneralEventsList()
        }
    }
}
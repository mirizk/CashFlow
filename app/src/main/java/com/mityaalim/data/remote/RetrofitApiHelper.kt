package com.mityaalim.data.remote

import com.mityaalim.data.remote.model.AcademyResponse
import retrofit2.Call

interface RetrofitApiHelper {
    fun getAcademy():Call<AcademyResponse>
}
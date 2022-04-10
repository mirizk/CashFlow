package com.mityaalim.data.remote

import com.mityaalim.data.remote.model.AcademyResponse
import retrofit2.Call
import javax.inject.Inject

class RetrofitApiHelperImpl @Inject constructor(
    private val service: RetrofitService
) : RetrofitApiHelper {
    override fun getAcademy(): Call<AcademyResponse> {
        return service.getAcademy()
    }
}
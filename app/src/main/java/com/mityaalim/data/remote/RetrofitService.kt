package com.mityaalim.data.remote

import com.mityaalim.data.remote.model.AcademyResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET(RemoteConsts.GET_ACADEMY)
    fun getAcademy():Call<AcademyResponse>
}
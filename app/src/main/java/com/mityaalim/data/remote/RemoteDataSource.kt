package com.mityaalim.data.remote

import com.mityaalim.data.remote.model.AcademyResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val retrofitApiHelper: RetrofitApiHelper
) {
    suspend fun getAcademy(): AcademyResponse? {
        return retrofitApiHelper
            .getAcademy()
            .execute()
            .body()
    }
}
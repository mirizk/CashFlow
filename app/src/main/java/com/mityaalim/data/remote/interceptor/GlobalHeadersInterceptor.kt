package com.mityaalim.data.remote.interceptor

import com.mityaalim.data.remote.RemoteConsts
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class GlobalHeadersInterceptor: Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${RemoteConsts.TOKEN}")
            .addHeader("Accept-Version", "v1")
            .build()
        return chain.proceed(newRequest)
    }

}

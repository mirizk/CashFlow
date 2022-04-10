package com.mityaalim.data.remote

import android.content.Context
import com.mityaalim.data.remote.interceptor.IEnvironmentDependantInterceptorsSupplier
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class EnvironmentDependantInterceptorsSupplier : IEnvironmentDependantInterceptorsSupplier {
        override fun getLogInterceptor(): Interceptor {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            return logging
        }
    }




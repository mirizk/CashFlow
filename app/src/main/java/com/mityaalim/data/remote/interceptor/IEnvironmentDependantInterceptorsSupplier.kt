package com.mityaalim.data.remote.interceptor
import okhttp3.Interceptor

interface IEnvironmentDependantInterceptorsSupplier {
    fun getLogInterceptor(): Interceptor?
}

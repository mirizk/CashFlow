package com.mityaalim.di

import android.content.Context
import com.mityaalim.data.local.database.MityaalimDatabase
import com.mityaalim.data.local.prefs.PrefsImpl
import com.mityaalim.data.local.prefs.Prefs
import com.mityaalim.data.remote.*
import com.mityaalim.data.remote.interceptor.GlobalHeadersInterceptor
import com.mityaalim.data.remote.interceptor.IEnvironmentDependantInterceptorsSupplier
import com.mityaalim.data.repo.GeneralRepo
import com.mityaalim.data.repo.RepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MityaalimDatabase {
        return MityaalimDatabase.create(context)
    }

    @Provides
    @Singleton
    fun provideGeneralRepo(repoImpl: RepoImpl): GeneralRepo {
        return repoImpl
    }

    @Provides
    @Singleton
    fun providePrefs(prefsImpl: PrefsImpl): Prefs {
        return prefsImpl
    }

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(GlobalHeadersInterceptor())
        val interceptorsSupplier: IEnvironmentDependantInterceptorsSupplier =
            EnvironmentDependantInterceptorsSupplier()
        interceptorsSupplier.getLogInterceptor()?.let { builder.addInterceptor(it) }
        return Retrofit.Builder()
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RemoteConsts.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitService(retrofit: Retrofit) = retrofit.create(RetrofitService::class.java)

    @Provides
    @Singleton
    fun provideRetrofitApiHelper(retrofitApiHelperImpl: RetrofitApiHelperImpl): RetrofitApiHelper {
        return retrofitApiHelperImpl
    }

}

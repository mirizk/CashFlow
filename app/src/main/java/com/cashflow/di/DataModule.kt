package com.cashflow.di

import android.content.Context
import com.cashflow.data.local.database.CashFlowDatabase
import com.cashflow.data.local.prefs.PrefsImpl
import com.cashflow.data.local.prefs.Prefs
import com.cashflow.data.repo.GeneralRepo
import com.cashflow.data.repo.RepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CashFlowDatabase {
        return CashFlowDatabase.create(context)
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

}
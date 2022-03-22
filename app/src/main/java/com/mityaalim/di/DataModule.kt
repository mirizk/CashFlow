package com.mityaalim.di

import android.content.Context
import com.mityaalim.data.local.database.MityaalimDatabase
import com.mityaalim.data.local.prefs.PrefsImpl
import com.mityaalim.data.local.prefs.Prefs
import com.mityaalim.data.repo.GeneralRepo
import com.mityaalim.data.repo.RepoImpl
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

}
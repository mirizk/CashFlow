package com.mityaalim.di

import com.mityaalim.data.local.prefs.PrefsImpl
import com.mityaalim.data.local.prefs.Prefs
import com.mityaalim.data.repo.GeneralRepo
import com.mityaalim.data.repo.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindPrefs(prefsImpl: PrefsImpl): Prefs

    @Binds
    @Singleton
    abstract fun bindGeneralRepo(repoImpl: RepoImpl): GeneralRepo
}
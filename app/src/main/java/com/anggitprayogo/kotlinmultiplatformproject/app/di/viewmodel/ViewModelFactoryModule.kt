package com.anggitprayogo.kotlinmultiplatformproject.app.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.anggitprayogo.kotlinmultiplatformproject.app.di.viewmodel.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}
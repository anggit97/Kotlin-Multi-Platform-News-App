package com.anggitprayogo.kotlinmultiplatformproject.app.di.component

import com.anggitprayogo.kotlinmultiplatformproject.app.di.module.ApplicationModule
import com.anggitprayogo.kotlinmultiplatformproject.app.di.module.DomainModule
import com.anggitprayogo.kotlinmultiplatformproject.app.di.module.MainActivityModule
import com.anggitprayogo.kotlinmultiplatformproject.app.di.module.UtilsModule
import com.anggitprayogo.kotlinmultiplatformproject.app.di.subcomponent.MainActivityComponent
import com.anggitprayogo.kotlinmultiplatformproject.app.di.viewmodel.ViewModelFactoryModule
import com.anggitprayogo.kotlinmultiplatformproject.app.di.viewmodel.ViewModelModule
import com.anggitprayogo.kotlinmultiplatformproject.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        ViewModelModule::class,
        DomainModule::class,
        ViewModelFactoryModule::class,
        UtilsModule::class]
)
interface ApplicationComponent {

    fun plus(module: MainActivityModule) : MainActivityComponent
}
package com.anggitprayogo.kotlinmultiplatformproject.app.di.subcomponent

import com.anggitprayogo.kotlinmultiplatformproject.app.di.module.MainActivityModule
import com.anggitprayogo.kotlinmultiplatformproject.ui.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun injectTo(activity: MainActivity)
}
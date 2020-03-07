package com.anggitprayogo.kotlinmultiplatformproject.ui.main

import android.os.Bundle
import android.util.Log.e
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.anggitprayogo.kotlinmultiplatformproject.R
import com.anggitprayogo.kotlinmultiplatformproject.app.di.component.ApplicationComponent
import com.anggitprayogo.kotlinmultiplatformproject.app.di.module.MainActivityModule
import com.anggitprayogo.kotlinmultiplatformproject.ui.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInjection(App.graph)
        initViewModel()
        observeViewModel()
        fetchData()
    }

    private fun fetchData() {
        mainViewModel.getNewsByDomain("wsj.com,nytimes.com")
    }

    private fun initInjection(app: ApplicationComponent) {
        app.plus(MainActivityModule(this)).injectTo(this)
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
    }

    private fun observeViewModel() {
        mainViewModel.getNewsByDomainLiveData.observe(this, Observer {
            e("DATA : ", it.toString())
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
        })
    }
}
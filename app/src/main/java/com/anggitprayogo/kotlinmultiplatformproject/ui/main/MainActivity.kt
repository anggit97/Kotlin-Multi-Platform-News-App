package com.anggitprayogo.kotlinmultiplatformproject.ui.main

import android.os.Bundle
import android.util.Log.e
import android.util.Log.v
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.anggitprayogo.kotlinmultiplatformproject.R
import com.anggitprayogo.kotlinmultiplatformproject.app.di.component.ApplicationComponent
import com.anggitprayogo.kotlinmultiplatformproject.app.di.module.MainActivityModule
import com.anggitprayogo.kotlinmultiplatformproject.di.InjectionToken
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NewsApi
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NgampoozApi
import com.anggitprayogo.kotlinmultiplatformproject.ui.App
import domain.model.Article
import domain.model.NewsResponse
import domain.model.profile.UserProfileResponse
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var mainViewModel: MainViewModel

    private val adapter: MainActivityAdapter by lazy {
        MainActivityAdapter()
    }

    private val newsList: MutableList<Article> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInjection(App.graph)
        initRecyclerView()
        initViewModel()
        observeViewModel()
        fetchData()

        v("TOKEN : ", NgampoozApi.token)
    }

    private fun fetchData() {
        mainViewModel.getNewsByDomain("wsj.com,nytimes.com")
        mainViewModel.getProfile()
    }

    private fun initInjection(app: ApplicationComponent) {
        app.plus(MainActivityModule(this)).injectTo(this)
    }

    private fun initRecyclerView() {
        rvNews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvNews.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        rvNews.adapter = adapter
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
    }

    private fun observeViewModel() {
        mainViewModel.getNewsByDomainLiveData.observe(this, Observer {
            handleGetNewsByDomainResponse(it)
        })

        mainViewModel.getProfileLiveData.observe(this, Observer {
            handleGetProfileResponse(it)
        })

        mainViewModel.getError.observe(this, Observer {
            handleErrorResponse(it)
        })
    }

    private fun handleErrorResponse(error: String?) {
        e("ERROR : ", error)
    }

    private fun handleGetProfileResponse(data: UserProfileResponse?) {
        e("PROFILE : ", data.toString())
    }

    private fun handleGetNewsByDomainResponse(data: NewsResponse?) {
        newsList.clear()
        newsList.addAll(data?.articles as MutableList<Article>)
        adapter.setItems(newsList)
    }
}
package com.medleyone.news.home.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medleyone.news.R
import com.medleyone.news.home.view.adapters.ArticleListAdapter
import com.medleyone.news.home.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: HomeViewModel
    var adapter = ArticleListAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        rvTopHeadlines.layoutManager = LinearLayoutManager(this)
        rvTopHeadlines.adapter = adapter

        srlTopHeadlines.setOnRefreshListener {

            viewModel.fetchTopHeadlines()
            srlTopHeadlines.isRefreshing = false

        }

        showLoading()
        viewModel.getTopHeadlines().observe(this, Observer { articles ->

            hideLoading()

            articles?.let {

                adapter.setArticles(articles)

            }

        })

    }

    private fun showLoading() {
        rvTopHeadlines.isEnabled = false
        pbTopHeadlines.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        rvTopHeadlines.isEnabled = true
        pbTopHeadlines.visibility = View.GONE
    }

}

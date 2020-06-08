package com.medleyone.news.home.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medleyone.news.R
import com.medleyone.news.home.view.adapters.ArticleListAdapter
import com.medleyone.news.home.viewModel.HomeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: HomeViewModel
    var adapter = ArticleListAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        recyclerView = findViewById(R.id.rvTopHeadlines)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getTopHeadlines().observe(this, Observer { articles ->

            articles?.let {

                adapter.setArticles(articles)

            }

        })

    }
}

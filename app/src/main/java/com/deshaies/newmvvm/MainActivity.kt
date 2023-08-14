package com.deshaies.newmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deshaies.newmvvm.adapter.NewsAdapter
import com.deshaies.newmvvm.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        newsAdapter = NewsAdapter()
        recyclerView.adapter = newsAdapter

        newsViewModel.newsLiveData.observe(this) { news ->
            newsAdapter.updateData(news)
        }

        newsViewModel.fetchNews()
    }
}

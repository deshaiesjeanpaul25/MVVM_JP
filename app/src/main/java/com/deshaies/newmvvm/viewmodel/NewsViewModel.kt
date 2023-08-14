package com.deshaies.newmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deshaies.newmvvm.network.NewsRepository
import com.deshaies.newmvvm.data.Articles
import com.deshaies.newmvvm.data.NewsApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel() {

    private val _newsLiveData = MutableLiveData<List<Articles>>()
    val newsLiveData: MutableLiveData<List<Articles>> = _newsLiveData

        fun fetchNews() {
            viewModelScope.launch {
                val response = repository.getTopHeadlineNews()

                if (response.isSuccessful) {
                    newsLiveData.postValue(response.body()?.articles)
                } else {
                    // display error
                }
            }
        }
    }

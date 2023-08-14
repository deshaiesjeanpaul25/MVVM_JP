package com.deshaies.newmvvm.network

import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val service : NewsService
) {
    @Inject
    suspend fun getTopHeadlineNews() = service.getTopHeadlines()
}

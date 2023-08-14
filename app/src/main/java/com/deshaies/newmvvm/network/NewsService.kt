package com.deshaies.newmvvm.network

import com.deshaies.newmvvm.data.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    // https://newsapi.org/v2/top-headlines?country=us&apiKey=10166a5bf81947efa494005bf4868699

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        countryCode: String = "us",
        @Query("apiKey")
        apiKey : String = "10166a5bf81947efa494005bf4868699"
    ) : Response<NewsApiResponse>
}

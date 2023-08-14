package com.deshaies.newmvvm.data

import com.google.gson.annotations.SerializedName


data class NewsApiResponse (

  @SerializedName("status"       ) var status       : String?             = null,
  @SerializedName("totalResults" ) var totalResults : Int?                = null,
  @SerializedName("articles"     ) var articles     : MutableList<Articles> = arrayListOf()

)
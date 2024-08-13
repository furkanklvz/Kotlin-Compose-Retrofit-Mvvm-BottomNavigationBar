package com.klavs.bottomnavigationbar.service

import com.google.gson.GsonBuilder
import com.klavs.bottomnavigationbar.model.ListedKriptoModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KriptoAPIService {
    private
    const val BASE_URL = "https://raw.githubusercontent.com/"

    val api: KriptoAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(KriptoAPI::class.java)
    }
}
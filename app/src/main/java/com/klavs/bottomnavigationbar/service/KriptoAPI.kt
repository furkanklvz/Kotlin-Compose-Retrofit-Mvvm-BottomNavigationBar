package com.klavs.bottomnavigationbar.service

import com.klavs.bottomnavigationbar.model.ListedKriptoModel
import retrofit2.Response
import retrofit2.http.GET

interface KriptoAPI {
    //https://raw.githubusercontent.com/atilsamancioglu/IA32-CryptoComposeData/main/cryptolist.json

    @GET("atilsamancioglu/IA32-CryptoComposeData/main/cryptolist.json")
    suspend fun GetCyrptoList(): List<ListedKriptoModel>
}
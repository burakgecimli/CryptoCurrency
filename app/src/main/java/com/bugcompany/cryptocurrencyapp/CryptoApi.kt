package com.bugcompany.cryptocurrencyapp

import retrofit2.Call
import retrofit2.http.GET

interface CryptoApi {

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")

    fun getData():Call<List<CryptoModel>>

}
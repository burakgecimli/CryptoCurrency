package com.bugcompany.cryptocurrencyapp

import com.google.gson.annotations.SerializedName


data class CryptoModel(
    @SerializedName("currency") val currency: String,
    @SerializedName("price") val price: String) {

}
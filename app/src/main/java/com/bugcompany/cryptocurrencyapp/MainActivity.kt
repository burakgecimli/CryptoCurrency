package com.bugcompany.cryptocurrencyapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bugcompany.cryptocurrencyapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var cryptoList: ArrayList<CryptoModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loaoData()

    }
    fun loaoData() {
        val retrofit = Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(CryptoApi::class.java)

        val call = service.getData()

        call.enqueue(object : Callback<List<CryptoModel>> {
            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { crytoModel ->
                        //  cryptoList=ArrayList(crytoModel)
                        cryptoList = response.body() as ArrayList<CryptoModel>
                        binding.rv.setHasFixedSize(true)
                        binding.rv.adapter = Adapter(this@MainActivity, cryptoList!!)
                        binding.rv.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }

            }

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }













    }





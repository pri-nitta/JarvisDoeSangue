package com.jarvis.jarvisdoesangue
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {
        fun RetrofitConfig(s: String): Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
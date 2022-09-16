package com.jarvis.jarvisdoesangue.API

import com.jarvis.jarvisdoesangue.model.CEP
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{CEP}/json/")
    fun getCEP(@Path("CEP") CEP: String): Call<CEP>
}
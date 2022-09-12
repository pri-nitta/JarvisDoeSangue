package com.jarvis.jarvisdoesangue

import retrofit2.Call
import com.jarvis.jarvisdoesangue.model.Cep
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {
    @GET("{cepInserido}/json/")
    fun buscarCEP(
        @Path("cepInserido") cep: String
    ): Call<Cep>
}
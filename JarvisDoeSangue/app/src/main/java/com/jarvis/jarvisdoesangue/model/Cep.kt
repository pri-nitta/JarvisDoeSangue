package com.jarvis.jarvisdoesangue.model
import com.google.gson.annotations.SerializedName

class Cep (
    @SerializedName("logradouro") val rua: String,
    @SerializedName("bairro") val bairro: String,
    @SerializedName("localidade") val cidade: String,
    @SerializedName("uf") val uf: String
)
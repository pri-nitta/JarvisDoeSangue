package com.jarvis.jarvisdoesangue

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.jarvis.jarvisdoesangue.databinding.FragmentAddressBinding
import com.jarvis.jarvisdoesangue.model.Cep
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class AddressFragment : Fragment() {

    private lateinit var binding: FragmentAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_address, container, false
        )

        configureComponents()
        return binding.root
    }

    private fun configureComponents(){
        binding.btnRegister.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_addressFragment_to_confirmationFragment)
        }
        binding.apply {
            val cep = zipCodeField.text.toString()
            if (cep.isNotEmpty()){
                buscarCep(cep)
            }else{
                zipCode.error = "Digite um CEP válido"
            }
        }
    }

    private fun buscarCep(cep: String){
        val retrofitClient = Network.RetrofitConfig("https://viacep.com.br/ws/")
        val servico = retrofitClient.create(CepService::class.java)
        val chamada = servico.buscarCEP(cep)
        chamada.enqueue(
            object: Callback<Cep>, retrofit2.Callback<Cep> {
                override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                    val endereco = response.body()
                    endereco?.let {
                            binding.apply{
                                streetField.setText(it.rua)
                                neighbourhoodField.setText(it.bairro)
                                cityField.setText(it.cidade)
                                stateField.setText(it.uf)
                            }
                    }
                }
                override fun onFailure(call: Call<Cep>, t: Throwable) {
                    Log.d("TAG", "Não encontrado")
                }
            }
        )
    }


}
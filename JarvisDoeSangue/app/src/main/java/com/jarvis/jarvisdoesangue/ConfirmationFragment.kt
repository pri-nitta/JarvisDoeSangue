package com.jarvis.jarvisdoesangue

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.jarvis.jarvisdoesangue.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment() {

    private lateinit var binding: FragmentConfirmationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_confirmation, container, false
        )

        persistenceData()
        configureComponents()
        return binding.root
    }

    private fun configureComponents() {
        binding.apply {
            btnBack.setOnClickListener{
                it.findNavController().navigate(R.id.menuFragment)
            }
            btnEdit.setOnClickListener {
                it.findNavController().navigate(R.id.action_confirmationFragment_to_personalDataFragment)
            }
        }
    }

    private fun persistenceData(){
        val personalDataPersistence = activity?.getSharedPreferences("personalData", Context.MODE_PRIVATE)
        val addressPersistence = activity?.getSharedPreferences("address", Context.MODE_PRIVATE)

        binding.apply {
            nameData.text = personalDataPersistence?.getString("nome", "")
            emailData.text = personalDataPersistence?.getString("email", "")
            cpfData.text = personalDataPersistence?.getString("cpf","")
            birthdateData.text = personalDataPersistence?.getString("dataNascimento", "")
            maritalData.text = personalDataPersistence?.getString("estadoCivil", "")
            weightData.text = personalDataPersistence?.getString("peso", "")
            heightData.text = personalDataPersistence?.getString("altura", "")
            bloodTypeData.text = personalDataPersistence?.getString("tipoSanguineo", "")

            telephoneData.text = addressPersistence?.getString("telefone", "")
            zipcodeData.text = addressPersistence?.getString("cep", "")
            streetData.text = addressPersistence?.getString("logradouro", "")
            numberData.text = addressPersistence?.getString("numero", "")
            additionalDataData.text = addressPersistence?.getString("complemento", "")
            neighbourhoodData.text = addressPersistence?.getString("bairro", "")
            cityData.text = addressPersistence?.getString("cidade", "")
            stateData.text = addressPersistence?.getString("estado", "")

        }
    }


}
package com.jarvis.jarvisdoesangue

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.jarvis.jarvisdoesangue.databinding.FragmentPersonalDataBinding

class PersonalDataFragment : Fragment() {

    private lateinit var binding: FragmentPersonalDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_personal_data, container, false)

        configureComponents()
        return binding.root
    }


    private fun configureComponents(){
        binding.btnNext.setOnClickListener {
            it.findNavController().navigate(R.id.action_personalDataFragment_to_addressFragment)

            val personalDataPersistence =
                activity?.getSharedPreferences("personalData", Context.MODE_PRIVATE)
            val editor = personalDataPersistence?.edit()

            editor?.putString("nome", binding.nameField.text.toString())
            editor?.putString("email", binding.emailField.text.toString())
            editor?.putString("senha", binding.passwordField.text.toString())
            editor?.putString("cpf", binding.cpfField.text.toString())
            editor?.putString("dataNascimento", binding.birthdateField.text.toString())
            editor?.putString("estadoCivil", binding.maritalStatusField.text.toString())
            editor?.putString("peso", binding.weightField.text.toString())
            editor?.putString("altura", binding.heightField.text.toString())
            editor?.putString("tipoSanguineo", binding.bloodTypeField.text.toString())
            editor?.apply()

            Toast.makeText(context, getString(R.string.personal_data_register), Toast.LENGTH_SHORT).show()
        }


    }

}
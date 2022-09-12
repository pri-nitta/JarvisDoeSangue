package com.jarvis.jarvisdoesangue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jarvis.jarvisdoesangue.databinding.FragmentPersonalDataBinding

class PersonalDataFragment : Fragment() {

    private lateinit var binding: FragmentPersonalDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_personal_data, container, false)

        return binding.root
    }

}
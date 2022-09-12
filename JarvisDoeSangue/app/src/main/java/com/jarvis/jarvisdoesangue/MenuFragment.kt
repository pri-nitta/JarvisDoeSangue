package com.jarvis.jarvisdoesangue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.jarvis.jarvisdoesangue.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)

        configureComponents()
        return binding.root
    }


    private fun configureComponents() {
        binding.buttonSecond.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_menuFragment_to_personalDataFragment)
        }

    }
}
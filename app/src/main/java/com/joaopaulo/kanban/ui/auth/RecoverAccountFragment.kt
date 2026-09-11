package com.joaopaulo.kanban.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.joaopaulo.kanban.R
import com.joaopaulo.kanban.databinding.FragmentRecoverAccountBinding
import com.joaopaulo.kanban.databinding.FragmentRegisterBinding
import com.joaopaulo.kanban.util.initToolbar

class RecoverAccountFragment : Fragment() {
    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }
    private fun initListener(){
        binding.botaoenviar2.setOnClickListener {
            validardata()
        }
    }
    private fun validardata() {
        val email = binding.edittextemail2.text.toString().trim()

        if (email.isNotBlank()) {
            if (email.isNotBlank()) {
                Toast.makeText(requireContext(), "Tudo Certo!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Preencha seu E-mail!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}
package com.joaopaulo.kanban.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.joaopaulo.kanban.R
import com.joaopaulo.kanban.databinding.FragmentLoginBinding
import com.joaopaulo.kanban.databinding.FragmentSplashBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }
    private fun initListener(){
        binding.botaologin.setOnClickListener {
            validarData()
        }
        binding.criarconta.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.recuperarconta.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
        }
    }
    private fun validarData(){
        val email = binding.digiteemail.text.toString().trim()
        val senha = binding.digitesenha.text.toString().trim()
        if (email.isNotBlank()){
            if(senha.isNotBlank()){
                findNavController().navigate(R.id.action_global_homeFragment)
            }else{
                Toast.makeText(requireContext(),"Preencha sua Senha!", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(),"Preencha seu E-mail!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}
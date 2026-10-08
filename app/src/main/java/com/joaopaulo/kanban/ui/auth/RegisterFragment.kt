package com.joaopaulo.kanban.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.joaopaulo.kanban.R
import com.joaopaulo.kanban.databinding.FragmentRegisterBinding
import com.joaopaulo.kanban.databinding.FragmentSplashBinding
import com.joaopaulo.kanban.util.initToolbar
import com.joaopaulo.kanban.util.showBottomSheet


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }
    private fun initListener(){
        binding.botaoenviar.setOnClickListener {
            validarData()
        }
    }
    private fun validarData(){
        val email = binding.edittextemail.text.toString().trim()
        val senha = binding.edittextsenha.text.toString().trim()
        if (email.isNotBlank()){
            if(senha.isNotBlank()){
                Toast.makeText(requireContext(),"Tudo Certo!", Toast.LENGTH_SHORT).show()
            }else{
                showBottomSheet(message = getString(R.string.password_empty_register_fragment))
            }
        }else{
            showBottomSheet(message = getString(R.string.email_empty_register_fragment))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}
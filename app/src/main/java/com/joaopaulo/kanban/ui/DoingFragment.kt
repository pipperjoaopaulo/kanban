package com.joaopaulo.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.joaopaulo.kanban.R
import com.joaopaulo.kanban.databinding.FragmentDoingBinding
import com.joaopaulo.kanban.databinding.FragmentRegisterBinding
import com.joaopaulo.kanban.ui.adapter.TaskAdapter

class DoingFragment : Fragment() {
    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDoingBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()

        initRecyclerViewTask(getTask())
    }
    private fun initListeners(){
        binding.floatingActionButton4.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
        }
    }
    private fun initRecyclerViewTask(taskList: List<Task>){
        taskAdapter = TaskAdapter(requireContext(),taskList)
        binding.recyclerViewTask2.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask2.setHasFixedSize(true)

        binding.recyclerViewTask2.adapter = taskAdapter
    }
    private fun getTask() = listOf(
        Task("5", "Atualizar tela do app",Status.DOING),
        Task("6", "Mudar as informações na tela de login",Status.DOING),
        Task("7", "Mudar funcionalidade do app",Status.DOING),
        Task("8", "Salvar cookies Localmente",Status.DOING),
        Task("9", "Mudar layout da tela de login do app", Status.DOING),

        )
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}
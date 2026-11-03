package com.joaopaulo.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.joaopaulo.kanban.R
import com.joaopaulo.kanban.databinding.FragmentDoneBinding
import com.joaopaulo.kanban.databinding.FragmentRegisterBinding
import com.joaopaulo.kanban.ui.adapter.TaskAdapter

class DoneFragment : Fragment() {
    private var _binding: FragmentDoneBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()

        initRecyclerViewTask(getTask())
    }

    private fun initListeners() {
        binding.floatingActionButton3.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
        }
    }

    private fun initRecyclerViewTask(taskList: List<Task>) {
        taskAdapter = TaskAdapter(requireContext(),taskList){task , option -> optionSelected(task, option)}
        binding.recyclerViewTask3.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask3.setHasFixedSize(true)

        binding.recyclerViewTask3.adapter = taskAdapter
    }
    private fun optionSelected(task:Task, option:Int){
        when(option){
            TaskAdapter.SELECT_REMOVER -> {
                Toast.makeText(requireContext(), "Removendo ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_EDIT -> {
                Toast.makeText(requireContext(), "Editando ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_DETAILS -> {
                Toast.makeText(requireContext(), "Detalhes ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_NEXT -> {
                Toast.makeText(requireContext(), "Próximo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getTask() = listOf(
        Task("10", "Criar uma nova tela pro app",Status. DONE),
        Task("11", "Criar informações na tela de login", Status.DONE),
        Task("12", "Pensar em novas funcionalidade do app", Status.DONE),
        Task("13", "Salvar progresso na nuvem",Status.DONE),
        Task("14", "Recriar layout da tela de login do app",Status.DONE),

        )
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}
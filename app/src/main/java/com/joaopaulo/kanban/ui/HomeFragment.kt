package com.joaopaulo.kanban.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.joaopaulo.kanban.R
import com.joaopaulo.kanban.databinding.FragmentHomeBinding
import com.joaopaulo.kanban.databinding.FragmentRegisterBinding
import com.joaopaulo.kanban.ui.adapter.ViewPagerAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inittabs()
    }
    private fun inittabs() {
        val pageAdapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = pageAdapter
        pageAdapter.addFragment(TodoFragment(),R.string.status_task_todo)
        pageAdapter.addFragment(TodoFragment(),R.string.status_task_doing)
        pageAdapter.addFragment(TodoFragment(),R.string.status_task_done)

        binding.viewPager.offscreenPageLimit=pageAdapter.itemCount

        TabLayoutMediator(binding.tabs1, binding.viewPager){ tab,position ->
            tab.text = getString(pageAdapter.getTitle(position))
        }.attach()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}
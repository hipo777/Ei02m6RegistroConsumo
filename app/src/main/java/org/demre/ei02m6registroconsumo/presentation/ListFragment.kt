package org.demre.ei02m6registroconsumo.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import org.demre.ei02m6registroconsumo.R
import org.demre.ei02m6registroconsumo.databinding.FragmentAddBinding
import org.demre.ei02m6registroconsumo.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    val itemViewModel: ItemsViewModel by activityViewModels()
    val adapter = ItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        initLista()

        return binding.root
    }

    private fun initLista() {
        itemViewModel.getAllItems().observe(viewLifecycleOwner){
        adapter.setData(it)
        }

        binding.recycler.adapter = adapter
    }
}
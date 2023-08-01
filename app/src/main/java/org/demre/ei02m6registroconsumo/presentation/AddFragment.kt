package org.demre.ei02m6registroconsumo.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import org.demre.ei02m6registroconsumo.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    private val viewModel: ItemsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        //Información necesaria para el Number Picker
        val picker = binding.picker
        val minValue = 1
        val maxValue = 100
        val default = 1
        picker.minValue = minValue
        picker.maxValue = maxValue
        picker.value = default

        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.btnGuardar.setOnClickListener {
            val nombre = binding.tvIngreso.text.toString()
            val precio = binding.tvPrecio.text.toString().toInt()
            val cantidad = binding.picker.value

            viewModel.insertItem(nombre, precio, cantidad )
        }
    }
}
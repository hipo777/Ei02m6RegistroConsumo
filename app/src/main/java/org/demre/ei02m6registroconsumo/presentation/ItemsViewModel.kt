package org.demre.ei02m6registroconsumo.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.demre.ei02m6registroconsumo.data.local.DataBase
import org.demre.ei02m6registroconsumo.data.local.Item
import org.demre.ei02m6registroconsumo.data.local.Repositorio

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
        val dao = DataBase.getDatabase(application).getItemDao()
        repositorio = Repositorio(dao)
    }

    fun getAllItems(): LiveData<List<Item>> = repositorio.getItem()

    fun insertItem(nombre: String, precio: Int, cantidad: Int) = viewModelScope.launch {
        val item = Item( nombre, precio, cantidad)
        repositorio.insertItem(item)
    }
    fun calcularTotal(item: List<Item>):String{
        var precioTotal = 0
        for (item in item) {
            precioTotal += item.precio * item.cantidad
        }
        return precioTotal.toString()
    }
}
package org.demre.ei02m6registroconsumo.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.demre.ei02m6registroconsumo.data.local.Item
import org.demre.ei02m6registroconsumo.databinding.ItemRecyclerBinding

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private val listItem = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    fun setData(listaItem:List<Item>){
        this.listItem.clear()
        this.listItem.addAll(listaItem)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    inner class ItemViewHolder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.tvNombreItem.text = item.nombre
            binding.tvPrecioItem.text = "$${item.precio.toString()}"
            binding.tvCantidadItem.text = "Cant. ${item.cantidad.toString()}"
            binding.tvTotal.text = "Tot. ${(item.precio * item.cantidad).toString()}"
        }
    }
}

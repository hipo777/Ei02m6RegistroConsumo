package org.demre.ei02m6registroconsumo.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.demre.ei02m6registroconsumo.data.local.Item
import org.demre.ei02m6registroconsumo.databinding.ItemRecyclerBinding

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var items: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun setData(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.tvNombreItem.text = item.nombre
            binding.tvPrecioItem.text = item.precio.toString()
            binding.tvCantidadItem.text = item.cantidad.toString()
            //binding.tv.text = (item.price * item.quantity).toString()
        }
    }
}

/*
class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private val items = mutableListOf<Item>()

    fun setItems(newItems: List<Item>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size
    class ItemViewHolder(private val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.tvNombreItem.text = item.nombre
            binding.tvPrecioItem.text = "$${item.precio.toString()}"
            binding.tvCantidadItem.text = "Cantidad ${item.cantidad.toString()}"
        }
    }
}
*/
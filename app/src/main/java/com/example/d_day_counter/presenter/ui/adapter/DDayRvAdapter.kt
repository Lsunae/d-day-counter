package com.example.d_day_counter.presenter.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.d_day_counter.databinding.ItemDDayBinding

class DDayRvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var context: Context
    private var items = mutableListOf<String>()
    private var currentRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        currentRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        currentRecyclerView = null
    }

    fun addItems(items: MutableList<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun resetItems() {
        items.clear()
        notifyDataSetChanged()
    }

    fun notifyChange() {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        this.context = parent.context
        return Holder(
            ItemDDayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        settingPosition(holder, position)
    }

    private fun settingPosition(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is Holder) holder.bind()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class Holder(private val binding: ItemDDayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {

        }
    }
}
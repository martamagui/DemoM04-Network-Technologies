package com.example.demom04netwroktechnologies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demom04netwroktechnologies.databinding.ItemTechnologyBinding
import com.example.demom04netwroktechnologies.model.Technology

class TechnologyAdpter :
    ListAdapter<Technology, TechnologyAdpter.ViewHolder>(TechnologyItemCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTechnologyBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val technology =  getItem(position)
        holder.binding.tvName.text = technology.name
        holder.binding.tvDescription.text = technology.description
        
    }

    inner class ViewHolder(val binding: ItemTechnologyBinding) :
        RecyclerView.ViewHolder(binding.root)
}

class TechnologyItemCallBack : DiffUtil.ItemCallback<Technology>() {
    override fun areItemsTheSame(oldItem: Technology, newItem: Technology): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Technology, newItem: Technology): Boolean =
        oldItem.id == newItem.id
}
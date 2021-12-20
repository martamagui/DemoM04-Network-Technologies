package com.example.demom04netwroktechnologies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demom04netwroktechnologies.databinding.ItemImageBinding
import com.example.demom04netwroktechnologies.extension.imageUrl
import com.example.demom04netwroktechnologies.model.Image

class ImageAdapter(private val ImageClickedListener: (Image) -> Unit) : ListAdapter<Image, ImageAdapter.ViewHolder>(ImageItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemImageBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.ivTechOnList.imageUrl(image.imageUrl)
        holder.binding.root.setOnClickListener {
            ImageClickedListener(image)
        }

    }

    inner class ViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)
}


class ImageItemCallback : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean =
        oldItem.id == newItem.id
}
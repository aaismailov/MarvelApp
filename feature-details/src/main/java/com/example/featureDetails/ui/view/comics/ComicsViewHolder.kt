package com.example.featureDetails.ui.view.comics

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coreNetwork.dto.Comics
import com.example.featureDetails.databinding.DetailsItemViewBinding

class ComicsViewHolder(private val binding: DetailsItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Comics) {
        with(binding) {
            name.text = data.title
            description.text = data.description
            Glide.with(image.context)
                .load("${data.thumbnail.path}.${data.thumbnail.extension}")
                .into(binding.image)
        }
    }
}


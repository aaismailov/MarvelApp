package com.example.featureDetails.ui.view.series

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coreNetwork.dto.Series
import com.example.featureDetails.databinding.DetailsItemViewBinding

class SeriesViewHolder(private val binding: DetailsItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Series) {
        with(binding) {
            name.text = data.title
            description.text = data.description
            Glide.with(image.context)
                .load("${data.thumbnail.path}.${data.thumbnail.extension}")
                .into(binding.image)
        }
    }
}


package com.example.featureDetails.ui.view.comics

import androidx.recyclerview.widget.DiffUtil
import com.example.coreNetwork.dto.Comics

object ComicsDiffCallback : DiffUtil.ItemCallback<Comics>() {
    override fun areItemsTheSame(oldItem: Comics, newItem: Comics) =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Comics, newItem: Comics) =
        oldItem == newItem
}
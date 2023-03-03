package com.example.featureDetails.ui.view.series

import androidx.recyclerview.widget.DiffUtil
import com.example.coreNetwork.dto.Series

object SeriesDiffCallback : DiffUtil.ItemCallback<Series>() {
    override fun areItemsTheSame(oldItem: Series, newItem: Series) =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Series, newItem: Series) =
        oldItem == newItem
}
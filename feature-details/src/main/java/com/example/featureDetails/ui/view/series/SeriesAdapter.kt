package com.example.featureDetails.ui.view.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.coreNetwork.dto.Character
import com.example.coreNetwork.dto.Series
import com.example.coreUi.adapter.DataDiffCallback
import com.example.coreUi.adapter.MarvelViewHolder
import com.example.coreui.databinding.ItemViewBinding
import com.example.featureDetails.databinding.DetailsItemViewBinding
import com.example.featureDetails.ui.vm.DetailsViewModel

class SeriesAdapter : ListAdapter<Series, SeriesViewHolder>(
    SeriesDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val binding = DetailsItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SeriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        holder.bind(
            getItem(position)
        )
    }
}

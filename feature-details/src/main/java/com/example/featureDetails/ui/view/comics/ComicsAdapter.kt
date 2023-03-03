package com.example.featureDetails.ui.view.comics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.coreNetwork.dto.Comics
import com.example.featureDetails.databinding.DetailsItemViewBinding

class ComicsAdapter : ListAdapter<Comics, ComicsViewHolder>(
    ComicsDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val binding = DetailsItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ComicsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(
            getItem(position)
        )
    }
}

package com.example.featureFavorite.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coreNetwork.dto.Character
import com.example.coreUi.adapter.DataDiffCallback
import com.example.coreUi.adapter.MarvelViewHolder
import com.example.coreui.databinding.ItemViewBinding
import com.example.featureFavorite.ui.vm.FavoriteViewModel

class FavoriteAdapter(private val viewModel: FavoriteViewModel, private val onClick: (Int) -> Unit) : ListAdapter<Character, MarvelViewHolder>(
    DataDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val marvelViewHolder = MarvelViewHolder(binding, onClick)

        binding.starBtn.setOnClickListener {
            val position = marvelViewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val character = getItem(position)
                viewModel.removeFromFavourite(character)
            }
        }
        return marvelViewHolder
    }

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.bind(
            getItem(position),
            true
        )
    }
}

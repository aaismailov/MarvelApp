package com.example.featureHome.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coreNetwork.dto.Character
import com.example.coreUi.adapter.DataDiffCallback
import com.example.coreUi.adapter.MarvelViewHolder
import com.example.coreui.databinding.ItemViewBinding
import com.example.featureHome.ui.vm.HomeViewModel

class HomeAdapter(private val viewModel: HomeViewModel, private val onClick: (Int) -> Unit) : ListAdapter<Character, MarvelViewHolder>(
    DataDiffCallback
) {
    private var favs: List<Character> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val marvelViewHolder = MarvelViewHolder(binding, onClick)

        binding.starBtn.setOnClickListener {
            val position = marvelViewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val character = getItem(position)
                if (character != null) {
                    val favCharacter = favs.find { it.id == character.id }
                    if (favCharacter != null) {
                        viewModel.removeFromFavourite(character)
                    } else {
                        viewModel.addToFavourite(character)
                    }
                }
            }
        }
        return marvelViewHolder
    }

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.bind(
            getItem(position),
            favs.find { it.id == currentList[position].id } != null
        )
    }

    fun updateFavourites(newFavs: List<Character>) {
        favs = newFavs
        notifyDataSetChanged()
    }
}

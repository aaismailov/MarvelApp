package com.example.coreUi.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coreNetwork.dto.Character
import com.example.coreui.R
import com.example.coreui.databinding.ItemViewBinding

class MarvelViewHolder(private val binding: ItemViewBinding, private val onClick: (Int) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Character, favCharacter: Boolean) {
        with(binding) {
            name.text = data.name
            description.text = data.description
            starBtn.setImageResource(
                if (favCharacter) R.drawable.star_yellow else R.drawable.star
            )
            Glide.with(image.context)
                .load("${data.thumbnail.path}.${data.thumbnail.extension}")
                .into(binding.image)
            binding.recyclerViewCard.setOnClickListener {
                onClick(data.id)
            }
        }
    }
}


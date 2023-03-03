package com.example.coreUi.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.coreNetwork.dto.Character

object DataDiffCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Character, newItem: Character) =
        oldItem == newItem
}
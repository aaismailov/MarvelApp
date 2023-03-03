package com.example.coreLocal.data.room

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.Constants
import com.example.coreNetwork.dto.ThumbNail
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = Constants.DatabaseConstants.TABLE_NAME)
data class CharacterEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @Embedded
    val thumbnail: ThumbNail
)

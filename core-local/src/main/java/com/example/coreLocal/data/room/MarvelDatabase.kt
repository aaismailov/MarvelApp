package com.example.coreLocal.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.Constants

@Database(entities = [CharacterEntity::class], version = Constants.DatabaseConstants.VERSION, exportSchema = false)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao
}
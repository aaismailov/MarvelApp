package com.example.project.dagger.local

import android.content.Context
import androidx.room.Room
import com.example.core.Constants
import com.example.coreDi.scope.AppScope
import com.example.coreLocal.data.room.CharacterDao
import com.example.coreLocal.data.room.MarvelDatabase
import com.example.coreLocal.state.Session
import dagger.Module
import dagger.Provides

@Module
class LocalProvidesModule {

    @AppScope
    @Provides
    fun provideSession(context: Context) = Session(context)

    @AppScope
    @Provides
    fun provideMarvelDatabase(context: Context): MarvelDatabase =
        Room.databaseBuilder(context, MarvelDatabase::class.java, Constants.DatabaseConstants.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @AppScope
    @Provides
    fun provideCharacterDao(marvelDatabase: MarvelDatabase): CharacterDao =
        marvelDatabase.getCharacterDao()
}
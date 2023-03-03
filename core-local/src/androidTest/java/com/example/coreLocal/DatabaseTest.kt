package com.example.coreLocal

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.coreLocal.data.room.CharacterDao
import com.example.coreLocal.data.room.CharacterEntity
import com.example.coreLocal.data.room.CharacterMapper
import com.example.coreLocal.data.room.MarvelDatabase
import com.example.coreNetwork.dto.ThumbNail
import junit.framework.TestCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class LocationRoomDBTest : TestCase() {
    private lateinit var dao: CharacterDao
    private lateinit var db: MarvelDatabase

    private val mockCharacters = listOf(
        CharacterEntity(
            id = 0,
            name = "Hero1",
            description = "Description0",
            thumbnail = ThumbNail("", "")
        ), CharacterEntity(
            id = 1,
            name = "Hero2",
            description = "Description1",
            thumbnail = ThumbNail("", "")
        ), CharacterEntity(
            id = 2,
            name = "Hero3",
            description = "Description2",
            thumbnail = ThumbNail("", "")
        )
    )

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, MarvelDatabase::class.java).build()
        dao = db.getCharacterDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeOneCharacterItem() = runBlocking {
        val item = mockCharacters[0]
        dao.insert(item)

        val allCharacters = dao.getFavCharacters().first()
        Assert.assertEquals(allCharacters.contains(item), true)
    }

    @Test
    @Throws(Exception::class)
    fun writeListOfCharacterItems() = runBlocking {
        mockCharacters.forEach { dao.insert(it) }

        val allCharacters = dao.getFavCharacters().first()

        Assert.assertEquals(mockCharacters, allCharacters)
    }

    @Test
    @Throws(Exception::class)
    fun deleteCharacterItem() = runBlocking {
        val item = mockCharacters[0]
        dao.insert(item)
        dao.delete(item)

        val allCharacters = dao.getFavCharacters().first()
        Assert.assertEquals(allCharacters.contains(item), false)
    }
}

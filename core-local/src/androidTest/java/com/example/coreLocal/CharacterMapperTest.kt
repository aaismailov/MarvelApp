package com.example.coreLocal

import com.example.coreLocal.data.room.CharacterEntity
import com.example.coreLocal.data.room.CharacterMapper
import com.example.coreNetwork.dto.Character
import com.example.coreNetwork.dto.ThumbNail
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MapperTest {
    private lateinit var mapper: CharacterMapper

    private val characterDto = Character(
        id = 0,
        name = "Hero1",
        description = "Description0",
        thumbnail = ThumbNail("", "")
    )

    private val characterEntity = CharacterEntity(
        id = 0,
        name = "Hero1",
        description = "Description0",
        thumbnail = ThumbNail("", "")
    )

    @Before
    fun createMapper() {
        mapper = CharacterMapper()
    }

    @Test
    fun mapDtoToEntityTest(){
        val mappedEntity = mapper.mapDtoToEntity(characterDto)

        assertEquals(mappedEntity, characterEntity)
    }

    @Test
    fun mapEntityToDtoTest(){
        val mappedDto = mapper.mapEntityToDto(characterEntity)

        assertEquals(mappedDto, characterDto)
    }

    @Test
    fun mapListEntityToListDtoTest(){
        val mappedList = mapper.mapListEntityToListDto(listOf(characterEntity, characterEntity))

        assertEquals(mappedList, listOf(characterDto, characterDto))
    }
}

package com.example.coreLocal.data.room

import com.example.coreNetwork.dto.Character

class CharacterMapper {

    fun mapDtoToEntity(character: Character) = CharacterEntity(
        id = character.id,
        name = character.name,
        description = character.description,
        thumbnail = character.thumbnail
    )

    fun mapEntityToDto(characterEntity: CharacterEntity) = Character(
        id = characterEntity.id,
        name = characterEntity.name,
        description = characterEntity.description,
        thumbnail = characterEntity.thumbnail
    )

    fun mapListEntityToListDto(list: List<CharacterEntity>) = list.map {
        mapEntityToDto(it)
    }
}
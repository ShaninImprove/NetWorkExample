package com.example.networkexample.domain.mappers

import com.example.networkexample.data.database.entities.SimpleCharacterEntity
import com.example.networkexample.data.network.model.SimpleCharacterApiModel
import com.example.networkexample.domain.model.Character

object SimpleCharacterMapper {

    fun mapApiToDomain(source: SimpleCharacterApiModel) = Character(
        source.id,
        source.name
    )

    fun mapDomainToDb(source: Character) = SimpleCharacterEntity(
        source.id,
        source.name
    )

    fun mapDbToDomain(source: SimpleCharacterEntity) = Character(
        source.id,
        source.name
    )
}
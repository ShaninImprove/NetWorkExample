package com.example.networkexample.domain.mappers

import com.example.networkexample.data.model.SimpleCharacterApiModel
import com.example.networkexample.domain.model.Character

class SimpleCharacterMapper {

    companion object {

        fun mapApiToDomain(source: SimpleCharacterApiModel) = Character(
            source.id,
            source.name
        )
    }
}
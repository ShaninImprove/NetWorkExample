package com.example.networkexample.domain.mappers

import com.example.networkexample.data.model.CharacterApiModel
import com.example.networkexample.domain.model.CharacterInfo

class CharacterInfoMapper {
    companion object {
        fun mapApiToDomain(source: CharacterApiModel) = CharacterInfo(
            source.properties.name,
            source.properties.birthYear,
            source.properties.gender
        )
    }
}
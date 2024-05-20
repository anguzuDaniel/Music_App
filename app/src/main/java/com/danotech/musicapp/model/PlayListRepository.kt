package com.danotech.musicapp.model

import kotlinx.coroutines.flow.Flow

class PlayListRepository {
    suspend fun getPlayLists(): Flow<Result<List<PlayList>>> {
        TODO("Not yet implemented")
    }
}
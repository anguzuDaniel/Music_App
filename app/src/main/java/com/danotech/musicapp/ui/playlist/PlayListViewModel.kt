package com.danotech.musicapp.ui.playlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.danotech.musicapp.model.PlayListRepository

class PlayListViewModel(
    private val repository: PlayListRepository
) : ViewModel() {
    val playLists = liveData {
        emitSource(repository.getPlayLists().asLiveData())
    }
}
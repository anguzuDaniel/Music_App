package com.danotech.musicapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.danotech.musicapp.ui.playlist.PlayListViewModel

class PlaylistViewModelFactory(
    private val repository: PlayListRepository
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlayListViewModel(repository) as T
    }
}

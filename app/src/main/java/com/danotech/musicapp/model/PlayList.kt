package com.danotech.musicapp.model

import com.danotech.musicapp.R

data class PlayList(
    val id: String,
    val name: String,
    val category: String,
    val image: Int = R.drawable.playlist
)
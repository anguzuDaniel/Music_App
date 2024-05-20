package com.danotech.musicapp.ui.playlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap

data class Song(
    val title: String,
    val image: ImageBitmap
)

@Composable
fun PlayListScreen(
    songs: List<Song> = emptyList()
) {
    PlayListDetailScreen(songs = songs)
}

@Composable
fun PlayListDetailScreen(
    songs: List<Song>
) {
    LazyColumn {
        items(songs) { song ->
            PlayListItem(title = song.title, image = song.image)
        }
    }
}

@Composable
fun PlayListItem(
    title: String,
    image: ImageBitmap
) {
    Card {
        Row {
            Image(bitmap = image, contentDescription = title)
            Text(text = title)
        }
    }
}
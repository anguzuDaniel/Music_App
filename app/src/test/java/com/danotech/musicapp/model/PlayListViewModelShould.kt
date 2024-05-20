package com.danotech.musicapp.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.danotech.acceptancetests.utils.MainCoroutineScopeRule
import com.danotech.musicapp.ui.playlist.PlayListViewModel
import com.danotech.musicapp.utils.getValueForTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class PlayListViewModelShould {
    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineTestRule = MainCoroutineScopeRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel: PlayListViewModel
    private val repository: PlayListRepository = mock()
    private val playLists = mock<List<PlayList>>()
    private val expected = Result.success(playLists)
    private val exception = RuntimeException("Something went wrong")

    init {
        runBlocking {
            whenever(repository.getPlayLists()).thenReturn(
                flow { emit(expected) }
            )
        }

        viewModel = PlayListViewModel(repository)
    }

    @Test
    fun getPlayListFromRepository() = runTest  {
        val viewModel = mockSuccessfulCase()

        viewModel.playLists.getValueForTest()

        verify(repository, times(1)).getPlayLists()
    }

    @Test
    fun emitErrorWhenReceiveError() {
        runBlocking {
            whenever(repository.getPlayLists()).thenReturn(
                flow { emit(Result.failure(exception)) }
            )
        }

        val viewModel = PlayListViewModel(repository)

        assertEquals(exception, viewModel.playLists.getValueForTest()!!.exceptionOrNull())
    }

    private fun mockSuccessfulCase(): PlayListViewModel {
        runBlocking {
            whenever(repository.getPlayLists()).thenReturn(
                flow { emit(expected) }
            )
        }

        val viewModel = PlayListViewModel(repository)

        viewModel.playLists.getValueForTest()
        return viewModel
    }

    @Test
    fun emitsPlayListsFromRepository() = runTest {
        val viewModel = mockSuccessfulCase()

        assertEquals(expected, viewModel.playLists.getValueForTest())
    }
}
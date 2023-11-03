package com.alhussain.mohammadalhussain_axiomtask_3_nov_2023

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel() {

    private val deque: ArrayDeque<Grid> = ArrayDeque()

    private val grid: MutableList<Grid> = mutableListOf()

    private val _uiState: MutableStateFlow<MutableList<Grid>> = MutableStateFlow(grid)
    val uiState: StateFlow<MutableList<Grid>> = _uiState.asStateFlow()

    init {

        (1..16).forEach {
            grid.add(Grid(it))
        }
    }


    fun performClick(item: Grid) {
        val list = _uiState.value

        val exists = deque.contains(item)

        if (!exists) {
            changeColorToRed(list, item)

            addToDeque(item)

            changeColorToBlue(list, item, deque)
        }

    }

    private fun changeColorToBlue(list: MutableList<Grid>, item: Grid, deque: ArrayDeque<Grid>) {
        if (deque.size > 2) {
            val top = deque.removeLast()


            list.first {
                it.id == top.id
            }.color.value = Color.Blue
        }
    }

    private fun addToDeque(item: Grid) {
        deque.addFirst(item)

    }

    private fun changeColorToRed(list: MutableList<Grid>, item: Grid) {
        list.first {
            item.id == it.id
        }.color.value = Color.Red
    }


}
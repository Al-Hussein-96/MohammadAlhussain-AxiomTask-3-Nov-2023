package com.alhussain.mohammadalhussain_axiomtask_3_nov_2023

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color


class Grid(val id:Int, var color: MutableState<Color> = mutableStateOf(Color.Blue))
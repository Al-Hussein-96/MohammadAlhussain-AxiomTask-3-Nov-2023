package com.alhussain.mohammadalhussain_axiomtask_3_nov_2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alhussain.mohammadalhussain_axiomtask_3_nov_2023.ui.theme.MohammadAlhussainAxiomTask3Nov2023Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MohammadAlhussainAxiomTask3Nov2023Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridLayout()
                }
            }
        }
    }
}

@Composable
fun GridLayout(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    LazyVerticalGrid(modifier = modifier.padding(16.dp), columns = GridCells.Fixed(4)) {
        items(state.value) {
            Box(modifier = Modifier
                .background(it.color.value)
                .aspectRatio(1f)
                .border(1.dp, color = Color.Black)
                .clickable {
                    viewModel.performClick(it)
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MohammadAlhussainAxiomTask3Nov2023Theme {
    }
}
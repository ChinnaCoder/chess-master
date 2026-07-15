package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ui.ChessScreen
import com.example.ui.ChessViewModel
import com.example.ui.screens.GameScreen
import com.example.ui.screens.MenuScreen
import com.example.ui.screens.SavedGamesScreen
import com.example.ui.theme.ChessMasterTheme

class MainActivity : ComponentActivity() {
    private val viewModel: ChessViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChessMasterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        ChessMasterApp(viewModel = viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun ChessMasterApp(viewModel: ChessViewModel) {
    when (viewModel.currentScreen) {
        is ChessScreen.Menu -> MenuScreen(viewModel = viewModel)
        is ChessScreen.Game -> GameScreen(viewModel = viewModel)
        is ChessScreen.SavedGames -> SavedGamesScreen(viewModel = viewModel)
    }
}

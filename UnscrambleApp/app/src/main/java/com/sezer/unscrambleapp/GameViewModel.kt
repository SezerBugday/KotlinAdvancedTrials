package com.sezer.unscrambleapp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
class GameViewModel:ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
}
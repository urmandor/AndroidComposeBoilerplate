package com.resistec.fantasyleague.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.resistec.fantasyleague.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private var _isLoading: Boolean by mutableStateOf(true)
    val isLoading: Boolean
        get() = _isLoading

    fun onEvent(event: HomeEvent) {}
}
package com.resistec.fantasyleague.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.resistec.fantasyleague.navigation.NavigationDestination
import com.resistec.fantasyleague.navigation.Navigator
import com.resistec.fantasyleague.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {
    val TIME_TO_FINISH: Long = 100
    fun onEvent(event: SplashEvent) {
        viewModelScope.launch {
            when (event) {
                is SplashEvent.GotoClientList -> {
                    navigator.navigate(NavigationDestination(Routes.HOME_ROUTE))
                }
            }
        }
    }
}
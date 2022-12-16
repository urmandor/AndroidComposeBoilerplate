package com.resistec.fantasyleague.navigation

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.resistec.fantasyleague.features.home.HomeScreen
import com.resistec.fantasyleague.features.home.HomeViewModel
import com.resistec.fantasyleague.features.splash.SplashScreen
import com.resistec.fantasyleague.features.splash.SplashViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    navigator: Navigator
) {
    LaunchedEffect("navigation") {
        navigator.sharedFlow.onEach {
            navController.navigate(it.route) {
                if (it.previousRouteOverride != null) {
                    popUpTo(it.previousRouteOverride) {
                        inclusive = true
                    }
                }
            }
        }.launchIn(this)
    }

    NavHost(navController = navController, startDestination = Routes.SPLASH_SCREEN_ROUTE ) {
        composable(Routes.SPLASH_SCREEN_ROUTE) {
            val viewModel = hiltViewModel<SplashViewModel>()
            SplashScreen(viewModel = viewModel)
        }
        composable(Routes.HOME_ROUTE) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(viewModel = viewModel)
        }
    }
}
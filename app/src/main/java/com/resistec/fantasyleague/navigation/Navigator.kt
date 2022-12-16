package com.resistec.fantasyleague.navigation

import android.os.Bundle
import androidx.navigation.NavArgument
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Singleton

data class NavigationDestination(val route: String, val previousRouteOverride: String? = null);

@Singleton
class Navigator {
    private val _sharedFlow =
        MutableSharedFlow<NavigationDestination>(extraBufferCapacity = 1)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigate(destination: NavigationDestination) {
        _sharedFlow.tryEmit(destination)
    }

    private fun findRouteWithParam(route: String, arguments: Bundle, param: String): String {
        var newRoute = route
        val enclosedParam = "{$param}"
        if (route.contains(enclosedParam)) {
            val arg = arguments.getString(param)
            if (arg != null) {
                newRoute = newRoute.replace(enclosedParam, arg)
            }
        }
        return newRoute
    }

    fun constructRoute(route: String, arguments: Bundle): String {
        var newRoute = route
        return newRoute
    }
}


package com.resistec.fantasyleague.features.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import com.resistec.fantasyleague.ui.theme.FantasyLeagueTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(viewModel: SplashViewModel) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = "animation") {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 2000,
                easing = {
                    OvershootInterpolator(6f).getInterpolation(it)
                })
        )
        delay(timeMillis = viewModel.TIME_TO_FINISH)
        scale.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = 400,
                easing = {
                    OvershootInterpolator(1f).getInterpolation(it)
                })
        )
        viewModel.onEvent(SplashEvent.GotoClientList)
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Fantasy League", modifier = Modifier.scale(scale.value))
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    FantasyLeagueTheme {

    }
}
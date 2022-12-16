package com.resistec.fantasyleague.features.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CircularProgressIndicator
import com.resistec.fantasyleague.ui.theme.FantasyLeagueTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val isLoading = viewModel.isLoading
    val activity = (LocalContext.current as? Activity)
    BackHandler(enabled = true) {
        activity?.finish()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth(1f)
    ) {
        if (isLoading && activity != null) {
            CircularProgressIndicator()
        } else {
            Text(text = "Home Screen", modifier = Modifier.padding(bottom = 20.dp))
        }
    }
}

@Preview
@Composable
fun PreviewClientScreen() {
//    val viewModel = viewModel<ClientViewModel>()
    FantasyLeagueTheme {
//        ClientScreen(viewModel, onClientClicked = {
//            viewModel.onEvent(ClientEvent.OnClientClicked(it))
//        })
    }
}
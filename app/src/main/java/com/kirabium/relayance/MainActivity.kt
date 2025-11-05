package com.kirabium.relayance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.kirabium.relayance.ui.navigation.RelayanceNavHost
import com.openclassrooms.hexagonal.games.ui.theme.RelayanceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            RelayanceTheme {
                RelayanceNavHost(navHostController = navController)
            }
        }
    }
}
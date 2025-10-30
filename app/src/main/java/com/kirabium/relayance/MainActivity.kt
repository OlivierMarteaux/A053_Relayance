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
//
//            // Observe current backstack entry
//            val currentBackStackEntry by navController.currentBackStackEntryAsState()
//            LaunchedEffect(currentBackStackEntry) {
//                currentBackStackEntry?.destination?.route?.let { route ->
//                    Log.i("OM_TAG", " ${route.uppercase()} SCREEN")
//                }
//            }
            RelayanceTheme {
//        SetStatusBarColor(Color.Transparent)
//                RequestNotificationPermission()
//                getDeviceToken()
                RelayanceNavHost(navHostController = navController)
//                DismissKeyboardOnTapOutside { HomeScreen() }
            }
        }
    }
}
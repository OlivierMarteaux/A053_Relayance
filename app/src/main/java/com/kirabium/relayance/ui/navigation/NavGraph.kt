package com.kirabium.relayance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kirabium.relayance.ui.screens.addScreen.AddScreen
import com.kirabium.relayance.ui.screens.detailScreen.DetailScreen
import com.kirabium.relayance.ui.screens.homeScreen.HomeScreen

/**
 * The main navigation graph for the application.
 *
 * @param navHostController The navigation controller for the application.
 */
@Composable
fun RelayanceNavHost(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        /*_ HOME SCREEN ##############################################################################*/
        composable(route = Screen.Home.route) {
            HomeScreen(
                navigateToDetailScreen = { customerId ->
                    navHostController.navigate(Screen.Detail.route + "/$customerId")
                },
                navigateToAddScreen = { newCustomerId ->
                    navHostController.navigate(Screen.Add.route + "/$newCustomerId")
                },
                sharedViewModel = sharedViewModel
            )
        }/*_ DETAIL SCREEN ###########################################################################*/
        composable(
            route = Screen.Detail.routeWithArgs,
            arguments = Screen.Detail.navArguments
        ){
            DetailScreen(
                navigateBack = { navHostController.navigateUp() },
            )
        }
        /*_ ADD POST SCREEN ##########################################################################*/
        composable(
            route = Screen.Add.routeWithArgs,
            arguments = Screen.Add.navArguments
        ) {
            AddScreen(
                navigateBack = { navHostController.navigateUp() },
                sharedViewModel = sharedViewModel
            )
        }
    }
}
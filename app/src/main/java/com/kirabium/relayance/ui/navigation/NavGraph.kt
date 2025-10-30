package com.kirabium.relayance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kirabium.relayance.domain.model.Customer
import com.kirabium.relayance.ui.screens.detailScreen.DetailScreen
import com.kirabium.relayance.ui.screens.homeScreen.HomeScreen

/**
 * The main navigation graph for the application.
 *
 * @param navHostController The navigation controller for the application.
 */
@Composable
fun RelayanceNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        /*_ HOME SCREEN ##############################################################################*/
        composable(route = Screen.Home.route) {
            HomeScreen(
            )
        }/*_ DETAIL SCREEN ###########################################################################*/
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("customer_id") { type = NavType.IntType })
        ){
//            DetailScreen(
//                onBackClick = { navHostController.navigateUp() },
//                customer = Customer( )
//            )
        }
        /*_ ADD POST SCREEN ##########################################################################*/
        composable(route = Screen.Add.route) {
//            AddScreen(navigateBack = { navHostController.navigateUp() })
        }
    }
}
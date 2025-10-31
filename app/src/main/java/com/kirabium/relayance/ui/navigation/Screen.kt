package com.kirabium.relayance.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * A sealed class that represents the different screens in the application.
 *
 * @property route The route for the screen.
 * @property navArguments The navigation arguments for the screen.
 */
sealed class Screen(
  val route: String,
  val navArguments: List<NamedNavArgument> = emptyList(),
  val routeWithArgs: String = ""
) {
  /**
   * The home screen.
   */
  data object Home : Screen("home")

  /**
   * The detail screen.
   */
  data object Detail : Screen(
    route = "detail",
    navArguments = listOf(navArgument("customer_id") { type = NavType.IntType }),
    routeWithArgs = "detail/{customer_id}"
    )

  /**
   * The add screen.
   */
  data object Add : Screen(
    route = "add",
    navArguments = listOf(navArgument("new_customer_id") { type = NavType.IntType }),
    routeWithArgs = "add/{new_customer_id}"
  )
}
package com.kirabium.relayance.ui.navigation

import androidx.navigation.NamedNavArgument

/**
 * A sealed class that represents the different screens in the application.
 *
 * @property route The route for the screen.
 * @property navArguments The navigation arguments for the screen.
 */
sealed class Screen(
  val route: String,
  val navArguments: List<NamedNavArgument> = emptyList()
) {
  /**
   * The home screen.
   */
  data object Home : Screen("home")

  /**
   * The detail screen.
   */
  data object Detail : Screen("detail/{customer_id}")

  /**
   * The add screen.
   */
  data object Add : Screen("add")

}
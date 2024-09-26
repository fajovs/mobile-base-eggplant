package com.ensias.mobile_basedeggplantcarediseasediagnosis

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androidlead.loginappui.ui.screen.home.HomeScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.homePage, builder = {
        composable(Routes.homePage) {
            HomeScreen(navController)
        }

        composable(Routes.diagnoseHistoryPage) {
            HistoryScreen(navController)
        }

        composable(Routes.plantPage) {
            PlantScreen(navController)
        }

        composable(Routes.resultPage) { backStackEntry ->
            val result = backStackEntry.arguments?.getString("result") ?: ""

            ResultScreen(navController, result)
        }

        composable(Routes.itemtPage) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull() ?: 0
            ItemScreen(navController, itemId)
        }



    })


}
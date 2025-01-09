package com.example.bininfo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bininfo.presentation.screens.bininput.BinInputScreen
import com.example.bininfo.presentation.screens.history.HistoryScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "bin_input") {
        composable("bin_input") { BinInputScreen(navController = navController) }
        composable("history") { HistoryScreen(navController = navController) }
    }
}

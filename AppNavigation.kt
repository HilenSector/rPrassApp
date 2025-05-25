package com.professorsagi.rprassapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
// Corrected import paths for feature screens
import com.professorsagi.rprassapp.features.auth.view.LoginScreen
import com.professorsagi.rprassapp.features.auth.view.RegisterScreen
import com.professorsagi.rprassapp.features.profile.view.HomeScreen // Assuming HomeScreen is part of profile features for now

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // Start destination is Login
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        // Add other destinations later (e.g., Payment, Collaboration, Education)
    }
}


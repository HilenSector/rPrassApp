package com.professorsagi.rprassapp.navigation

// Defines the different navigation destinations in the app
sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Register : Screen("register_screen")
    object Home : Screen("home_screen") // Placeholder for main app content after login
    // Add other screens like PaymentScreen later
}


package com.professorsagi.rprassapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.professorsagi.rprassapp.navigation.AppNavigation // Import AppNavigation
import com.professorsagi.rprassapp.ui.theme.RPrassAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // For Hilt
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RPrassAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Set up Navigation Host here
                    AppNavigation()
                }
            }
        }
    }
}

// Removed Greeting composable as it's no longer needed here


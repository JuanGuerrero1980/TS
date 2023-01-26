package com.jg.ts.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jg.ts.presentation.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main" ) {
                        composable("main") {

                            HomeScreen(name = "Android")


                        }
                    }
                
            }

    }
}
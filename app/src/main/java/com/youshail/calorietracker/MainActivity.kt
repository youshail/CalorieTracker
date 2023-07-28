package com.youshail.calorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.youshail.calorietracker.navigation.navigate

import com.youshail.calorietracker.ui.theme.CaloryTrackerTheme
import com.youshail.core.navigation.Route
import com.youshail.onboarding_presentation.gender.GenderScreen
import com.youshail.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME
                ){
                    composable(Route.WELCOME){
                        WelcomeScreen(onNavigate = navController::navigate)
                    }

                    composable(Route.GENDER){
                        GenderScreen(onNavigate = navController::navigate)
                    }

                    composable(Route.AGE){

                    }
                    composable(Route.HEIGHT){

                    }
                    composable(Route.WEIGHT){

                    }
                    composable(Route.NUTRIENT_GOAL){

                    }
                    composable(Route.ACTIVITY){

                    }
                    composable(Route.GOAL){

                    }
                    composable(Route.TRACKER_OVERVIEW){

                    }
                    composable(Route.SEARCH){

                    }
                }
            }
        }
    }
}
package com.youshail.calorietracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.youshail.calorietracker.navigation.navigate

import com.youshail.calorietracker.ui.theme.CaloryTrackerTheme
import com.youshail.core.navigation.Route
import com.youshail.onboarding_presentation.activity.ActivityScreen
import com.youshail.onboarding_presentation.age.AgeScreen
import com.youshail.onboarding_presentation.gender.GenderScreen
import com.youshail.onboarding_presentation.goal.GoaScreen
import com.youshail.onboarding_presentation.height.HeightScreen
import com.youshail.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.youshail.onboarding_presentation.weight.WeightScreen
import com.youshail.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
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
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.HEIGHT){
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate =navController::navigate
                            )
                        }
                        composable(Route.WEIGHT){
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
                        }
                        composable(Route.ACTIVITY){
                            ActivityScreen(onNavigate = navController::navigate)
                        }

                        composable(Route.GOAL){
                            GoaScreen(onNavigate = navController::navigate)
                        }

                        composable(Route.NUTRIENT_GOAL){
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                onNavigate = navController::navigate
                            )
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
}
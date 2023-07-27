package com.youshail.calorietracker.ui.navigation

import androidx.navigation.NavController
import com.youshail.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate){
  this.navigate(event.route)
}
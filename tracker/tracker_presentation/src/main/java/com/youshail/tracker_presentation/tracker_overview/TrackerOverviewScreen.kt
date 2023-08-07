package com.youshail.tracker_presentation.tracker_overview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.youshail.core.util.UiEvent
import com.youshail.core_ui.LocalSpacing
import com.youshail.tracker_presentation.tracker_overview.components.NutrientsHeader


@Composable
fun TrackerOverviewScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel()
){
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = spacing.spaceSmall)){
        item { 
            NutrientsHeader(state = state)
        }
    }
}
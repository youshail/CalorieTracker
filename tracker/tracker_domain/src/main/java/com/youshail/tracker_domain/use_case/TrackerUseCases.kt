package com.youshail.tracker_domain.use_case

data class TrackerUseCases(
    val searchFood: SearchFood,
    val trackFood: TrackFood,
    val getFoodsForDate: GetFoodsForDate,
    val deleteTrackedFood: DeleteTrackedFood,
    val calculateMealNutrients: CalculateMealNutrients
)

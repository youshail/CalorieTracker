package com.youshail.calorietracker.repository

import com.youshail.tracker_domain.model.TrackableFood
import com.youshail.tracker_domain.model.TrackedFood
import com.youshail.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import java.time.LocalDate
import kotlin.random.Random

class TrackerRepositoryFake : TrackerRepository {

    var shouldReturnError = false
    private val trackedFood = mutableListOf<TrackedFood>()
    var searchResults = listOf<TrackableFood>()

    private val  getFoodForDateFlow =
        MutableSharedFlow<List<TrackedFood>>(replay = 1)
    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return if (shouldReturnError) {
            Result.failure(Throwable())
        } else {
            Result.success(searchResults)
        }
    }

    override suspend fun insertTrackedFood(food: TrackedFood) {
        trackedFood.add(food.copy( id = Random.nextInt()))
        getFoodForDateFlow.emit(trackedFood)
    }

    override suspend fun deleteTrackedFood(food: TrackedFood) {
        trackedFood.remove(food)
        getFoodForDateFlow.emit(trackedFood)
    }

    override fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>> {
        return  getFoodForDateFlow
    }
}
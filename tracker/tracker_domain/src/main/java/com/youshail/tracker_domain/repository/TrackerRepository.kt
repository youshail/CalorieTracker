package com.youshail.tracker_domain.repository

import com.youshail.tracker_domain.model.TrackableFood
import com.youshail.tracker_domain.model.TrackedFood
import com.youshail.tracker_domain.use_case.TrackFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)

    suspend fun deleteTrackedFood(food: TrackedFood)

    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}
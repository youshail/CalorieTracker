package com.youshail.tracker_domain.di

import com.youshail.core.domain.preferences.Preferences
import com.youshail.tracker_domain.repository.TrackerRepository
import com.youshail.tracker_domain.use_case.CalculateMealNutrients
import com.youshail.tracker_domain.use_case.DeleteTrackedFood
import com.youshail.tracker_domain.use_case.GetFoodsForDate
import com.youshail.tracker_domain.use_case.SearchFood
import com.youshail.tracker_domain.use_case.TrackFood
import com.youshail.tracker_domain.use_case.TrackerUseCases
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
class TrackerDomainModule {

    @ViewModelScoped
    @Singleton
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases{
        return  TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)

        )
    }
}
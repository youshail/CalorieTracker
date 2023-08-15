package com.youshail.tracker_domain.use_case

import com.google.common.truth.Truth.assertThat
import com.youshail.core.domain.model.ActivityLevel
import com.youshail.core.domain.model.Gender
import com.youshail.core.domain.model.GoalType
import com.youshail.core.domain.model.UserInfo
import com.youshail.core.domain.preferences.Preferences
import com.youshail.tracker_domain.model.MealType
import com.youshail.tracker_domain.model.TrackedFood
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.random.Random

class CalculateMealNutrientsTest {

    private lateinit var calculateMealNutrients: CalculateMealNutrients


    @Before
    fun setUp(){
        val preferences = mockk<Preferences>(relaxed = true)
        every { preferences.loadUserInfo() } returns UserInfo(
            gender = Gender.Male,
            age = 32,
            height = 172,
            weight = 70f,
            activityLevel = ActivityLevel.Medium,
            goalType = GoalType.KeepWeight,
            carbRatio = 0.4f,
            proteinRatio = 0.3f,
            fatRatio = 0.3f,
        )
        calculateMealNutrients = CalculateMealNutrients(preferences)
    }

    @Test
    fun `Calories for breakfast properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf("breakfast", "lunch", "dinner" , "snack").random()
                ),
                imageUrl = null,
                date = LocalDate.now(),
                calories = Random.nextInt(200),
                amount = 100
            )
        }

         val result = calculateMealNutrients(trackedFoods)
         val breakfastCalories = result.mealNutrients.values
             .filter { it.mealType is MealType.Breakfast }
             .sumOf { it.calories }


        val breakfastExpectedCalories = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.calories }



        assertThat(breakfastCalories).isEqualTo(breakfastExpectedCalories)

    }

    @Test
    fun `carbs for breakfast properly calculated`(){
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf("breakfast", "lunch", "dinner" , "snack").random()
                ),
                imageUrl = null,
                date = LocalDate.now(),
                calories = Random.nextInt(200),
                amount = 100
            )
        }

        val result = calculateMealNutrients(trackedFoods)
        val dinnerCarbs = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }


        val expectedCarbs = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }


        assertThat(dinnerCarbs).isEqualTo(expectedCarbs)

    }

}
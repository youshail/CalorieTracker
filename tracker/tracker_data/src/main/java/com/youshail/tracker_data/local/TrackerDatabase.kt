package com.youshail.tracker_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.youshail.tracker_data.local.entity.TrackedFoodEntity

@Database(
    entities = [TrackedFoodEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TrackerDatabase: RoomDatabase(){

    abstract val dao: TrackerDao
}
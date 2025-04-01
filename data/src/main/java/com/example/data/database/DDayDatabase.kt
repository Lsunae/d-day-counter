package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.DDayDao
import com.example.data.entity.DDayEntity

@Database(entities = [DDayEntity::class], version = 1)
abstract class DDayDatabase : RoomDatabase() {
    abstract fun dDayDao(): DDayDao
}
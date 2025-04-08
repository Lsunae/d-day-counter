package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.entity.DDayEntity

@Dao
interface DDayDao {
    @Query("SELECT * FROM dday_table")
    suspend fun getAllDDays(): List<DDayEntity>

    @Insert
    suspend fun insertDDay(dDay: DDayEntity)

    @Delete
    suspend fun deleteDDay(dDay: DDayEntity)
}
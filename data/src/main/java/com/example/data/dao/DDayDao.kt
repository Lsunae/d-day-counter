package com.example.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.entity.DDayEntity

@Dao
interface DDayDao {
    @Query("SELECT * FROM dday_table")
    suspend fun getAll(): List<DDayEntity>

    @Insert
    suspend fun insert(dDay: DDayEntity)

    @Delete
    suspend fun delete(dDay: DDayEntity)
}
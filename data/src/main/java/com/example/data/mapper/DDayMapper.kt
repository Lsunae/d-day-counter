package com.example.data.mapper

import com.example.data.entity.DDayEntity
import com.example.domain.model.DDay

fun DDayEntity.toDomain(): DDay = DDay(id, title, date)
fun DDay.toEntity(): DDayEntity = DDayEntity(id, title, date)
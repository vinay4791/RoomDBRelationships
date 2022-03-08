package com.example.roomrelationships.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomrelationships.entities.Director
import com.example.roomrelationships.entities.School

data class SchoolAndDirector(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)




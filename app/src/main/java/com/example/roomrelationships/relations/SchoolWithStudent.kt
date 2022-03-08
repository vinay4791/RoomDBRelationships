package com.example.roomrelationships.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomrelationships.entities.School
import com.example.roomrelationships.entities.Student


data class SchoolWithStudent(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val student: List<Student>
)
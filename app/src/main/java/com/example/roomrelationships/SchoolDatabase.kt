package com.example.roomrelationships

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomrelationships.entities.Director
import com.example.roomrelationships.entities.School
import com.example.roomrelationships.entities.Student
import com.example.roomrelationships.entities.Subject
import com.example.roomrelationships.relations.StudentSubjectCrossRef

@Database(
    entities = [Director::class,
        School::class,
        Student::class,
        Subject::class,
        StudentSubjectCrossRef::class],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}
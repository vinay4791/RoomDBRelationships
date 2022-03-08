package com.example.roomrelationships

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.roomrelationships.entities.Director
import com.example.roomrelationships.entities.School
import com.example.roomrelationships.entities.Student
import com.example.roomrelationships.entities.Subject
import com.example.roomrelationships.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director("vinay", "Fisat"),
            Director("Matt", "Rajagiri"),
            Director("John", "tocH")
        )

        val schools = listOf(
            School("Fisat"),
            School("Rajagiri"),
            School("tocH")
        )

        val subjects = listOf(
            Subject("Subject1"),
            Subject("Subject2"),
            Subject("Subject3"),
            Subject("Subject4"),
            Subject("Subject5")
        )

        val students = listOf(
            Student("Resmi", 2, "Fisat"),
            Student("Shalu", 5, "Rajagiri"),
            Student("Fahad", 8, "Fisat"),
            Student("Vivek", 1, "Fisat"),
            Student("Jacob", 2, "tocH")
        )

        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Resmi","Subject1"),
            StudentSubjectCrossRef("Resmi","Subject2"),
            StudentSubjectCrossRef("Resmi","Subject3"),
            StudentSubjectCrossRef("Shalu","Subject2"),
            StudentSubjectCrossRef("Shalu","Subject3"),
            StudentSubjectCrossRef("Shalu","Subject4"),
            StudentSubjectCrossRef("Fahad","Subject5"),
            StudentSubjectCrossRef("Vivek","Subject5"),

            )

        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }


            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolName("Rajagiri")

            Log.d("vinay",schoolWithDirector.toString())

        }

    }
}
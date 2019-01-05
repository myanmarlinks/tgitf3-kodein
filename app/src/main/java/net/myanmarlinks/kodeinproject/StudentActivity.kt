package net.myanmarlinks.kodeinproject

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_student.*
import net.myanmarlinks.kodeinproject.model.Student
import net.myanmarlinks.kodeinproject.viewmodel.StudentViewModel
import net.myanmarlinks.kodeinproject.viewmodel.StudentsViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class StudentActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()

    private val studentViewModelFactory: StudentsViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        setSupportActionBar(toolbar)

        val viewModel = ViewModelProviders.of(this, studentViewModelFactory)
            .get(StudentViewModel::class.java)
        val student = Student(1, "Aung Aung", "Pazuntaung")
        viewModel.addStudent(student)
        viewModel.getStudents().observe(this, Observer {
            d("STUDENTS", it.toString())
        })

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}

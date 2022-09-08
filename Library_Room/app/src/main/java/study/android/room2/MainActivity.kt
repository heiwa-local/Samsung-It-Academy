package study.android.room2


import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.launch




class MainActivity : AppCompatActivity() {

    private lateinit var rbStudent: RadioButton
    private lateinit var rbSubject: RadioButton
    private lateinit var spinner: Spinner
    private lateinit var listCaption: TextView
    private lateinit var recyclerView: RecyclerView

    val db by lazy {
        Room.databaseBuilder(
            this,
            SchoolDatabase::class.java, "school.db"
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rbStudent = findViewById(R.id.rbStudent)
        rbSubject = findViewById(R.id.rbSubject)
        spinner = findViewById(R.id.spinner)
        listCaption = findViewById(R.id.listCaption)
        recyclerView = findViewById(R.id.recyclerView)

        val itemsSpinner = arrayListOf<String>()
        val itemsSpinner1 = arrayListOf<String>()
        val itemsRecycler = arrayListOf<String>()
        val dao = db.schoolDao;

        lifecycleScope.launch {
            var i = 0
            dao.getListOfStudents().forEach{
                itemsSpinner.add(it)
                i++
            }
            itemsSpinner.toArray()
        }

        rbStudent.setOnClickListener{
            listCaption.text = "Student's subjects"
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsSpinner)
            spinner.adapter = adapter
            // так же должен меняться выпадающий список
        }

        lifecycleScope.launch {
            var i = 0
            dao.getListOfSubjects().forEach{
                itemsSpinner1.add(it)
                i++
            }
            itemsSpinner1.toArray()
        }

        rbSubject.setOnClickListener{
            listCaption.text = "Students study"
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsSpinner1)
            spinner.adapter = adapter
            // также должен меняться выпадающий список
        }

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View?,
                position: Int, id: Long
            ) {
                lifecycleScope.launch {
                    var i = 0
                    itemsRecycler.clear()
                    if (rbStudent.isChecked){
                        dao.getListOfSubjectByStudent(itemsSpinner[position]).forEach {
                            itemsRecycler.add(it)
                        }
                        recyclerView.adapter = CustomAdapter(itemsRecycler)
                    }
                    if (rbSubject.isChecked){
                        dao.getListOfStudentsBySubject(itemsSpinner1[position]).forEach {
                            itemsRecycler.add(it)
                        }
                        recyclerView.adapter = CustomAdapter(itemsRecycler)
//                        itemsRecycler.clear()
                    }
                }

                Toast.makeText(getApplicationContext(), "При выборе должен меняться список на предметы выбранного ученика или учеников, изучающих выбранный предмет", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // TODO Auto-generated method stub
            }
        }


        lifecycleScope.launch {
            DataExample.directors.forEach { dao.insertDirector(it) }
            DataExample.schools.forEach { dao.insertSchool(it) }
            DataExample.subjects.forEach { dao.insertSubject(it) }
            DataExample.students.forEach { dao.insertStudent(it) }
            DataExample.studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }
        }
    }

}
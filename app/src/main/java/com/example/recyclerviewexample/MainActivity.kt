package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        var todoList = mutableListOf(
            Todo("Learn android basics", false),
            Todo("Learn RecyclerView", true),
            Todo("Learn Spinner", true),
            Todo("Learn editTex", false),
            Todo("Learn Constraintlayout", false),
            Todo("Learn about Context", true),
            Todo("Learn Room", false),
            Todo("Learn View Binding", true),
            Todo("Learn Activity lifecycle", false),
            Todo("Learn Fragments", false),
            Todo("Learn Retrofit", false),
            Todo("Learn API", false)
        )

        val adapter = TodoAdapter(todoList)
        activityMainBinding.recyclerView.adapter = adapter
        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        activityMainBinding.btnSubmit.setOnClickListener {
            val title = activityMainBinding.etTask.text.toString()
            Toast.makeText(this, title, Toast.LENGTH_LONG).show()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }

    }
}
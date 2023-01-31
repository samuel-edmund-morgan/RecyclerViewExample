package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.TodoHolderBinding

class TodoAdapter(private var elements: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(val todoHolderBinding: TodoHolderBinding): RecyclerView.ViewHolder(todoHolderBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val bind = TodoHolderBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return TodoViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return  elements.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.todoHolderBinding.apply {
            titleText.text = elements[position].Title
            cbChecked.isChecked = elements[position].isChecked
        }
    }
}
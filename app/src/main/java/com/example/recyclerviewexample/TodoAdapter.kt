package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.TodoHolderBinding

class TodoAdapter : ListAdapter<Todo, TodoAdapter.TodoViewHolder>(DifferCallback()) {
    inner class TodoViewHolder(val todoHolderBinding: TodoHolderBinding): RecyclerView.ViewHolder(todoHolderBinding.root)

    // Starts implementing diffutil
    class DifferCallback  : DiffUtil.ItemCallback<Todo>(){
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.Title == newItem.Title
        }
        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val bind = TodoHolderBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return TodoViewHolder(bind)
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.todoHolderBinding.apply {
            titleText.text = getItem(position).Title
            cbChecked.isChecked = getItem(position).isChecked
        }
    }
}
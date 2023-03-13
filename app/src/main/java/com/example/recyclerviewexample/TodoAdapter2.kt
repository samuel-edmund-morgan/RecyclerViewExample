package com.example.recyclerviewexample

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.TodoHolderBinding


class TodoAdapter2  : RecyclerView.Adapter<TodoAdapter2.TodoViewHolder2>(){
    private lateinit var binding: TodoHolderBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter2.TodoViewHolder2 {
        binding= TodoHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder2()
    }

    override fun onBindViewHolder(holder: TodoViewHolder2, position: Int) {
        holder.setData(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount() = differ.currentList.size

    inner class TodoViewHolder2 : RecyclerView.ViewHolder(binding.root){
        fun setData(item : Todo){
            binding.apply {
                titleText.text = item.Title
                cbChecked.isChecked = item.isChecked
            }
        }

    }

    private val differCallback = object : DiffUtil.ItemCallback<Todo>(){
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return  oldItem.Title == newItem.Title
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

}
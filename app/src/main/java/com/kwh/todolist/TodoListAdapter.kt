package com.kwh.todolist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kwh.todolist.model.TodoModel
import java.text.SimpleDateFormat

class TodoListAdapter(val deleteItemClick: (TodoModel) -> Unit) :
    RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    private var todoItems: List<TodoModel> = listOf()

    override fun getItemCount(): Int {
        Log.d("MainActivity", "todoItem getItemCount !!: " + todoItems.size)
        return todoItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        val viewHolder = TodoViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todoModel = todoItems[position]
        todoModel.seq = position + 1
        val todoViewHolder = holder as TodoViewHolder
        todoViewHolder.bind(todoModel)
    }

    fun setTodoItems(todoItems: List<TodoModel>) {
        this.todoItems = todoItems
        Log.d("MainActivity", "todoItem setTodoItems !!: " + todoItems.size)
        notifyDataSetChanged()
    }

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tv_seq = itemView.findViewById<TextView>(R.id.tv_seq)
        private val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        private val tv_content = itemView.findViewById<TextView>(R.id.tv_content)
        private val tv_date = itemView.findViewById<TextView>(R.id.tv_date)
        private val iv_delete = itemView.findViewById<ImageView>(R.id.iv_delete)

        fun bind(todoModel: TodoModel) {
            tv_seq.text = todoModel.seq.toString()
            tv_title.text = todoModel.title
            tv_content.text = todoModel.content
            tv_date.text = todoModel.createDate.convertDateToString("yyyy.MM.dd HH:mm")

            iv_delete.setOnClickListener {
                deleteItemClick(todoModel)
            }
        }
    }
}

fun Long.convertDateToString(format: String): String{
    val simpleDateFormat = SimpleDateFormat(format)
    return simpleDateFormat.format(this)
}
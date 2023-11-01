package com.kwh.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.kwh.todolist.model.TodoModel
import com.kwh.todolist.viewmodel.TodoViewModel

class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.name

    private lateinit var todoViewModel: TodoViewModel

    private lateinit var todoListAdapter: TodoListAdapter
    private val todoItems: ArrayList<TodoModel> = ArrayList()

    private val recyclerview_list: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerview_list)
    }

    private val btn_add: Button by lazy {
        findViewById<Button>(R.id.btn_add)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initRecyclerview()
        initBtnAdd()
    }

    private fun initViewModel() {
        TODO("Not yet implemented")
    }

    private fun initRecyclerview() {
        TODO("Not yet implemented")
    }

    private fun initBtnAdd() {
        TODO("Not yet implemented")
    }
}
package com.kwh.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kwh.todolist.model.TodoModel
import com.kwh.todolist.repository.TodoRepository

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val todoRepository = TodoRepository(application)
    private var todoItems = todoRepository.getTodoListAll()

    fun getTodoListAll(): LiveData<List<TodoModel>> {
        return todoItems
    }

    fun insert(todoModel: TodoModel) {
        todoRepository.insert(todoModel)
    }

    fun delete(todoModel: TodoModel) {
        todoRepository.delete(todoModel)
    }
}
package com.kwh.todolist.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.kwh.todolist.dao.TodoDao
import com.kwh.todolist.database.TodoDatabase
import com.kwh.todolist.model.TodoModel

class TodoRepository(application: Application) {

    private var todoDatabase: TodoDatabase = TodoDatabase.getInstance(application)!!
    private var todoDao: TodoDao = todoDatabase.todoDao()
    private var todoItems: LiveData<List<TodoModel>> = todoDao.getTodoListAll()

    fun getTodoListAll(): LiveData<List<TodoModel>> {
        return todoItems
    }

    fun insert(todoModel: TodoModel) {
        try {
            val thread = Thread(
                Runnable {
                    todoDao.insert(todoModel)
                }).start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun delete(todoModel: TodoModel) {
        try {
            val thread = Thread(
                Runnable {
                    todoDao.delete(todoModel)
                })
            thread.start()
        } catch (e: Exception) {

        }

    }
}
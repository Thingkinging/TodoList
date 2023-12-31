package com.kwh.todolist.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.kwh.todolist.dao.TodoDao
import com.kwh.todolist.database.TodoDatabase
import com.kwh.todolist.model.TodoModel

/*
* 데이터베이스 혹은 네트워크 통신을 통하여 데이터를 얻는 기능을 분리
* ViewModel 에서는 이 Repository 를 통해 데이터를 얻는다
* */
class TodoRepository(application: Application) {

    //database, dao todoItems 를 각각 초기화
    private var todoDatabase: TodoDatabase = TodoDatabase.getInstance(application)!!
    private var todoDao: TodoDao = todoDatabase.todoDao()
    private var todoItems: LiveData<List<TodoModel>> = todoDao.getTodoListAll()

    fun getTodoListAll(): LiveData<List<TodoModel>> {
        return todoItems
    }

    fun insert(todoModel: TodoModel) {
        try {
            val thread =
                Thread(Runnable {  //별도 스레드를 통해 Room 데이터에 접근해야한다. 연산 시간이 오래 걸리는 작업은 메인 쓰레드가 아닌 별도의 쓰레드에서 하도록 되어있다. 그렇지 않으면 런타임에러 발생.
                    todoDao.insert(todoModel)
                }).start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun delete(todoModel: TodoModel) {
        try {
            val thread = Thread(Runnable {
                todoDao.delete(todoModel)
            })
            thread.start()
        } catch (e: Exception) {
        }
    }

}
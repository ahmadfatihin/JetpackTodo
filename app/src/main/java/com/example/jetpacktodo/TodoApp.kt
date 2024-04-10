package com.example.jetpacktodo

import android.app.Application
import androidx.room.Room
import com.example.jetpacktodo.database.TodoDatabase
import com.example.jetpacktodo.repositories.TodoRepo
import com.example.jetpacktodo.repositories.TodoRepoImpl
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class TodoApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(module {
                single {
                    Room
                        .databaseBuilder(this@TodoApp, TodoDatabase
                        ::class.java, "db")
                        .build()
                }
                single {
                    TodoRepoImpl(database = get())
                } bind TodoRepo::class
            })
        }
    }
}
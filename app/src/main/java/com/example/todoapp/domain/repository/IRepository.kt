package com.example.todoapp.domain.repository

import android.content.Context

interface IRepository {
    fun writeData(item: ArrayList<String>, context: Context)
    fun readData(context: Context): ArrayList<String>
}
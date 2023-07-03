package com.example.todoapp.domain.entities.interfaces

interface IList {
    fun setItems(items: ArrayList<String>)
    fun getItems(): ArrayList<String>
    fun addItem(item: String)
    fun removeAt(position: Int)
}
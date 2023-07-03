package com.example.todoapp.domain.entities.classes

import com.example.todoapp.domain.entities.interfaces.IList

class ItemList: IList {
    private var items = ArrayList<String>()

    override fun setItems(items: ArrayList<String>) {
        this.items = items
    }

    override fun getItems(): ArrayList<String> {
        return items
    }

    override fun addItem(item: String) {
        items.add(item)
    }

    override fun removeAt(position: Int) {
        items.removeAt(position)
    }
}
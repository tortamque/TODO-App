package com.example.todoapp.presentation.listeners

import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.domain.entities.interfaces.IList
import com.example.todoapp.domain.repository.IRepository

class AddItemClickListener(
    private val context: Context,
    private val binding: ActivityMainBinding,
    private val itemList: IList,
    private val repository: IRepository,
    private val arrayAdapter: ArrayAdapter<String>
) : View.OnClickListener {
    override fun onClick(view: View?) {
        val itemName: String = binding.textfield.text.toString()

        itemList.addItem(itemName)
        binding.textfield.setText("")
        repository.writeData(itemList.getItems(), context)
        arrayAdapter.notifyDataSetChanged()
    }
}
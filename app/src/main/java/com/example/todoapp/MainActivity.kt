package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.todoapp.data.repository.Repository
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.domain.entities.classes.ItemList
import com.example.todoapp.presentation.listeners.AddItemClickListener
import com.example.todoapp.presentation.listeners.DeleteItemClickListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val itemList = ItemList()
    private val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        itemList.setItems(repository.readData(this))
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemList.getItems())
        binding.listView.adapter = arrayAdapter

        val addItemClickListener = AddItemClickListener(applicationContext, binding, itemList, repository, arrayAdapter)
        binding.button.setOnClickListener(addItemClickListener)

        val deleteItemClickListener = DeleteItemClickListener(this, itemList, repository, arrayAdapter)
        binding.listView.setOnItemClickListener(deleteItemClickListener)
    }
}
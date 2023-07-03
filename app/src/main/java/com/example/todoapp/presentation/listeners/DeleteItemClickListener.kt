package com.example.todoapp.presentation.listeners

import android.app.AlertDialog
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.data.repository.Repository
import com.example.todoapp.domain.entities.classes.ItemList

class DeleteItemClickListener(
    private val activity: AppCompatActivity,
    private val itemList: ItemList,
    private val repository: Repository,
    private val arrayAdapter: ArrayAdapter<String>
) : AdapterView.OnItemClickListener {
    override fun onItemClick(adapterView: AdapterView<*>?, view: View?, position: Int, l: Long) {
        val alert = AlertDialog.Builder(activity)
        alert.setTitle("Delete")
        alert.setMessage("Do you want to delete this message?")
        alert.setCancelable(false)

        alert.setNegativeButton("No") { dialogInterface, _ ->
            dialogInterface.cancel()
        }

        alert.setPositiveButton("Yes") { dialogInterface, _ ->
            itemList.removeAt(position)
            arrayAdapter.notifyDataSetChanged()
            repository.writeData(itemList.getItems(), activity.applicationContext)
        }

        alert.create().show()
    }
}
package com.example.todoapp.data.repository

import android.content.Context
import com.example.todoapp.domain.repository.IRepository
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class Repository: IRepository {
    private val fileName = "info.dat"

    override fun writeData(item: ArrayList<String>, context: Context) {
        val fos: FileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        val oas = ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()
    }

    override fun readData(context: Context): ArrayList<String> {
        var itemList: ArrayList<String>
        try {
            val fis: FileInputStream = context.openFileInput(fileName)
            val ois = ObjectInputStream(fis)
            itemList = ois.readObject() as ArrayList<String>
        } catch (e: FileNotFoundException){
            itemList = ArrayList()
        }
        return itemList
    }
}
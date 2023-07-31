package org.demre.ei02m6registroconsumo.data.local

import androidx.lifecycle.LiveData

class Repositorio(private val itemDao:ItemDao) {
    suspend fun  insertItem(item:Item){
        itemDao.insertItem(item)

    }
    fun getItem():
            LiveData<List<Item>> {
        return itemDao.getAllItems()


    }
}
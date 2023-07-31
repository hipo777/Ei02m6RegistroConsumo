package org.demre.ei02m6registroconsumo.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
//Proporcionan métodos para consultar, actualizar, insertar y borrar datos en la base de datos.
@Dao
interface ItemDao {

    @Insert
    suspend fun insertItem(item:Item)

    @Query("SELECT*FROM table_item order by id ASC")
    fun getAllItems(): LiveData<List<Item>>

}
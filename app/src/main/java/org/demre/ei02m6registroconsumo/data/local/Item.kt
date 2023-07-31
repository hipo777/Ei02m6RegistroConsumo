package org.demre.ei02m6registroconsumo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//Las entidades de datos representan tablas de la base de datos de la app.
@Entity(tableName = "table_item")
data class Item(val nombre:String,val precio:Int, val cantidad:Int){
    @PrimaryKey(autoGenerate = true) var id:Long = 0
}